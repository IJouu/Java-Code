// �¥մ�
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Othello extends JFrame implements ActionListener {
    private OX oxBoard;
    private MenuItem black, white;
    private Othello() {
        super("Othello");
        Menu m;
        MenuBar mb;
        add(oxBoard = new OX(this));
        CloseWindow close = new CloseWindow(this, true);
        setMenuBar(mb = new MenuBar());
        mb.add(m = new Menu("�C��")).add(new MenuItem("�s�C��")).addActionListener(this);
        m.add(black = new MenuItem("�q���U�¤�")).addActionListener(this);
        m.add(white = new MenuItem("�q���U�դ�")).addActionListener(this);
        m.add(new MenuItem("����")).addActionListener(close);
        mb.add(new Menu("����")).add(new MenuItem("���󥻹C��")).addActionListener(this);
        addWindowListener(close);
        pack();
        setResizable(false);
        setVisible(true);
    }
    public static void main(String argv[]) {
        new Othello();
    }
    // implements the ActionListener interface
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("���󥻹C��")) {
            new ErrorDialog(this,"�{���]�p�¥մ�(ī�G��)�d��.\n�@��:�\���@��[�n�j�Ǹ�ިt");
        } else if (command.equals("�s�C��")) {
            oxBoard.newGame();
        } else if (command.equals("���q���U�¤�")) {
            oxBoard.setBlackPlayer(0);
            black.setLabel("�q���U�¤�");
        } else if (command.equals("�q���U�¤�")) {
            oxBoard.setBlackPlayer(1);
            black.setLabel("���q���U�¤�");
        } else if (command.equals("���q���U�դ�")) {
            oxBoard.setWhitePlayer(0);
            white.setLabel("�q���U�դ�");
        } else if (command.equals("�q���U�դ�")) {
            oxBoard.setWhitePlayer(1);
            white.setLabel("���q���U�դ�");
        }
    }
}
class OX extends Component implements MouseListener, MouseMotionListener, Runnable {
    private int[] board; // �L�����p,��F����ت�10*10�L��
    private int turn, diskdiff; // �{�b����i�U, �P�Ĥ誺�l�Ʈt��
    private OX parent; // �ѭ��@�ӽL���ܤƦӨ�
    private double val = -1000000; // ���p���L�����u�ժ��p
    private int hashval; // for hashtable
    private int[] legals; // �x�s���L���i�H�U���ۤ�
    public static final int EMPTY = 0x00; // �Ů�
    public static final int BLACK = 0x01; // �¤l
    public static final int WHITE = 0x02; // �դl
    public static final int STONE = 0x03; // �W����� or
    public static final int BOUND = 0x04; // ���
    public static final int ADEMP = 0x08; // �O�_�F���l�����I
    private static final Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR); // �b�Y���
    private static final Cursor hintCursor = new Cursor(Cursor.HAND_CURSOR); // ��δ��
    private static final Cursor thinkCursor = new Cursor(Cursor.WAIT_CURSOR); // �|����
    private static Dimension mySize = new Dimension(600,400); // �T�w�e�����j�p���e600,��400
    private static JFrame top; // �]�t�����󪺳̤W�hFrame
    private static Thread thinking; // �p�⤤��Thread
    private static final byte[] directions = {1,-1,10,-10,9,-9,11,-11}; // �@���}�C�U��8�Ӥ�V
    private static final int HASHSIZE = 63999979; // �p��64M���̤j���
    public static int whoPlayBlack, whoPlayWhite;
    public static final int HUMAN = 0, COMPUTER = 1;
    private static int newboard[] = { // �C���}�l���̪�e��
        BOUND,BOUND,BOUND,BOUND,BOUND,BOUND,BOUND,BOUND,BOUND,BOUND,
        BOUND,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,BOUND,
        BOUND,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,BOUND,
        BOUND,EMPTY,EMPTY,ADEMP,ADEMP,ADEMP,ADEMP,EMPTY,EMPTY,BOUND,
        BOUND,EMPTY,EMPTY,ADEMP,WHITE,BLACK,ADEMP,EMPTY,EMPTY,BOUND,
        BOUND,EMPTY,EMPTY,ADEMP,BLACK,WHITE,ADEMP,EMPTY,EMPTY,BOUND,
        BOUND,EMPTY,EMPTY,ADEMP,ADEMP,ADEMP,ADEMP,EMPTY,EMPTY,BOUND,
        BOUND,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,BOUND,
        BOUND,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,BOUND,
        BOUND,BOUND,BOUND,BOUND,BOUND,BOUND,BOUND,BOUND,BOUND,BOUND};
    public OX(JFrame p) {
        addMouseListener(this);
        addMouseMotionListener(this);
        top = p;
        board = new int[100];
        System.arraycopy(newboard, 0, board, 0, 100);
        turn = BLACK;
        legals = new int[] {34,43,56,65};
    }
    // �ƻsp�����A
    public OX(OX p) {
        board = new int[100];
        System.arraycopy(p.board, 0, board, 0, 100);
        turn = p.turn;
        diskdiff = p.diskdiff;
        val = -1000000;
    }
    public void setBlackPlayer(int who) {
        if (whoPlayBlack == who) return;
        if (whoPlayBlack == 0 && thinking == null && (hasLegal(turn) || hasLegal(turn^STONE))) {
            (thinking = new Thread(this)).start();
        }
        whoPlayBlack = who;
    }
    public void setWhitePlayer(int who) {
        if (whoPlayWhite == who) return;
        if (whoPlayWhite == 0 && thinking == null && (hasLegal(turn) || hasLegal(turn^STONE))) {
            (thinking = new Thread(this)).start();
        }
        whoPlayWhite = who;
    }
    // �ˬdpos�O�_�X�k
    boolean isLegal(int pos) {
        return isLegal(turn, pos);
    }
    // �ˬdside�o���C��,��_�U�bpos
    boolean isLegal(int side, int pos) {
        int opp = side^STONE;
        for (int i = 0, scan; i < 8; i++) {
            scan = pos+directions[i];
            if (board[scan] == opp) {
                    for (scan+=directions[i]; board[scan] == opp; scan+=directions[i]);
                    if ((board[scan] & side) != 0) { // �i������
                        return true;
                }
            }
        }
        return false;
    }
    // �ˬdside�O�_���X�k���ۤ�i�U
    boolean hasLegal(int side) {
        for (int i=11; i < 89; i++) {
            if ((board[i]==ADEMP) && isLegal(side, i)) {
                return true;
            }
        }
        return false;
    }
    // �U�bpos,�ç��ܽL�����c. �Ypos��0, ��ܦ��ۤ⬰pass
    boolean addMove(int pos) {
        int opp = turn^STONE;
        if (pos != 0) { // 0 ���pass
            int legal = diskdiff;
            for (int i = 0, scan; i < 8; i++) {
                scan = pos+directions[i];
                if (board[scan] == opp) { // ����V��F�ۼĤ誺�l
                    // ���L�s�򪺼Ĥ�l
                    for (scan += directions[i]; board[scan] == opp; scan+=directions[i]);
                    if (board[scan] == turn) { // �i������
                        // �N�Ҧ��Ĥ�l�ܦ��ڤ�l
                        for (int c = pos+directions[i]; c!=scan ;board[c]=turn, c+=directions[i], diskdiff+=2);
                    }
                }
            }
            if (diskdiff==legal) { // �p�G���S���Y��
                return false;
            }
            diskdiff++;
            board[pos] = turn;
            for (int i = 0; i < 8; i++) { // �]�w���I�Ǫ����I��ADEMP
                if (board[pos+directions[i]] == EMPTY) {
                    board[pos+directions[i]] = ADEMP;
                }
            }
        }
        turn = opp; // �����U�F
        diskdiff = -diskdiff;
        hashval=(hashval*64+(pos-11))%HASHSIZE;
        return true;
    }
    // Thread���i�J�I
    public void run() {
        setCursor(thinkCursor);
        for (;;) { // ��Ĥ��pass��,�ڤ�@���U
            if (turn==BLACK && whoPlayBlack == HUMAN) { // ���ˬd�O�_��ѤH�U
                break;
            }
            if (turn==WHITE && whoPlayWhite == HUMAN) { // ���ˬd�O�_��ѤH�U
                break;
            }
            addMove(best());
            repaint(); // ask winder manager to call paint() in another thread
            if (turn==BLACK && whoPlayBlack==HUMAN && hasLegal(turn)) { // �H�i�H�U�F
                break;
            }
            if (turn==WHITE && whoPlayWhite==HUMAN && hasLegal(turn)) { // �H�i�H�U�F
                break;
            }
            if (!hasLegal(turn) && !hasLegal(turn^STONE)) { // ���M�ۤv������U�F
                new ErrorDialog(top, "Game Over");
                break;
            }
            if (!hasLegal(turn)) {
                addMove(0);
            }
        }
        setCursor(normalCursor);
        thinking = null;
    }
    // The following 2 methods implement the MouseMotionListener interface
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {
        if (thinking != null) return;
        int row = e.getY() / 40;
        int col = e.getX() / 40;
        if (row >= 8 || col >= 8) {
            setCursor(normalCursor);
            return; // �W�L���
        }
        int pos = row*10 + col + 11;
        if (board[pos] == ADEMP && isLegal(turn, pos)) {
            setCursor(hintCursor);
        } else {
            setCursor(normalCursor);
        }
    }
    // The following 5 methods implement the MouseListener interface
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
        int row = e.getY()/40;
        int col = e.getX()/40;
        if (row >= 8 || col >= 8) return; // �W�L���
        if (thinking != null) return; // �q����Ҥ�
        int pos = row*10+col+11;
        if (board[pos] == ADEMP && addMove(pos)) { // ����m�i�H�U
            repaint();
            if (hasLegal(turn)) {
                if ((turn==WHITE && whoPlayWhite==COMPUTER) || (turn==BLACK && whoPlayBlack==COMPUTER)) { // let computer play
                    (thinking = new Thread(this)).start();
                }
            } else {
                if (!hasLegal(turn^STONE)) { // ���賣����U
                    new ErrorDialog(top, "Game Over");
                    return;
                }
                addMove(0); // ��褣��U,force pass
            }
        }
    }
    // �ѤO�j�z���䪺�D�Ȩ��
    private void eval() {
        val = diskdiff;
    }
    private void alphaBeta(int level) {
        if (legals == null) {
            findLegals();
        }
        for (int i = 0; i < legals.length; i++) {
            OX tmp = new OX(this);
            tmp.addMove(legals[i]);
            if (level < 1) {
                tmp.eval();
            } else {
                tmp.alphaBeta(level - 1);
            }
            // alphaBeta cut
            if (val < -tmp.val) {
                val = -tmp.val;
                for (OX p = parent; p != null;) {
                    if (val >= -p.val) { // ��⤣�|��ܳo������
                        return;
                    }
                    // ���W����h
                    p = p.parent;
                    if (p != null) p = p.parent;
                }
            }
        }
    }
    private void findLegals() {
        int count = 0;
        int[] tmp = new int[60];
        for (int i=11; i<89; i++) {
            if (board[i] == ADEMP && isLegal(turn, i)) {
                tmp[count++] = i;
            }
        }
        legals = new int[count];
        System.arraycopy(tmp, 0, legals, 0, count);
    }
    private int best() {
        int bestMove = 0;
        findLegals();
        val = -100000000;
        for (int i=0; i<legals.length; i++) {
            OX tmp = new OX(this);
            tmp.addMove(legals[i]);
            tmp.alphaBeta(3);
            if (-tmp.val > val) {
                bestMove = legals[i];
                val = -tmp.val;
            }
        }
        return bestMove;
    }
    // override paint() defined in Component
    public void paint(Graphics g) {
        int black, white;
        black = white = 0;
        for (int i = 0; i <= 8; i++) {  // draw grids
            g.drawLine(0, i*40, 320, i*40);
            g.drawLine(i*40, 0, i*40, 320);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int pos = i*10 + j + 11;
                if ((board[pos] & BLACK) != 0) {
                    g.fillOval(j*40,i*40,40,40);
                    black++;
                } else if ((board[pos] & WHITE) != 0) {
                    g.drawOval(j*40,i*40,40,40);
                    white++;
                }
            }
        }
        g.drawString("BLACK:"+black, 400, 100);
        g.drawString( "WHITE:"+white, 400, 150);
    }
    public void newGame() {
        System.arraycopy(newboard, 0, board, 0, 100);
        turn = BLACK;
        hashval = diskdiff = 0;
        if (thinking != null) {
            try {
                thinking.join();
            } catch(Exception epp) {}
        }
        if (whoPlayBlack == COMPUTER) {
            (thinking = new Thread(this)).start();
        }
        repaint();
    }
    // override getPreferredSize defined in java.lang.Component,
    // so that the Component has proper size on screen
    public Dimension getPreferredSize() {
        return mySize;
    }
    // override hashCode() in java.lang.Object
    public int hashCode() {
        return hashval;
    }
    public boolean equals(Object o) {
        if (!(o instanceof OX)) return false;
        OX t = (OX) o;
        for (int i=11; i<89; i++) {
            if (board[i] != t.board[i]) return false;
        }
        return true;
    }
}
// WindowAdapter implements the WindowLister interface
// We extends WindowAdapter to reduce the line numer of code
class CloseWindow extends WindowAdapter implements ActionListener {
    private Window target;
    private boolean exit;
    public CloseWindow(Window target, boolean exit) {
        this.target = target;
        this.exit = exit;
    }
    public CloseWindow(Window target) {
        this.target = target;
    }
    public void windowClosing(WindowEvent e) {
        target.dispose();
        if (exit) System.exit(0);
    }
    public void actionPerformed(ActionEvent e) {
        target.dispose();
        if (exit) System.exit(0);
    }
}
class AddConstraint {
    public static void addConstraint(Container container, Component component,
          int grid_x, int grid_y, int grid_width, int grid_height,
          int fill, int anchor, double weight_x, double weight_y,
          int top, int left, int bottom, int right) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = grid_x; c.gridy = grid_y;
        c.gridwidth = grid_width; c.gridheight = grid_height;
        c.fill = fill; c.anchor = anchor;
        c.weightx = weight_x; c.weighty = weight_y;
        c.insets = new Insets(top,left,bottom,right);
        ((GridBagLayout)container.getLayout()).setConstraints(component,c);
        container.add(component);
    }
}
class ErrorDialog extends JDialog {
    public ErrorDialog(JFrame parent, String all[]) {
        this(parent, all, null);
    }
    public ErrorDialog(JFrame parent, String all[], String msg) {
        super(parent,"",true);
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<all.length; i++) {
            sb.append(all[i]);
            sb.append('\n');
        }
        if (msg!=null) {
            sb.append(msg);
        }
        setup(parent, sb.toString());
    }
    public ErrorDialog(JFrame parent, String message) {
        super(parent,"",true);
        setup(parent, message);
    }
    private void setup(JFrame parent, String message) {
        this.getContentPane().setLayout(new GridBagLayout());
        int row=0, col=0, i, width=0;
        Font font = new Font("Serif", Font.PLAIN, 16);
        char c=' ';
        for (i=0; i<message.length(); i++) {
            c = message.charAt(i);
            if (c=='\n') {
               row++;
               if (width>col) {
                   col = width;
               }
               width=0;
            } else if (c=='\t') {
                width += 7-width%7;
            } else {
                if (c>0x00FF) {
                    width+=2;
                } else {
                    width++;
                }
            }
        }
        if (c!='\n') {
           row++;
           if (width>col) {
               col = width;
           }
        }
        col++;
        // �Ʊ�����X�Ӥ��n�Ӥj�ΤӤp
        row = (row>24) ? 24 : row;
        if (row<5) {
            row=5;
        }
        if (col<20) {
            col = 20;
        }
        TextArea tx = new TextArea(message,row,col);
        tx.setEditable(false);
        tx.setFont(font);
        AddConstraint.addConstraint(this.getContentPane(), tx, 0, 0, 1, 1,
            GridBagConstraints.BOTH,
            GridBagConstraints.NORTHWEST,
            1,1,0,0,0,0);
        Button b = new Button("�T�w");
        b.setFont(font);
        AddConstraint.addConstraint(this.getContentPane(), b, 0, 1, 1, 1,
            GridBagConstraints.HORIZONTAL,
            GridBagConstraints.CENTER,
            1,0,0,0,0,0);
        CloseWindow cw = new CloseWindow(this);
        this.addWindowListener(cw);
        b.addActionListener(cw);
        pack();
        setVisible(true);
    }
}
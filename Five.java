import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Five extends JFrame implements ActionListener{
    private Chess chessBoard;
    private MenuItem black, white;
    private Five() {
        super("Five");
        Menu m;
        MenuBar mb;
        add(chessBoard = new Chess(this));
        CloseWindow close = new CloseWindow(this, true);
        setMenuBar(mb = new MenuBar());
        mb.add(m = new Menu("遊戲")).add(new MenuItem("新遊戲")).addActionListener(this);
        m.add(black = new MenuItem("電腦下黑方")).addActionListener(this);
        m.add(white = new MenuItem("電腦下白方")).addActionListener(this);
        m.add(new MenuItem("結束")).addActionListener(close);
        mb.add(new Menu("說明")).add(new MenuItem("關於本遊戲")).addActionListener(this);
        addWindowListener(close);
        pack();
        setResizable(false);
        setVisible(true);
    }
    public static void main(String argv[]) {
        new Five();
    }
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("關於本遊戲")) {
            new ErrorDialog(this,"程式設計黑白棋(蘋果花)範例.\n作者:俞旭昇於暨南大學資管系");
        } else if (command.equals("新遊戲")) {
            oxBoard.newGame();
        } else if (command.equals("ˇ電腦下黑方")) {
            oxBoard.setBlackPlayer(0);
            black.setLabel("電腦下黑方");
        } else if (command.equals("電腦下黑方")) {
            oxBoard.setBlackPlayer(1);
            black.setLabel("ˇ電腦下黑方");
        } else if (command.equals("ˇ電腦下白方")) {
            oxBoard.setWhitePlayer(0);
            white.setLabel("電腦下白方");
        } else if (command.equals("電腦下白方")) {
            oxBoard.setWhitePlayer(1);
            white.setLabel("ˇ電腦下白方");
        }
    }
}
class Five extends Component implements MouseListener, MouseMotionListener, Runnable {
    private int[] board;
    private int turn, diskdiff;
    private Chess parent;
    private double val = -1000000;
    private int hashval;
    private int[] legals;
    public static final int EMPTY = 0x00; 
    public static final int BLACK = 0x01; 
    public static final int WHITE = 0x02;
    public static final int STONE = 0x03;
    public static final int BOUND = 0x04;
    public static final int ADEMP = 0x08;
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.Random;

public class Ballgame1 extends JFrame implements ActionListener {
    int count; // �p�����
    int ballnum = 8; // �`�y��
    boolean[] board = {false, false, false, false, false, false, false, false, false}; // ���]�S��L���خجOfalse�A�Ϥ�true
    int nowlevel = (int)(Math.random() * 4 + 1); // �C�����šA���ŶV���A�V���뤤
    JLabel level; // ��ܥثe�C������
    JLabel score; // ��ܤ���
    JLabel ball; // ��ܳѾl�y��
    JButton[] button = new JButton[9];
    public void init() { // ���m
        for (int i = 0; i < 9; i++) {
            board[i] = false;
            button[i].setText(Integer.toString(i + 1));
        }
        count = 0;
        ballnum = 8;
        nowlevel = (int)(Math.random() * 4 + 1);
    }
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // ���o�Y�ƥ�o��
        if (command.equals("Start")) {
            init();
        } else if (command.equals("1") && ballnum > 0) {
            onHit(1);
            ballnum--;
        } else if (command.equals("2") && ballnum > 0) {
            onHit(2);
            ballnum--;
        } else if (command.equals("3")  && ballnum > 0) {
            onHit(3);
            ballnum--;
        } else if (command.equals("4") && ballnum > 0) {
            onHit(4);
            ballnum--;
        } else if (command.equals("5") && ballnum > 0) {
            onHit(5);
            ballnum--;
        } else if (command.equals("6") && ballnum > 0) {
            onHit(6);
            ballnum--;
        } else if (command.equals("7") && ballnum > 0) {
            onHit(7);
            ballnum--;
        } else if (command.equals("8") && ballnum > 0) {
            onHit(8);
            ballnum--;
        } else if (command.equals("9") && ballnum > 0) {
            onHit(9);
            ballnum--;
        } else if (command.equals("X") && ballnum > 0) {
            JOptionPane.showMessageDialog(null, "You have already struck it!");
            ballnum--;
        } else if (ballnum == 0) {
            JOptionPane.showMessageDialog(null, "You don't have any ball!  Please Click Start!");
            String message = "You get " + count + " points";
            JOptionPane.showMessageDialog(this, message);
        }
        score.setText(Integer.toString(count));
        ball.setText(Integer.toString(ballnum) + " / 8" );
        if (command.equals(" ")) {
            JOptionPane.showMessageDialog(null, "Please Click Start!");
        } else {
            level.setText(Integer.toString(nowlevel));
        }

    }
    public boolean onHit(int num) {
        int hit = (int)(Math.random() * (nowlevel + 1));
        if (board[num - 1] == true) {
            return true;
        } else if (hit == 1) {
            count++;
            JOptionPane.showMessageDialog(null, "Strike");
            board[num - 1] = true;
            button[num - 1].setText("X");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Miss");
            return false;
        }
    }
    public Ballgame1() {
        this.setTitle("Ball Game"); // �]���D
        this.setSize(500, 500); // �]�����j�p
        this.setLayout(new GridLayout(5,3));
        JLabel playerlevel = new JLabel("Level", JLabel.CENTER);
        playerlevel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        level = new JLabel("-", JLabel.CENTER);
        level.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        JButton start = new JButton("Start");
        start.addActionListener(this);
        this.add(playerlevel);
        this.add(level);
        this.add(start);
        /*button[0] = new JButton(" ");
        button[1] = new JButton(" ");
        button[2] = new JButton(" ");
        button[3] = new JButton(" ");
        button[4] = new JButton("5");
        button[5] = new JButton("6");
        button[6] = new JButton("7");
        button[7] = new JButton("8");
        button[8] = new JButton("9");*/
        for (int i = 0; i < 9; i++) {
            button[i] = new JButton(" ");
            button[i].addActionListener(this);
            this.add(button[i]);
        }
        JLabel playerscore = new JLabel("Score", JLabel.CENTER);
        playerscore.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        score = new JLabel("0", JLabel.CENTER);
        score.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        ball = new JLabel("8 / 8", JLabel.CENTER);
        ball.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        this.add(ball);
        this.add(playerscore);
        this.add(score);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] argc) {
        new Ballgame1();
    }
}

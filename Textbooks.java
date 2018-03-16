import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class Textbooks extends JFrame implements ActionListener {
    public void actionPerformed(ActionEvent e) {

    }
    public Textbooks() {
        this.setTitle("Ball Game"); // 設標題
        this.setSize(500, 500); // 設視窗大小
        this.setLayout(new GridBagLayout());

        JLabel show = new JLabel("show", JLabel.CENTER);
        GridBagConstraints sh = new GridBagConstraints();
        sh.gridx = 0;
        sh.gridy = 0;
        sh.gridwidth = 5;
        sh.gridheight = 1;
        sh.weightx = 0;
        sh.weighty = 0;
        sh.fill = GridBagConstraints.NONE;
        sh.anchor = GridBagConstraints.CENTER;
        this.add(show, sh);

        JTextField input = new JTextField();
        GridBagConstraints in = new GridBagConstraints();
        in.gridx = 0;
        in.gridy = 2;
        in.gridwidth = 5;
        in.gridheight = 1;
        in.weightx = 0;
        in.weighty = 0;
        in.fill = GridBagConstraints.BOTH;
        in.anchor = GridBagConstraints.CENTER;
        this.add(input, in);

        JButton[] button = new JButton[5];
        button[0] = new JButton("add");
        button[1] = new JButton("delete");
        button[2] = new JButton("modify");
        button[3] = new JButton("search");
        button[4] = new JButton("print");
        for (int i = 0; i < 5; i++) {
            GridBagConstraints bu = new GridBagConstraints();
            bu.gridx = i;
            bu.gridy = 3;
            bu.gridwidth = 1;
            bu.gridheight = 1;
            bu.weightx = 0;
            bu.weighty = 0;
            bu.fill = GridBagConstraints.BOTH;
            bu.anchor = GridBagConstraints.CENTER;
            this.add(button[i], bu);
        }

        JLabel[] label1 = new JLabel[5];
        JLabel[] label2 = new JLabel[5];
        for (int i = 0; i < 5; i++) {
            label1[i] = new JLabel("空");
            GridBagConstraints la1 = new GridBagConstraints();
            la1.gridx = i;
            la1.gridy = 4;
            la1.gridwidth = 1;
            la1.gridheight = 10;
            la1.weightx = 0;
            la1.weighty = 0;
            la1.fill = GridBagConstraints.BOTH;
            la1.anchor = GridBagConstraints.CENTER;
            this.add(label1[i], la1);
        }
        for (int i = 0; i < 5; i++) {
            label2[i] = new JLabel("空");
            GridBagConstraints la2 = new GridBagConstraints();
            la2.gridx = i;
            la2.gridy = 14;
            la2.gridwidth = 1;
            la2.gridheight = 10;
            la2.weightx = 0;
            la2.weighty = 0;
            la2.fill = GridBagConstraints.BOTH;
            la2.anchor = GridBagConstraints.CENTER;
            this.add(label2[i], la2);
        }
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] argc) {
        new Textbooks();
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class Secret1 extends JFrame implements ActionListener {
    JLabel label;
    String engnum;
    JTextField input;
    public void actionPerformed(ActionEvent e) {
        String token = e.getActionCommand();
        if (token.equals("�����")) {
            try {
                int x = Integer.parseInt(engnum);
                engnum = reverse(engnum);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Number Only !");
            }
        } else if (token.equals("�j�p�g")) {
            try {
                engnum = change(engnum);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Engish Only !");
            }
        } else if (token.equals("�ɼ�")) {
            try {
                int x = Integer.parseInt(engnum);
                engnum = complement(engnum);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Number Only !");
            }
        } else if (token.equals("AZ�A��")) {
            try {
                engnum = constract(engnum);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Engish Only !");
            }
        } else {
            engnum = token;
            if (engnum.charAt(0) == '-') {
                JOptionPane.showMessageDialog(null, "�п�J>=0����� !");
                return;
            }
        }
        if (token.equals("���s")) {
            init();
        } else {
            label.setText(engnum);
            input.setText("");
        }
    }
    public String change(String x) throws Exception {
        String result = "";
        char ch;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) >= 65 && x.charAt(i) <= 90) {
                ch = (char)(x.charAt(i) + 32);
            } else if (x.charAt(i) >= 97 && x.charAt(i) <= 122) {
                ch = (char)(x.charAt(i) - 32);
            } else {
                throw new Exception();
            }
            result = result + ch;
        }
        return result;
    }
    // ½��
    public String reverse(String data) {
        String tmp = "";
        int i = data.length()-1;
        while ( i >= 0) {
            tmp = tmp + data.charAt(i);
            i--;
        }
        return tmp;
    }
    // �ɼ�
    public String complement(String data) {
        String result = "";
        int i = 0;
        while (i < data.length()) {
            result = result + (9 - (data.charAt(i) - '0'));
            i++;
        }
        return result;
    }
    // AZ�A��
    // ASCII    A-65  Z-90 a-97 z-122
    public String constract(String x) throws Exception {
      String result = "";
      char ch;
      for (int i = 0; i < x.length(); i++) {
          if (x.charAt(i) >= 65 && x.charAt(i) <= 90) {
              ch = (char)(155 - x.charAt(i));
          } else if (x.charAt(i) >= 97 && x.charAt(i) <= 122) {
              ch = (char)(219 - x.charAt(i));
          } else {
              throw new Exception();
          }
          result = result + ch;
      }
      return result;
    }
    public void init() {
        label.setText(" ");
    }
    public Secret1() {
        //set layout size
        this.setSize(500,500);
        this.setLayout(new GridLayout(3, 3));
        JButton numReverse = new JButton("�����");
        numReverse.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        numReverse.addActionListener(this);
        input = new JTextField();
        input.addActionListener(this);
        JButton Aachange = new JButton("�j�p�g");
        Aachange.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        Aachange.addActionListener(this);
        JButton complement = new JButton("�ɼ�");
        complement.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        complement.addActionListener(this);
        JButton reset = new JButton("���s");
        reset.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        reset.addActionListener(this);
        JButton AZchange = new JButton("AZ�A��");
        AZchange.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        AZchange.addActionListener(this);
        label = new JLabel("",JLabel.CENTER);
        label.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        JLabel label0 = new JLabel("(��w��)",JLabel.CENTER);
        label0.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));

        this.add(label0);
        this.add(label);
        this.add(new JLabel(""));
        this.add(numReverse);
        this.add(input);
        this.add(Aachange);
        this.add(complement);
        this.add(reset);
        this.add(AZchange);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] argv) {
        new Secret1();
    }
}

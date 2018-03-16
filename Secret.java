import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
public class Secret extends JFrame implements ActionListener {
    JLabel label;
    JTextField input;
    String s = "";
    public void actionPerformed(ActionEvent e) {
        String token = e.getActionCommand();
        if(token.equals("½���")) {
            if (s.charAt(0) == '-') {
                JOptionPane.showMessageDialog(null, "�п�J>=0�����");
            } else {
                try {
                    int x = Integer.parseInt(s);
                    s = reverse(s);
                    label.setText(s);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "�n�Ʀr�~�వ��");
                }
            }

        } else if (token.equals("�ɼ�")) {
            if (s.charAt(0) == '-') {
                JOptionPane.showMessageDialog(null, "�п�J>=0�����");
            } else {
                try {
                    int x = Integer.parseInt(s);
                    s = complement(s);
                    label.setText(s);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "�n�Ʀr�~�వ��");
                }
            }
        } else if (token.equals("�j�p�g")) {
            try {
                s = change(s);
                label.setText(s);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "should be Engish!!");
            }
        } else if (token.equals("AZ�A��")) {
           try {
                s = contrast(s);
                label.setText(s);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "should be Engish!!");
            }
        } else if (token.equals("���s")) {
            label.setText("");
        } else {
            s = token;
            label.setText(s);
        }
        input.setText("");
    }
    // ½��
    public String reverse(String x) {
        String result = "";
        for (int i = 0; i < x.length(); i++) {
            result = x.charAt(i) + result;
        }
        return result;
    }
    // �ɼ�
    public String complement(String x) {
        String result = "";
        for (int i = 0; i < x.length(); i++) {
            result = result + ('9'-x.charAt(i));
        }
        return result;
    }
    // �j�p�g
    // ASCII    A-65  Z-90 a-97 z-122
    public String change(String x) throws Exception{
        String result = "";
        char ch;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) >= 'A' && x.charAt(i)<= 'Z') {
                ch = (char) (x.charAt(i)+32);
                result = result + ch;
            } else  if (x.charAt(i) >= 'a' && x.charAt(i)<= 'z'){
                ch = (char) (x.charAt(i)-32);
                result = result + ch;
            } else if (x.charAt(i) >= '0' && x.charAt(i)<= '9'){
                throw new Exception();
            }
        }
        return result;
    }
    // AZ�A��
    // ASCII    A-65  Z-90 a-97 z-122
    public String contrast(String x) throws Exception{
        String result = "";
        char ch;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) >= 'A' && x.charAt(i)<= 'Z') {
                ch = (char) (155-x.charAt(i));
                result = result + ch;
            } else if (x.charAt(i) >= 'a' && x.charAt(i)<= 'z'){
                ch = (char) (219-x.charAt(i));
                result = result + ch;
            } else if (x.charAt(i) >= '0' && x.charAt(i)<= '9'){
                throw new Exception();
            }
        }
        return result;
    }
    public Secret() {
        //set layout size
        this.setSize(800,800);
        this.setLayout(new GridLayout(3, 3));
        JButton reverse = new JButton("½���");
        reverse.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
        reverse.addActionListener(this);
        JButton complement = new JButton("�ɼ�");
        complement.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
        complement.addActionListener(this);
        JButton change = new JButton("�j�p�g");
        change.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
        change.addActionListener(this);
        JButton contrast = new JButton("AZ�A��");
        contrast.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
        contrast.addActionListener(this);
        JButton reset = new JButton("���s");
        reset.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
        reset.addActionListener(this);
        input = new JTextField();
        input.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
        input.addActionListener(this);
        JLabel left = new JLabel("(��w��)",JLabel.CENTER);
        left.setFont(new Font(Font.MONOSPACED,Font.BOLD,60));
        this.add(left);
        label = new JLabel("",JLabel.CENTER);
        label.setFont(new Font(Font.MONOSPACED,Font.BOLD,80));
        this.add(label);
        JLabel right = new JLabel("");
        this.add(right);
        this.add(reverse);
        this.add(input);
        this.add(change);
        this.add(complement);
        this.add(reset);
        this.add(contrast);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] argv) {
        new Secret();
    }
}

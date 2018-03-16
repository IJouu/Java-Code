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
        if(token.equals("翻轉數")) {
            if (s.charAt(0) == '-') {
                JOptionPane.showMessageDialog(null, "請輸入>=0的整數");
            } else {
                try {
                    int x = Integer.parseInt(s);
                    s = reverse(s);
                    label.setText(s);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "要數字才能做喔");
                }
            }

        } else if (token.equals("補數")) {
            if (s.charAt(0) == '-') {
                JOptionPane.showMessageDialog(null, "請輸入>=0的整數");
            } else {
                try {
                    int x = Integer.parseInt(s);
                    s = complement(s);
                    label.setText(s);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "要數字才能做喔");
                }
            }
        } else if (token.equals("大小寫")) {
            try {
                s = change(s);
                label.setText(s);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "should be Engish!!");
            }
        } else if (token.equals("AZ顛倒")) {
           try {
                s = contrast(s);
                label.setText(s);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "should be Engish!!");
            }
        } else if (token.equals("重新")) {
            label.setText("");
        } else {
            s = token;
            label.setText(s);
        }
        input.setText("");
    }
    // 翻轉
    public String reverse(String x) {
        String result = "";
        for (int i = 0; i < x.length(); i++) {
            result = x.charAt(i) + result;
        }
        return result;
    }
    // 補數
    public String complement(String x) {
        String result = "";
        for (int i = 0; i < x.length(); i++) {
            result = result + ('9'-x.charAt(i));
        }
        return result;
    }
    // 大小寫
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
    // AZ顛倒
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
        JButton reverse = new JButton("翻轉數");
        reverse.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
        reverse.addActionListener(this);
        JButton complement = new JButton("補數");
        complement.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
        complement.addActionListener(this);
        JButton change = new JButton("大小寫");
        change.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
        change.addActionListener(this);
        JButton contrast = new JButton("AZ顛倒");
        contrast.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
        contrast.addActionListener(this);
        JButton reset = new JButton("重新");
        reset.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
        reset.addActionListener(this);
        input = new JTextField();
        input.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
        input.addActionListener(this);
        JLabel left = new JLabel("(⊙w⊙)",JLabel.CENTER);
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

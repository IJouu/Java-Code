import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class GUIDemo4 extends JFrame implements ActionListener{
    JLabel label;
    int count = 0;
    JTextField input;
    // override method from ActionListener
    // ActionListener 監聽事件的反應
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if (command.equals("+")) {
            count++;
        } else if(command.equals("-")) {
            count--;
        } else if(command.equals("exit")) {
            System.exit(0);
        }else if(command.equals("reset")){
            count = 0;
            JOptionPane.showMessageDialog(null, "has been reseted!");
        }else if(command.equals("+10")){
            count += 10;
        }else if(command.equals("-10")){
            count -= 10;
        }else{
            count = Integer.parseInt(command);
        }
        input.setText(" ");
        label.setText(Integer.toString(count));
        
    }
    public GUIDemo4(){
        // 設定標題
        this.setTitle("GUIDemo");
        this.setSize(500, 500);
        this.setLayout(new GridLayout(3, 3));
        this.add(new JLabel(""));
        // Label
        label = new JLabel("0", JLabel.CENTER);
        label.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        this.add(label);
        this.add(new JLabel(""));
        
        // 設定 + 號按鈕
        JButton plus = new JButton("+");
        plus.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        plus.addActionListener(this);
        this.add(plus);
        
        input = new JTextField();
        input.addActionListener(this);
        this.add(input);
        
        // 設定 - 號按鈕
        JButton minus = new JButton("-");
        minus.addActionListener(this);
        this.add(minus);
        
        // -10按鈕
        JButton minus10 = new JButton("-10");
        minus10.addActionListener(this);
        this.add(minus10);

        // reset button
        JButton reset = new JButton("reset");
        reset.addActionListener(this);
        this.add(reset);
        
        // +10按鈕
        JButton plus10 = new JButton("+10");
        plus10.addActionListener(this);
        this.add(plus10);

        // 設定 MenuBar、Menu、MenuItem，再把各自 add 到其屬於的位置
        JMenuBar mb = new JMenuBar();
        this.setJMenuBar(mb);
        JMenu file = new JMenu("file(F)");
        mb.add(file);
        JMenuItem end = new JMenuItem("exit");
        file.add(end);
        end.addActionListener(this);

        // 讓視窗可視化
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] argc){
        new GUIDemo4();
    }
}
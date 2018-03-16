import java.awt.*;
import javax.swing.*;
 
public class GUIDemo1 { 
    public static void main(String[] args) { 
        JFrame demo = new JFrame();
        demo.setSize(400, 300); // 設定視窗的大小
        // 設定視窗標題列的關閉按鈕結束程式執行
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 呼叫了 setDefaultCloseOperation
        // EXIT_ON_CLOSE 當參數
        JCheckBox checkbox = new JCheckBox("JCheckBox");
        JRadioButton radiobutton = new JRadioButton("JRadiobutton");
        JButton button = new JButton("JButton");
        JLabel label = new JLabel("JLabel");
        JTextArea textarea = new JTextArea("JTextArea");
        // 呼叫 getContentPane() 方法取得 JFrame 的 contentPane 物件
        demo.getContentPane().add(BorderLayout.EAST, checkbox);
        demo.getContentPane().add(BorderLayout.WEST, radiobutton);
        demo.getContentPane().add(BorderLayout.SOUTH, button);
        demo.getContentPane().add(BorderLayout.NORTH , label);
        demo.getContentPane().add(BorderLayout.CENTER, textarea);
         
        demo.setVisible(true); // 呼叫 demo 的 setVisible() 方法，並設置成 true
    }
}
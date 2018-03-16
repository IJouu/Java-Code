import java.awt.*;
import javax.swing.*;

public class GUIDemo2 {
    public static void main(String[] args) {
        JFrame demo = new JFrame();
        demo.setSize(400, 300);
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.getContentPane().setLayout(new FlowLayout()); // 呼叫 setLayout() 方法，設定所要採用的版面編排方式

        for (int i = 0; i < 27; i++) {
            JButton b = new JButton("" + i);
            demo.add(b);
        }

        demo.setVisible(true);
    }
}


/** BorderLayout    區域式版面配置
    FlowLayout      流動式版面配置
    CardLayout      卡片式版面配置
    GridLayout      格子式版面配置     
    GridBagLayout   帶狀式版面配置
    BoxLayout       盒子式版面配置



**/

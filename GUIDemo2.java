import java.awt.*;
import javax.swing.*;

public class GUIDemo2 {
    public static void main(String[] args) {
        JFrame demo = new JFrame();
        demo.setSize(400, 300);
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.getContentPane().setLayout(new FlowLayout()); // �I�s setLayout() ��k�A�]�w�ҭn�ĥΪ������s�Ƥ覡

        for (int i = 0; i < 27; i++) {
            JButton b = new JButton("" + i);
            demo.add(b);
        }

        demo.setVisible(true);
    }
}


/** BorderLayout    �ϰ즡�����t�m
    FlowLayout      �y�ʦ������t�m
    CardLayout      �d���������t�m
    GridLayout      ��l�������t�m     
    GridBagLayout   �a���������t�m
    BoxLayout       ���l�������t�m



**/

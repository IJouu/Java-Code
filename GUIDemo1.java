import java.awt.*;
import javax.swing.*;
 
public class GUIDemo1 { 
    public static void main(String[] args) { 
        JFrame demo = new JFrame();
        demo.setSize(400, 300); // �]�w�������j�p
        // �]�w�������D�C���������s�����{������
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �I�s�F setDefaultCloseOperation
        // EXIT_ON_CLOSE ��Ѽ�
        JCheckBox checkbox = new JCheckBox("JCheckBox");
        JRadioButton radiobutton = new JRadioButton("JRadiobutton");
        JButton button = new JButton("JButton");
        JLabel label = new JLabel("JLabel");
        JTextArea textarea = new JTextArea("JTextArea");
        // �I�s getContentPane() ��k���o JFrame �� contentPane ����
        demo.getContentPane().add(BorderLayout.EAST, checkbox);
        demo.getContentPane().add(BorderLayout.WEST, radiobutton);
        demo.getContentPane().add(BorderLayout.SOUTH, button);
        demo.getContentPane().add(BorderLayout.NORTH , label);
        demo.getContentPane().add(BorderLayout.CENTER, textarea);
         
        demo.setVisible(true); // �I�s demo �� setVisible() ��k�A�ó]�m�� true
    }
}
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Queue{
    int head, tail, size; // size ����Ƽ�
    int[] data = new int[20]; // �]�@�Ӱ}�C
    public void add(int x){ // �[�J���
        data[tail++] = x; // �W�[��Ƥ��e��x
        tail %= data.length; // ��z��Ƥ��e
        size++; // ��ƼƼW�[
    }
    public int remove(){ // ���X�β������
        data[head++] = -1;
        head %= data.length; // ��z��Ƥ��e
        size--; // ��Ƽƴ��
        return -1;
    }
    public boolean isEmpty(){ // 0�N�O�S�����
        return size == 0;
    }
    public boolean isFull(){ //��}�C�x��10�Ӹ�ƮɴN���F
        return size == 20;
    }
    public int Size(){
        return size;
    }
} 
public class J4 extends JFrame implements ActionListener {
    JLabel[] label = new JLabel[20]; // �ŧi��������A��J10�Ӽ���
    JTextField input; // ��J��r���
    Queue s = new Queue();
    //set Label
    public void CreateJLabel() {
        for (int i = 0; i < 20; i++) {
            s.data[i] = -1; 
            if (i % 2 == 0)
                label[i] = new JLabel("��", JLabel.CENTER);
            else 
                label[i] = new JLabel("������", JLabel.CENTER);
            label[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 30)); 
            this.add(label[i]); 
        }
    }
    // �� Queue ���e�]�w��Label
    public void SetJLabelResult() {
        for (int i = 0; i < 20; i++) {
            if (s.data[i] == -1)
                label[i].setText("��");
            else
                label[i].setText(Integer.toString(s.data[i]));
        }
    }
    // �]�w��J��Ұ��檺�ʧ@�A�A
    public void actionPerformed(ActionEvent e) {
        String token = e.getActionCommand();
        // �p�G�O"����"�B��ƼƤj��1�A�h�R��Queue
        if (token.equals("Done") && s.Size() >= 1) { 
            s.remove();
        // �p�G�O"����"�B��ƼƵ���0�A�Y�L��ƥi��=>�ŭ�
        } else if (token.equals("Done") && s.Size() == 0) { 
            JOptionPane.showMessageDialog(null, "�{�b�O�ŭȭ� (��???��)"); 
        } else {
            int val; // �]���val
            // �ҥ~�B�z
            try { // try�|��X�ҥ~���ԭz�y
                val = Integer.parseInt(token);
                if (val < 0) { // �p�Gval�p��0
                    JOptionPane.showMessageDialog(null, "��� �п�J����� QAQ");
                }
                else if (!s.isFull()) { // �p�GQueue�٨S��
                    s.add(val); // �h�[�JQueue
                } else { // Queue���F
                    JOptionPane.showMessageDialog(null, "�{�b�O������ (��???��)");
                }  
            } catch (Exception err) { // �B�z�ҥ~ 
                JOptionPane.showMessageDialog(null, "��J���~�S ?(��?��)?");
            }
        }
        SetJLabelResult();
        input.setText(""); // �Ϥ�r����i���s��J
    }
    public J4() {
        //set layout size
        this.setSize(800,800);
        this.setLayout(new GridLayout(11, 2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set Labels
        CreateJLabel();
        //set text input field
        input = new JTextField();
        input.addActionListener(this);
        this.add(input);
        //set remove button
        JButton remove = new JButton("Done");
        remove.addActionListener(this);
        this.add(remove);
        this.setVisible(true);
    }
    public static void main(String[] argv) {
        new J4();
    }
}
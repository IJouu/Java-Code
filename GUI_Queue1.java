import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Queue{
    int[] data ;
    int head, tail, size;
    public Queue(int length){
        data = new int[length];
    }
    public void add(int x){ //�[�J���
        data[tail++] = x; //�W�[��Ƥ��e��x
        tail %= data.length; //��z��Ƥ��e
        size++; //��ƼƼW�[
    }
    public int remove(){//���X�β������
        data[head++] = -1;
        head %= data.length;//��z��Ƥ��e
        size--;//��Ƽƴ��
        return -1;
    }
    public boolean isEmpty(){ //0�N�O�S�����
        return size == 0;
    }
    public boolean isFull(){ //��}�C�x��10�Ӹ�ƮɴN���F
        return size == 10;
    }
    public int Size(){
        return size;
    }
} 
public class GUI_Queue1 extends JFrame implements ActionListener {
    int queueLength = 10;
    JLabel[] label = new JLabel[queueLength];
    JTextField input;
    Queue s = new Queue(queueLength);
    //set Label
    public void CreateJLabel() {
        for (int i = 0; i < queueLength; i++) {
            for(int l=0; l<=s.data.length-1; l++){
                s.data[l] = -1;
            }
            label[i] = new JLabel("��", JLabel.CENTER);//�w�]��
            label[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
            this.add(label[i]); 
        }
    }
    public void actionPerformed(ActionEvent e) {
        String token = e.getActionCommand();
        CountPostFix(token);
        SetJLabelResult();
        input.setText("");
    }
    //int i = queueLength-1; i >= 0; i--
    public void SetJLabelResult() {
        for (int i = 0; i < queueLength; i++) {
            if (s.data[i]==-1)
                label[i].setText("��");
            else
                label[i].setText(Integer.toString(s.data[i]));
        }
    }
    public void CountPostFix(String token) {
        if (token.equals("����") && s.Size() >= 1) {
            s.remove();
        } else if (token.equals("����") && s.Size() == 0) {
            JOptionPane.showMessageDialog(null, "�{�b�O�ŭȭ� (��???��)");
        } else {
            int val;
            try {
                val = Integer.parseInt(token);
                if (val < 0) {
                    JOptionPane.showMessageDialog(null, "��� �п�J����� QAQ");
                }
                else if (!s.isFull()) {
                    s.add(val);
                } else {
                    JOptionPane.showMessageDialog(null, "�{�b�O������ (��???��)");
                }  
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "��J���~�S ?(��?��)?");
            } 
        }   
    }
    public GUI_Queue1() {
        //set layout size
        this.setSize(800,300);
        this.setLayout(new GridLayout(1, 12));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set Labels
        CreateJLabel();
        //set text input field
        input = new JTextField();
        input.addActionListener(this);
        this.add(input);
        //set remove button
        JButton remove = new JButton("����");
        remove.addActionListener(this);
        this.add(remove);
        this.setVisible(true);
    }
    public static void main(String[] argv) {
        new GUI_Queue1();
    }
}
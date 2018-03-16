// �H������
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class RandomSeat extends JFrame implements ActionListener{
    // �ǳ� label �}�C�ήy��}�C
    JLabel[] labels = new JLabel[45];
    int[] seat = new int[45];
    // �H������
    public void randomSeat() {
        for (int i = 0; i < seat.length; i++) {
            int randnum = (int)(Math.random()*seat.length);
            int temp = seat[i];
            seat[i] = seat[randnum];
            seat[randnum] = temp;
        }
    }
    // ��ť����
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if (s.equals("����")) {
            // �H������
            randomSeat();
            // �̧ǧ����m�W�]��� label �W�^
            for (int i = 0; i < seat.length; i++) {
                labels[i].setText(Integer.toString(seat[i]));
            }
        }
    }
    public RandomSeat() {
        // �ǳƪ�l�y��]1�����b��m1�^
        for (int i = 0; i < seat.length; i++) {
            seat[i] = i+1;
        }
        this.setSize(500,500);
        setLayout(new GridLayout(10,5));
        // �ǳƥ|�Ӫť� label�A�\�b���y�ⰼ
        JLabel[] blankLabels = new JLabel[4];
        for (int i = 0; i < blankLabels.length; i++) {
            blankLabels[i] = new JLabel(" ");
        }
        // �]�w�|Ĳ�ʩ_���}������������
        JButton randomButton = new JButton("����");
        randomButton.addActionListener(this);
        this.add(blankLabels[0]);
        this.add(blankLabels[1]);
        this.add(randomButton);
        this.add(blankLabels[2]);
        this.add(blankLabels[3]);
        // �Ʀn��l�B�̧ǥ����W�h
        for (int i = 0; i < seat.length; i++) {
            labels[i] = new JLabel(Integer.toString(i+1), JLabel.CENTER);
            this.add(labels[i]);
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] argv) {
        new RandomSeat();
    }
}
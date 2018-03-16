import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Queue{
    int[] data ;
    int head, tail, size;
    public Queue(int length){
        data = new int[length];
    }
    public void add(int x){ //加入資料
        data[tail++] = x; //增加資料內容為x
        tail %= data.length; //整理資料內容
        size++; //資料數增加
    }
    public int remove(){//取出或移除資料
        data[head++] = -1;
        head %= data.length;//整理資料內容
        size--;//資料數減少
        return -1;
    }
    public boolean isEmpty(){ //0就是沒有資料
        return size == 0;
    }
    public boolean isFull(){ //當陣列儲滿10個資料時就滿了
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
            label[i] = new JLabel("空", JLabel.CENTER);//預設空
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
                label[i].setText("空");
            else
                label[i].setText(Integer.toString(s.data[i]));
        }
    }
    public void CountPostFix(String token) {
        if (token.equals("取用") && s.Size() >= 1) {
            s.remove();
        } else if (token.equals("取用") && s.Size() == 0) {
            JOptionPane.showMessageDialog(null, "現在是空值唷 (⊙???⊙)");
        } else {
            int val;
            try {
                val = Integer.parseInt(token);
                if (val < 0) {
                    JOptionPane.showMessageDialog(null, "嗚嗚 請輸入正整數 QAQ");
                }
                else if (!s.isFull()) {
                    s.add(val);
                } else {
                    JOptionPane.showMessageDialog(null, "現在是滿的唷 (⊙???⊙)");
                }  
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "輸入錯誤惹 ?(‘?’)?");
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
        JButton remove = new JButton("取用");
        remove.addActionListener(this);
        this.add(remove);
        this.setVisible(true);
    }
    public static void main(String[] argv) {
        new GUI_Queue1();
    }
}
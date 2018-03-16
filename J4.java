import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Queue{
    int head, tail, size; // size 為資料數
    int[] data = new int[20]; // 設一個陣列
    public void add(int x){ // 加入資料
        data[tail++] = x; // 增加資料內容為x
        tail %= data.length; // 整理資料內容
        size++; // 資料數增加
    }
    public int remove(){ // 取出或移除資料
        data[head++] = -1;
        head %= data.length; // 整理資料內容
        size--; // 資料數減少
        return -1;
    }
    public boolean isEmpty(){ // 0就是沒有資料
        return size == 0;
    }
    public boolean isFull(){ //當陣列儲滿10個資料時就滿了
        return size == 20;
    }
    public int Size(){
        return size;
    }
} 
public class J4 extends JFrame implements ActionListener {
    JLabel[] label = new JLabel[20]; // 宣告視窗元件，放入10個標籤
    JTextField input; // 放入文字方塊
    Queue s = new Queue();
    //set Label
    public void CreateJLabel() {
        for (int i = 0; i < 20; i++) {
            s.data[i] = -1; 
            if (i % 2 == 0)
                label[i] = new JLabel("空", JLabel.CENTER);
            else 
                label[i] = new JLabel("未完成", JLabel.CENTER);
            label[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 30)); 
            this.add(label[i]); 
        }
    }
    // 把 Queue 內容設定到Label
    public void SetJLabelResult() {
        for (int i = 0; i < 20; i++) {
            if (s.data[i] == -1)
                label[i].setText("空");
            else
                label[i].setText(Integer.toString(s.data[i]));
        }
    }
    // 設定輸入後所執行的動作，，
    public void actionPerformed(ActionEvent e) {
        String token = e.getActionCommand();
        // 如果是"取用"且資料數大於1，則刪除Queue
        if (token.equals("Done") && s.Size() >= 1) { 
            s.remove();
        // 如果是"取用"且資料數等於0，即無資料可取=>空值
        } else if (token.equals("Done") && s.Size() == 0) { 
            JOptionPane.showMessageDialog(null, "現在是空值唷 (⊙???⊙)"); 
        } else {
            int val; // 設整數val
            // 例外處理
            try { // try會丟出例外的敘述句
                val = Integer.parseInt(token);
                if (val < 0) { // 如果val小於0
                    JOptionPane.showMessageDialog(null, "嗚嗚 請輸入正整數 QAQ");
                }
                else if (!s.isFull()) { // 如果Queue還沒滿
                    s.add(val); // 則加入Queue
                } else { // Queue滿了
                    JOptionPane.showMessageDialog(null, "現在是滿的唷 (⊙???⊙)");
                }  
            } catch (Exception err) { // 處理例外 
                JOptionPane.showMessageDialog(null, "輸入錯誤惹 ?(‘?’)?");
            }
        }
        SetJLabelResult();
        input.setText(""); // 使文字方塊可重新輸入
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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BaseTransfer extends JFrame implements ActionListener {
    // 第一個運算數、第二個運算數、運算結果
    private static int result = 0;
    // 兩個運算數和運算結果的 Label
    private Label labelX, labelY, labelZ;
    private JTextField textField;

    private BaseTransfer() {
        // 視窗基本設定
        super("Base Tranfer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);

        // 設定欄數與列數。
        this.setLayout(new GridLayout(2,5));

        String[] ButtonString = { "2進位", "4進位", "8進位", "16進位" };

        labelX = new Label("", Label.CENTER);
        labelY = new Label("", Label.CENTER);

        // Frame 加入運算式的 Label。
        this.add(new Label("", Label.CENTER));
        labelX.setText("9487");
        this.add(labelX);
        this.add(new Label("=>", Label.CENTER));
        labelY.setText("?");
        this.add(labelY);
        this.add(new Label("", Label.CENTER));

        // Frame 加入運算子的 Button。
        for(int i = 0 ; i < ButtonString.length ; i++) {
            Button option = new Button(ButtonString[i]);
            option.addActionListener(this);
            this.add(option);
        }

        // 設定輸入框預設 9487
        textField  = new JTextField("9487");
        textField.selectAll();
        textField.addActionListener(this);
        this.add(textField);

        // Display the window.
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e){
        int input;
        String cmd = e.getActionCommand();
         if (cmd == "2進位") {
            input = Integer.parseInt(labelX.getText());
            caculate(input, 2);
        } else if (cmd == "4進位") {
            input = Integer.parseInt(labelX.getText());
            caculate(input, 4);
        } else if (cmd == "8進位") {
            input = Integer.parseInt(labelX.getText());
            caculate(input, 8);
        } else if (cmd == "16進位") {
            input = Integer.parseInt(labelX.getText());
            caculate(input, 16);
        } else {
            try {
                input = Integer.parseInt(cmd);
                labelX.setText(Integer.toString(input));
                labelY.setText("?");
                if (input < 0) {
                    JOptionPane.showMessageDialog(null, "請輸入 >=0 的整數");
                    return;
                }
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "嗚嗚 輸入錯誤惹QAQ \n請輸入 >=0 的整數");
            }
        }

    }

    public void caculate(int val, int base) {
        int[] tmp = new int[100];
        int digit = 0;
        String result = "";
        while (val != 0) {
            tmp[digit++] = val % base;
            val = val / base;
        }

        if (digit == 0) {
            labelY.setText("0");
        } else {
            for(; digit > 0; digit--) {
                int tmpnum = tmp[digit - 1];
                if (tmpnum >= 10) {
                    result += (char) ('A' + (tmpnum-10));
                } else {
                    result += tmpnum;
                }
            }
            labelY.setText(result);
        }

    }

    public static void main(String[] args) {
        new BaseTransfer();
    }
}

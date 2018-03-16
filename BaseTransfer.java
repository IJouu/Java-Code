import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BaseTransfer extends JFrame implements ActionListener {
    // �Ĥ@�ӹB��ơB�ĤG�ӹB��ơB�B�⵲�G
    private static int result = 0;
    // ��ӹB��ƩM�B�⵲�G�� Label
    private Label labelX, labelY, labelZ;
    private JTextField textField;

    private BaseTransfer() {
        // �����򥻳]�w
        super("Base Tranfer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);

        // �]�w��ƻP�C�ơC
        this.setLayout(new GridLayout(2,5));

        String[] ButtonString = { "2�i��", "4�i��", "8�i��", "16�i��" };

        labelX = new Label("", Label.CENTER);
        labelY = new Label("", Label.CENTER);

        // Frame �[�J�B�⦡�� Label�C
        this.add(new Label("", Label.CENTER));
        labelX.setText("9487");
        this.add(labelX);
        this.add(new Label("=>", Label.CENTER));
        labelY.setText("?");
        this.add(labelY);
        this.add(new Label("", Label.CENTER));

        // Frame �[�J�B��l�� Button�C
        for(int i = 0 ; i < ButtonString.length ; i++) {
            Button option = new Button(ButtonString[i]);
            option.addActionListener(this);
            this.add(option);
        }

        // �]�w��J�عw�] 9487
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
         if (cmd == "2�i��") {
            input = Integer.parseInt(labelX.getText());
            caculate(input, 2);
        } else if (cmd == "4�i��") {
            input = Integer.parseInt(labelX.getText());
            caculate(input, 4);
        } else if (cmd == "8�i��") {
            input = Integer.parseInt(labelX.getText());
            caculate(input, 8);
        } else if (cmd == "16�i��") {
            input = Integer.parseInt(labelX.getText());
            caculate(input, 16);
        } else {
            try {
                input = Integer.parseInt(cmd);
                labelX.setText(Integer.toString(input));
                labelY.setText("?");
                if (input < 0) {
                    JOptionPane.showMessageDialog(null, "�п�J >=0 �����");
                    return;
                }
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "��� ��J���~�SQAQ \n�п�J >=0 �����");
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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MathTest extends JFrame implements ActionListener{
    // �Ĥ@�ӹB��ơB�ĤG�ӹB��ơB�B�⵲�G
    private static int start = 0, last = 0, result = 0;
    // ��ӹB��ƩM�B�⵲�G�� Label
    private Label labelX, labelY, labelZ;

    private MathTest() {
        // �����򥻳]�w
        super("Math Test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,200);

        // �]�w��ƻP�C�ơC
        this.setLayout(new GridLayout(2,5));

        // �B��l�̡A�]���}�C��Ū�B����A�B�i�ΰj��Ӱ��s�W Button �ʧ@�C
        String[] ButtonString = {"+", "-", "*", "/", "%"};

        // �B�⤸�̻P���G�� Label�C�]���o�� method �D�n�ت��O�]�w�n�C�Ӥ��󪺦�m�C
        // �]����ܹB�⤸�P���G�o�ؤ��e�|�ܰʪ� Label �AText ���d�šA�u�]�w�榡�C
        // ���e����� restart() �ᤩ�C
        labelX = new Label("", Label.CENTER);
        labelY = new Label("", Label.CENTER);
        labelZ = new Label("", Label.CENTER);

        // Frame �[�J�B�⦡�� Label�C
        this.add(labelX);
        this.add(new Label("?", Label.CENTER));
        this.add(labelY);
        this.add(new Label("=", Label.CENTER));
        this.add(labelZ);

        // Frame �[�J�B��l�� Button�C
        for(int i = 0 ; i < ButtonString.length ; i++) {
            Button option = new Button(ButtonString[i]);
            option.addActionListener(this);
            this.add(option);
        }

        // ��l�B�⦡�A���͹B�⤸�P���G
        this.restart();

        // Display the window.
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();

        // �O�_�ӧQ�H�w�]�� false�A����٨SĹ�C
        boolean win = false;

        // �D�حn�D�A�Y�P�ɦ���ӥH�W���B��l�����ѡA�������Q�ӻ{�C
        // �]���ĥΨC���I���B��l�A�N���өM�B�⤸�ˬd�O�_���T�C
        // ���T�Y�ק� win �� true�A��ܳӧQ�C
        switch(cmd) {
            case "+":
                if(start + last == result) {
                    win = true;
                }
                break;

            case "-":
                if(start - last == result) {
                    win = true;
                }
                break;

            case "*":
                if(start * last == result) {
                    win = true;
                }
                break;

            case "/":
                if(start / last == result) {
                    win = true;
                }
                break;

            case "%":
                if(start % last == result) {
                    win = true;
                }
                break;
        }

        // �C�����D�T�{�O�_���T�çi���A���ץ��T�h��l�B�⦡�] restart() �^�C
        if(win == true) {
            JOptionPane.showMessageDialog(this, "�n�δή@�I�U�@�D�I", "�B�Y�B�Y�I�I", JOptionPane.INFORMATION_MESSAGE);
            this.restart();
        } else {
            JOptionPane.showMessageDialog(this, "�O�ǤߡA�A�Q�@�U�I", "�����A���S", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void restart() {
        // ��l�B�⤸�P���G�C
        start = (int)(Math.random()*999+1);
        last = (int)(Math.random()*999+1);
        result = 0;

        // �H����ܤ@�ӹB��l�C
        int operation = (int)(Math.random()*5); // 0:+, 1:-, 2:*, 3:/, 4:%

        // ��X���G�C
        switch (operation) {
            case 0:
                result = start + last;
                break;

            case 1:
                result = start - last;
                break;

            case 2:
                result = start * last;
                break;

            case 3:
                result = start / last;
                break;

            case 4:
                result = start % last;
                break;
        }

        // ��s�B�⤸�̻P���G�� Label�C
        labelX.setText(Integer.toString(start));
        labelY.setText(Integer.toString(last));
        labelZ.setText(Integer.toString(result));
    }

    public static void main(String[] args) {
        new MathTest();
    }
}

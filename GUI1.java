import java.awt.*;
import javax.swing.*;
public class GUI1 extends JFrame {
    private GUI1() {
        this.setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String argv[]) {
        new GUI1();
    }
}
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Area{
    int base, height, radius, width, area;
    public boolean isCircle() {
        return area == radius * redius * 3;
    }
    public boolean isTriangle() {
        return area == base * height / 2;
    }
    public boolean isRectangle() {
        return area == width * height;
    }
    public int Area() {
        return area;
    }
}
public class J5 extends JFrame implements ActionListener {
    JLabel[] label = new JLbel[3];
    JPanel[] panel = new JPanel[3];
    public void CreateJLabel() {
        
    }
    public void Random() {
        int base = Math.random()*100+1;
        int height = Math.random()*100+1;
        int radius = Math.random()*100+1;
        int width = Math.random()*100+1;

    }

}
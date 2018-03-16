import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Personal {
    public String name;
    public int score = 0;
    public Personal(String na, int sc) {
        name = na;
        score = sc;
    }
}

public class Hw06 {
    static int stacklength = 10;
    static int top = 0;
    static Personal data[];
    public static void push(String name, int score) {
        if (top != stacklength) {
            data[top++] = new Personal(name, score);
        } else {
            System.out.println("Stack is Full！");
        }
    }
    
    public static void pop(int n) {
        if(top != 0) {
            top--;
            System.out.println("n = " + n + "  以下資料pop出Stack");
            System.out.println(data[top].name + "  " + data[top].score);
            data[top].name = null;
            data[top].score = 0;
        } else {
            System.out.println("Stack is Empty！");
        }
    }
    
    public static void print(int times) {
        System.out.println("-------  第" + times + "次測試  -------");
        System.out.println("---  印出Stack所有的內容  ---");
        for(int i = top - 1; i >= 0; i--) {
            System.out.println(i + "       " + data[i].name + "       " + data[i].score);
        }
        System.out.println("\r\n");
    }
    
    public static void main(String[] argv) {
        data = new Personal[10];
        String[] allname = {"AAA", "BBB", "CCC", "DDD", "EEE", "FFF", "GGG", "HHH", "III", "JJJ"};
        for (int i = 0; i < stacklength; i++) {
            data[i] = new Personal(null, 0);
        }
        for (int i = 0; i < 30; i++) {
            int n = (int)(Math.random()*(9 - 0 + 1) + 0);
            if (n % 2 == 0) {
                int score = (int)(Math.random()*(100 - 1 + 1) + 1);
                push(allname[n], score);
                System.out.println("n = " + n + "  以下資料push到Stack");
                System.out.println(data[top - 1].name + "  " + data[top - 1].score);
                print(i + 1);
            } else {
                pop(n);
                print(i + 1);
            }
        }
    }
}
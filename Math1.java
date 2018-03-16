import java.lang.*;
import java.util.Scanner;

public class Math1 {
    int x; // object var
    static int y; // class var
    public static void main(String[] argv) {
        int x = 0; // local var 
        test3(5);
        System.out.println(x);
    }
    
    public static void test3(int x) {
        if (x <= 0)
            return;
        test3(x - 1);
        System.out.println(x);
    }
    
    public static void test2(int x) {
        for (int i = 0; i < x; i++) {
            if (i % 2 == 0)
                continue;
            if (i > 30)
                break;
            System.out.println(i);
        }
    }
    
    public static void test(int x) {
        switch(x) { // 判斷不同案子
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("not 1 or 2");
        }
    }
}

// call by value 把值複製給下一個
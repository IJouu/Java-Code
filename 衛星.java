import java.lang.*;
import java.util.Scanner;

public class 衛星 {
    String name; // object variable
    static int total衛星; // class variable
    public 衛星() { // constructor
        System.out.println("新衛星產生了");
        total衛星 ++;
    }
    // method finalize() will be called by GC
    protected void finalize() { 
        System.out.println(name + " 被回收了");
        total衛星 --;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        衛星 手指頭; // 變數型態是reference to 衛星
        手指頭 = new 衛星();
        手指頭.name = "月球";
        手指頭 = new 衛星();
        手指頭.name = "木衛2";
        System.gc(); // garbage collection
        input.next(); // 等待
        System.out.println("這世界剩下 " + 衛星.total衛星 + " 個衛星");
        
        /*int i = 0; // local variable
        for (;;) {
            衛星 x = new 衛星();
            x.name = "衛星"+ i++;
        }
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();*/
    }
}

// byte short int long float double char boolean
// 8種以外皆是reference
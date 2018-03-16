import java.util.*;
public class TestThread extends Thread implements Runnable{
    private String name;
    public TestThread(String name) {
        this.name = name;
    }
    public void run() { // overrid method defined in class Thread 
        for( ; ; ) {
            System.out.println("Hello " + name);
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        Thread t1 = new TestThread("老魚");
        Thread t2 = new Thread(new TestThread("悅悅"));
        // after start, a Thread executes its run()
        t1.start();
        t2.start();
    }
}



// String 的型態是 reference
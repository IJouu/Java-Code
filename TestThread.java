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
        Thread t1 = new TestThread("�ѳ�");
        Thread t2 = new Thread(new TestThread("����"));
        // after start, a Thread executes its run()
        t1.start();
        t2.start();
    }
}



// String �����A�O reference
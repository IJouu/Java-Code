class NoThread implements Runnable {
    private Queue1 q;
    public NoThread(Queue1 q) {
        this.q = q;
    }
    public void run() {
        while (true) {
            System.out.println("get " + q.get());
            try {
                Thread.currentThread().sleep(400);
            } catch (Exception err) {

            }
        }
    }
}
public class YesThread extends Thread {
    private Queue1 q;
    public YesThread(Queue1 q) {
        this.q = q;
    }
    // override run() defined in Thread
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("put " + q.put(i++));
            try {
                sleep(300);
            } catch (Exception err) {

            }
        }
    }
    public static void main(String[] argv) {
        Queue1 q = new Queue1();
        Thread t1 = new YesThread(q);
        Thread t2 = new Thread(new NoThread(q));
        t1.start();
        t2.start();
        /*// create a new Thread
        Thread t = new YesThread();
        // ask thread to excute run()
        t.start();
        t = new Thread(new NoThread());
        t.start();
        // main thread say hello
        while (true) {
            System.out.println("Hello");
            try {
                // sleep 5 sec
                Thread.currentThread().sleep(5000);
            } catch (Exception err) {

            }
        }*/
    }
}

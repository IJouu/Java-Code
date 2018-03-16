public class Queue1 { // extends java.lang.Object
    private int[] data = new int[100];
    private int head; // head point to first data
    private int tail; // point to first avaible space
    private int size; // number of data in the queue
    public synchronized int get() { // 需拿到物件的鎖才能執行
        while (size == 0) {
            try {
                // wait() is defined in
                // java.lang.Object
                // the parent class of all class
                wait(); // 當需要的資料不存在 call wait()
            } catch(Exception err) {
            }
        }
        int result = data[head++];
        if (head == data.length) {
            head = 0;
        }
        // head = head & data.length;
        size--;
        if (size == data.length - 1) {
            notifyAll(); // wake up all waiting Threads
        }
        return result;
    }
    public synchronized int put(int x) {
        while (size >= data.length) {
            try {
                wait();
            } catch(Exception err) {

            }
        }
        data[tail++] = x;
        tail = tail % data.length;
        size++;
        if (size == 1) {
            notifyAll();
        }
        return x;
    }
}

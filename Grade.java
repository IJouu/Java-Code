// °õ¦æºü
// ReaderÀu¥ý
public class Grade {
    private float[] list = new float[100];
    private int reader, writer;
    public synchronized void getWriteLock() {
        while (!(reader == 0 && writer == 0)) {
            try {
                wait();
            } catch(Exception err) {

            }
        }
        writer++;
        return;
    }
    public synchronized void releaseWriteLock() {
        writer--;
        notifyAll();
        return;
    }
    public synchronized void getReadLock() {
        while (writer != 0) {
            try {
                wait();
            } catch(Exception err) {

            }
        }
        reader++;
        return;
    }
    public synchronized void releaseReadLock() {
        reader--;
        notifyAll();
        return;
    }
    public void adjust() {
        getWriteLock();
        for (int i = 0; i < list.length; i++) {
            list[i] += 10;
        }
        releaseWriteLock();
    }
    public void print() {
        getReadLock();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        releaseReadLock();
    }
}

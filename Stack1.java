public class Stack1 {
    // private 表示只有這個class的程式碼可以存取
    private int[] data = new int[100];
    private int top = 0; // top points to first empty slot
    public void push(int x) {
        data[top++] = x;
    }
    public int pop() {
        return data[--top];
    }
    public boolean isEmpty() {
        return top <= 0;
    }
}
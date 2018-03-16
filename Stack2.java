public class Stack2 {
    // private 表示只有這個class的程式碼可以存取
    private String[] data = new String[100];
    private int top = 0; // top points to first empty slot
    public void push(String x) {
        data[top++] = x;
    }
    public String pop() {
        return data[--top];
    }
    public String peek() { // 回傳最高層的東西
        return data[top - 1];
    }
    public boolean isEmpty() {
        return top <= 0;
    }
}
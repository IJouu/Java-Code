public class Stack2 {
    // private ��ܥu���o��class���{���X�i�H�s��
    private String[] data = new String[100];
    private int top = 0; // top points to first empty slot
    public void push(String x) {
        data[top++] = x;
    }
    public String pop() {
        return data[--top];
    }
    public String peek() { // �^�ǳ̰��h���F��
        return data[top - 1];
    }
    public boolean isEmpty() {
        return top <= 0;
    }
}
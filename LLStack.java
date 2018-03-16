class Node {
    int value;
    Node next;
}

public class LLStack {
    Node top;
    public void push(int x) {
        Node tmp = new Node();
        tmp.value = x;
        tmp.next = top;
        top = tmp;
    }
    public int pop() {
        int result = top.value;
        top = top.next;
        return result;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public int peep() {
        return top.value;
    }
}
public class TestStack {
    public static void main(String[] argv) {
        Stack1 s;
        s = new Stack1();
        for (int i = 1; i < 50; i++) {
            s.push(i);
        }
        while (!s.isEmpty())
            System.out.println(s.pop());
    }
}
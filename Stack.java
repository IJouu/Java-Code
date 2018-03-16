import java.math.BigDecimal;
public class Stack {
    int top = 0; // object variable
    BigDecimal[] data = new BigDecimal[100]; // object variable
    public Stack() {
    }
    public void push(BigDecimal x) {
        this.data[this.top++] = x;
    }
    public BigDecimal pop() {
        return this.data[--top];
    }
}
class Parent {
    private int y = 20;
    public Parent(int y) {
        this.y = y; // this.y = (int)(y * 15)
    }
    public Parent() {
    }
} 
public class TestConstructor extends Parent {
    private int x = 10;
    public TestConstructor(int v) {
        // super: 父類別物件
        // this: 這個物件
        super(x / 10); // super(v / 10)
        x = v; // x = y * 3
    }
    public void fun() {
        // call parent's fun()
        super.fun();
    }
    public static void main(String[] argv) {
        TestConstructor t = new TestConstructor(100);
        System.out.println(t.x);
    }
} 


/** object variable 的 init 順序
    1. set default(for all class)
    2. call parent's constructor
    3. init with var declaration
    4. execute constructor
    
    TestC       P
    x           y
    0 / 0      0 / 0   init
    0 / 0     20 / 20  第2行
    0 / 0     10 / 15  第4行
   10 / 10    10 / 15  第10行
  100 / 45    10 / 15  第13行
**/
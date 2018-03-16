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
        // super: �����O����
        // this: �o�Ӫ���
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


/** object variable �� init ����
    1. set default(for all class)
    2. call parent's constructor
    3. init with var declaration
    4. execute constructor
    
    TestC       P
    x           y
    0 / 0      0 / 0   init
    0 / 0     20 / 20  ��2��
    0 / 0     10 / 15  ��4��
   10 / 10    10 / 15  ��10��
  100 / 45    10 / 15  ��13��
**/
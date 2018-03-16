// Exception Handling 例外處理
// if an Exception is a kind of java.lang.RuntimeException
// then u were not forced to handle it
// otherwise u must handle it by "catch" and "throws"
// Exception是一個類別
// 當用別人的函數 編譯不過

class MyException extends Exception { // 呼叫父類別 constructor
    // constructor 初始化
    public MyException(String msg) {
        super(msg);
    }
    public MyException() {
        // super() ; // this line will be added by compiler
    }
}
public class Test2 {
    public static double fun(double x) throws Exception { // function 宣告的時候要用 throws
        if (x < 0)
            throw new MyException("搞什麼鬼");
        return Math.sqrt(x);
    }
    public static void main(String[] argv) {
        // only one Exception block will be matched
        // finally{} always excuted
        try {
            int[] data = {1, 2, 3, 4};
            data[100] = 100;
            System.out.println(fun(-1));
        } catch(MyException err) {
            System.out.println("block MyException");
            err.printStackTrace();
        } catch(RuntimeException err2) {
            System.out.println("block RuntimeException");
            err2.printStackTrace();
        } catch(Exception err3) {
            System.out.println("block Exception");
        } finally { // 一定會執行
            System.out.println("This block always executed");
        }

    }
}

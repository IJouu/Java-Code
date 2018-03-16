public class TestTry {
    public static void main(String[] argv) {
        int[] data = new int[100];
        data = null;
        data[100] = 10;
    } 
    public static void main(String[] argv) {
        try {
            myFun();
        } catch(ArrayIndexOutBoundsException er1) {
            System.out.println("陣列索引超過邊界錯誤");
            er1.printStackTrace();
        } catch(NullPointerException np) {
            System.out.println("搞啥，沒事亂指");
        } catch(Exception err) {
            System.out.println("出錯了");
            err.printStackTrace();
            // System.out.println(err.toString());
        } finally {
            System.out.println("不管有沒有錯，不管哪種錯， finally 都會執行");
        }  
    }
}


/** 
    throw new Exception("我是自訂顯示訊息的例外")
**/
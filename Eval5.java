public class Eval5 {
    private static String[] operators = new String[]{"+", "-", "*", "/", "%", "^", "fun", ",", "("};
    private static int[] isp = {3,3,4,4,4,5,6,1,0};
    private static int[] icp = {3,3,4,4,4,5,6,2,100};
    // 次方
    public static double power(double x, double m) {
        double y = 1;
        for (int i = 1; i <= m; i = i + 1) {
            y = y * x;
        }
        return y;
    }
    // 開根號
    public static double root(double x, double n) {
        double left = 0;
        double right = 0;
        double mid;        
        if (x >= 1) {
            left = 1;
            right = x;
        } else if (x < 1) {
            left = x;
            right = 1;
        }
        mid = (left + right) / 2; 
        while (mid > left && mid < right) {
            if (power(mid, n) > x) {
                right = mid; 
            } else if (power(mid, n) < x) {
                left = mid;
            } else
                return mid;
            mid = (left + right) / 2;
        } 
        return mid;
    }
    public static double rootofpow(double x, double m, double n){
        return root(power(x, m), n);
    }
    // 階乘
    public static double factorial(double n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }
    // 反轉
    public static int reverse(int x) {
        int y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y;
    }
    
    // 找出String對應到索引位置
    public static int opid(String x) {
        if (x.length() > 1 && (x.charAt(0) == '+' || x.charAt(0) == '-'))
            return -1;
        if ((x.charAt(0) >= 'A' && x.charAt(0) <= 'Z')|| (x.charAt(0) >= 'a' && x.charAt(0) <= 'z'))
            return 6;
        for (int i = 0; i < operators.length; i++) {
            if (x.equals(operators[i]))
                return i;
        }
        return -1;
    }
    
    public static void cal(String op, Stack2 number) {
        if (op.equals("+")) {
            double num1 = Double.valueOf(number.pop());
            double num2 = Double.valueOf(number.pop());
            number.push(Double.toString(num2 + num1));
            /*number.push(Integer.toString(Integer.valueOf(number.pop()) + Integer.valueOf(number.pop())));
            Integer.valueOf("123"); // 字串轉整數
            Integer.toSring(123); // 整數轉字串
            */
        } else if (op.equals("-")) {
            double num1 = Double.valueOf(number.pop());
            double num2 = Double.valueOf(number.pop());
            number.push(Double.toString(num2 - num1));
        } else if (op.equals("*")) {
            double num1 = Double.valueOf(number.pop());
            double num2 = Double.valueOf(number.pop());
            number.push(Double.toString(num2 * num1));
        } else if (op.equals("/")) {
            double num1 = Double.valueOf(number.pop());
            double num2 = Double.valueOf(number.pop());
            number.push(Double.toString(num2 / num1));
        } else if (op.equals("%")) {
            double num1 = Double.valueOf(number.pop());
            double num2 = Double.valueOf(number.pop());
            number.push(Double.toString(num2 % num1));
        } else if (op.equals("^")) {
            double num1 = Double.valueOf(number.pop());
            double num2 = Double.valueOf(number.pop());
            number.push(Double.toString(power(num2, num1)));
        /*else if (op.equals("root")) {
            double num1 = Double.valueOf(number.pop());
            number.push(Double.toString(root(num1)));
        */
        } else if (op.equals("rootofpow")) {
            double num1 = Double.valueOf(number.pop());
            double num2 = Double.valueOf(number.pop());
            double num3 = Double.valueOf(number.pop());
            number.push(Double.toString(rootofpow(num3, num2, num1)));
        } else if (op.equals("factorial")) {
            double num1 = Double.valueOf(number.pop());
            number.push(Double.toString(factorial(num1)));
        } else if (op.equals("reverse")) {
            int num1 = Integer.valueOf(number.pop());
            number.push(Integer.toString(reverse(num1)));
        }
    }
    public static void eval(String[] data) {
        Stack2 number = new Stack2();
        Stack2 op = new Stack2();
        // Stack2 fu = new Stack2();
        String y;
        for (int i = 0; i < data.length; i++) {
            // read in next data x
            String x = data[i];
            if (x.equals(")")) {
                while (!op.isEmpty() && !(y = op.pop()).equals("(")) {
                    cal(y, number);
                    /*while (!op.isEmpty() && !(y = op.pop()).equals(",")) {
                        cal(y, number);
                    }*/
                }
            } else if (opid(x) == -1) {
                // x is a number
                number.push(x);
            } else {
                // x is a operator
                while (!op.isEmpty() && isp[opid(op.peek())] >= icp[opid(x)]) {
                    cal(op.pop(), number);
                }
                op.push(x);
            }
        }
        while (!op.isEmpty()) {
            cal(op.pop(), number);
        }
        System.out.println(number.pop());
    }
    public static void main(String[] argv) {
        /*String[] data = {"rootofpow", "(", "2", "+", "3", ",", "2",",","1", ")"};
        eval(data);*/
        String[] data = {"factorial","(","rootofpow","(","reverse","(","30",")",",","2",",","1",")",")"};
        eval(data);
        /*String[] data1 = {"4","*","(","2","+","3",")","+","3","^","2"};
        String[] data2 = {"199","%","10","-","(","-1",")","+","rootofpow","(","5",",","3",",","2",")"};
        String[] data3 = {"reverse","(","200",")","*","factorial","(","5",")","/","(","10","%","6",")","-","8"};
        String[] data4 = {"4","-","reverse","(","123",")","/","6","+","37","%","3","+","45","+","factorial","(","0",")"};
        String[] data5 = {"rootofpow","(","factorial","(","reverse","(","21",")",")",",","2",",","2","+","3",")"};
        
        eval(data1);
        eval(data2);
        eval(data3);
        eval(data4);
        eval(data5);*/
        
    }
}
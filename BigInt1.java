public class BigInt1{
    private int[] digits = new int[1000];
    public BigInt1(){
    }
    public BigInt1(String s){
        int i = 0;
        boolean negative = false;
        if(s.charAt(0) == '-'){
            negative = true;
            i++;
        }
        for(; i < s.length(); i++){
            digits[s.length()-i-1] = s.charAt(i) - '0';
        }
        if(negative){
            BigInt1 tmp = this.complement();
            for(i = 0; i < digits.length; i++){
                digits[i] = tmp.digits[i];
            }
        }
    }
    public String toString(){
        String result = "";
        boolean negative = false;
        BigInt1 tmp = this;
        if(digits[digits.length - 1] >= 5){
            negative = true;
            tmp = this.complement();
        }
        int i = digits.length - 1;
        while(i >= 0 && tmp.digits[i] == 0){
            i--;
        }
        while(i >= 0){
            result = result + (char)(tmp.digits[i--] + '0');
        }
        if(result.equals("")){
            return "0";
        }
        if(negative){
            return "-" + result;
        }
        return result;
    }
    public BigInt1 add(BigInt1 y){
        BigInt1 result = new BigInt1();
        for(int i = 0; i < digits.length; i++){
            result.digits[i] = digits[i] + y.digits[i];
        }
        return result.normalize();
    }
    private BigInt1 normalize(){
        int carry = 0;
        for(int i = 0; i < digits.length; i++){
            int result = carry + digits[i];
            digits[i] = result % 10;
            carry = result / 10;
        }
        return this;
    }
    public BigInt1 mul(BigInt1 y){
        BigInt1 result = new BigInt1();
        for(int i = 0; i < digits.length; i++){
            BigInt1 tmp = new BigInt1();
            for(int j = 0; j < digits.length; j++){
                if(digits[i] != 0 && y.digits[j] != 0 && i + j < digits.length){
                    tmp.digits[i + j] = digits[i] * y.digits[j];
                }
            }
            result = result.add(tmp);
        }
        return result.normalize();
    }
    private BigInt1 complement(){
        normalize();
        BigInt1 result = new BigInt1();
        for(int i = 0; i < digits.length; i++){
            result.digits[i] = 9 - digits[i];
        }
        result.digits[0]++;
        return result.normalize();
    }
    public BigInt1 sub(BigInt1 y){
        return this.add(y.complement());
    }
    public boolean isNegative(){
        return digits[digits.length - 1] >= 5;
    }
    public BigInt1 div(BigInt1 y){
        BigInt1 x = this;
        boolean negative = false;
        if(this.isNegative()){
            negative = !negative;
            x = this.complement();
        }
        if(y.isNegative()){
            negative = !negative;
            y = y.complement();
        }
        BigInt1 result = new BigInt1();
        x = x.sub(y);
        while(!x.isNegative()){
            x = x.sub(y);
            result = result.add(new BigInt1("1"));
        }
        if(negative){
            return result.complement();
        }
        return result;
    }
    public BigInt1 mod(BigInt1 y){
        BigInt1 x = this;
        boolean negative = false;
        if(this.isNegative()){
            negative = !negative;
            x = this.complement();
        }
        if(y.isNegative()){
            negative = !negative;
            y = y.complement();
        }
        x = x.sub(y);
        while(!x.isNegative()){
            x = x.sub(y);
        }
        x = x.add(y);
        if(negative){
            return x.complement();
        }
        return x;
    }
    private int compare(BigInt1 y){
        int i;
        for(i = digits.length-1; i >= 0 && digits[i] == y.digits[i]; i--){}
        if(i < 0){
            return 0;
        }
        return digits[i] - y.digits[i];
    }
    private BigInt1 bigDouble(){
        BigInt1 result = new BigInt1();
        for(int i =0; i < digits.length; i++){
            result.digits[i] = 2 * digits[i];
        }
        return result.normalize();
    }
    public BigInt1 fastDiv(BigInt1 y){
        BigInt1 result = new BigInt1();
        BigInt1 remain = this;
        BigInt1 div = y;
        BigInt1[] ser = new BigInt1[3000];
        int len = 0;
        ser[len] = new BigInt1("1");
        while(remain.compare(div.mul(ser[len])) >= 0){
            ser[len+1] = ser[len].bigDouble();
            len++;
        }
        len--;
        while(remain.compare(div) >= 0){
            // BigInt ser = new BigInt("1");
            // BigInt pre = ser;
            // find biggest ser[len]
            while(remain.compare(div.mul(ser[len])) < 0){
                // pre = ser;
                // ser = ser.bigDouble();
                len--;
            }
            remain = remain.sub(div.mul(ser[len]));
            result = result.add(ser[len]);
        }
        return result;
    }

    public static void main(String[] argv){
        BigInt1 x = new BigInt1("12345678901234567890");
        BigInt1 y = new BigInt1("87");
        // System.out.println("x = " + x.toString() + " , " + "y = " + y.toString());
        // System.out.print("x + y = ");
        // System.out.println(x.add(y).toString());
        // System.out.print("x * y = ");
        // System.out.println(x.mul(y).toString());
        // System.out.print("x - y = ");
        // System.out.println(x.sub(y).toString());
        // System.out.print("x / y = ");
        // System.out.println(x.div(y).toString());
        // System.out.print("x % y = ");
        // System.out.println(x.mod(y).toString());
        // System.out.println(x.complement().toString());
        System.out.println(x.fastDiv(y).toString());
    }
}

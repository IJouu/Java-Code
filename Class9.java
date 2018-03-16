public class Class9 {
    private int[] digits = new int[1000];
    public Class9() {

    }
    public Class9(String s) {
        int i = 0;
        boolean negative = false;
        if(s.charAt(0) == '-'){
            negative = true;
            i++;
        }
        for(; i < s.length(); i++) {
            digits[s.length()-i-1] = s.charAt(i)-'0';
        }
        if(negative){
            Class9 tmp = this.complement();
            for (i = 0; i < digits.length ; i++) {
                digits[i] = tmp.digits[i];
            }
        }
    }
    public boolean isNegative(){
        return digits[digits.length - 1] >= 5;
    }
    public Class9 div(Class9 y) {
        Class9 x = this;
        boolean negative = false;
        if(this.isNegative()){
            negative = !negative;
            x = this.complement();
        }
        if (y.isNegative()){
            negative = !negative;
            y = y.complement();
        }
        Class9 result = new Class9();
        x = x.sub(y);
        while(!x.isNegative()){
            x = x.sub(y);
            result = result.add(new Class9("1"));
        }
        if(negative){
            return result.complement();
        }
        return result;
    }
    public String toString() {
        String result = "";
        boolean negative = false;
        Class9 tmp = this;
        if(digits[digits.length -1] >= 5){
            negative = true;
            tmp = this.complement();
        }
        int i = digits.length - 1;
        while(i >= 0 && tmp.digits[i] == 0) {
            i--;
        }
        while(i >= 0) {
            result = result + (char)(tmp.digits[i--]+'0');
        }
        if(result.equals("")) {
            return "0";
        }
        if(negative){
            return "-" + result;
        }
        return result;
    }
    public Class9 add(Class9 y) {
        Class9 result = new Class9();
        for(int i = 0; i < digits.length; i++){
            result.digits[i] = digits[i] + y.digits[i];
        }
        return result.normalize();
        }
   public Class9 sub(Class9 y){
       return this.add(y.complement());
   }
   private Class9 normalize(){
       int carry = 0;
       for(int i = 0; i < digits.length; i++){
           int result = carry + digits[i];
           digits[i] = result % 10;
           carry = result / 10;
       }
       return this;
   }
   public Class9 mul(Class9 y) {
       Class9 result = new Class9();
       for(int i = 0; i < digits.length; i++){
               Class9 tmp = new Class9();
           for(int j = 0; j < digits.length; j++){
               if(i + j < digits.length){
                   tmp.digits[i+j] = digits[i] * y.digits[j];
               }
           }
           result = result.add(tmp);
       }
       return result.normalize();
   }
   private Class9 complement(){
       Class9 result = new Class9();
       for(int i = 0; i < digits.length; i++){
           result.digits[i] = 9 - digits[i];
       }
       result.digits[0]++;
       return result.normalize();
   }
   public static void main(String[] args) {
       /*Class9 x = new Class9("1234567");
       Class9 y = new Class9("12000000232000");
       System.out.println(x.add(y).toString());
       Class9 x1 = new Class9("31578");
       Class9 x2 = new Class9("2135128");
       System.out.println(x1.mul(x2).toString());*/
       Class9 y1 = new Class9("12434");
       Class9 y2 = new Class9("1687458923");
       System.out.println(y1.sub(y2).toString());
       Class9 y3 = new Class9("70");
       System.out.println((y3.complement()).toString());
       Class9 y4 = new Class9("144");
       Class9 y5 = new Class9("12");
       System.out.println(y4.div(y5).toString());
   }
}

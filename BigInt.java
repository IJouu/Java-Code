public class BigInt {
    private int[] digits = new int[1000];
    public BigInt() {
    }
    public BigInt(String s) {
        int i = 0;
        boolean negative = false;
        if (s.charAt(0) == '-') {
            negative = true;
            i++;
        }
        for (; i < s.length(); i++) {
            digits[s.length() - i - 1] = s.charAt(i) - '0';
        }
        if (negative) {
            BigInt tmp = this.complement();
            for (i = 0; i < digits.length; i++) {
                digits[i] = tmp.digits[i];
            }
        }
    }
    public boolean isNegative() {
        return digits[digits.length - 1] >= 5;
    }
    public BigInt div(BigInt y) {
        BigInt x = this;
        boolean negative = false;
        if (this.isNegative()) {
            negative = !negative;
            x = this.complement();
        }
        if (y.isNegative()) {
            negative = !negative;
            y = y.complement();
        }
        BigInt result = new BigInt();
        x = x.sub(y);
        while (!x.isNegative()) {
            x = x.sub(y);
            result = result.add(new BigInt("1"));
        }
        if (negative) {
            return result.complement();
        }
        return result;
    }
    public String toString() {
        String result = "";
        boolean negative = false;
        BigInt tmp = this;
        if (digits[digits.length - 1] >= 5) {
            negative = true;
            tmp = this.complement();
        }
        int i = digits.length - 1;
        while (i >= 0 && tmp.digits[i] == 0)
            i--;
        while (i >= 0) {
            result = result + (char)(tmp.digits[i--] + '0');
        }
        if (result.equals(""))
            return "0";
        if (negative) {
            return "-" + result;
        }
        return result;
    }
    public BigInt sub(BigInt y) {
        return this.add(y.complement());
    }
    public BigInt add(BigInt y) {
        BigInt result = new BigInt();
        for (int i = 0; i < digits.length; i++) {
            result.digits[i] = digits[i] + y.digits[i];
          }
        return result.normalize();
    }
    private BigInt normalize() {
        int carry = 0;
        for (int i = 0; i < digits.length; i++) {
            int result = carry + digits[i];
            digits[i] = result % 10;
            carry = result / 10;
        }
        return this;
    }
    public BigInt mul(BigInt y) {
        BigInt result = new BigInt();
        for (int i = 0; i < digits.length; i++) {
            BigInt tmp = new BigInt();
            for (int j = 0; j < digits.length; j++) {
                if (i + j < digits.length) {
                    tmp.digits[i + j] = digits[i] * y.digits[j];
                }
            }
            result = result.add(tmp);
        }
        return result.normalize();
    }
    private BigInt complement() {
        BigInt result = new BigInt();
        for (int i = 0; i < digits.length; i++) {
            result.digits[i] = 9 - digits[i];
        }
        result.digits[0]++;
        return result.normalize();
    }
    public static void main(String[] argv) {
        BigInt y1 = new BigInt("12434");
        BigInt y2 = new BigInt("3");
        System.out.println(y1.mode(y2).toString());
        /*System.out.println(y1.sub(y2).toString());
        BigInt y3 = new BigInt("70");
        System.out.println((y3.complement()).toString());
        BigInt y4 = new BigInt("144");
        BigInt y5 = new BigInt("12");
        System.out.println(y4.div(y5).toString());*/
    }
}

import java.util.Scanner;
public class PrimeHomework {
    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
    public static int primes(int n) {
        int counter = 0;
        for (int i = 2; i <= n; i++)
            if (isPrime(i))
                counter++;
        return counter;   
    }
    
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("測驗法 " + primes(n) + "個"+ System.currentTimeMillis() + "ms");
    }
}
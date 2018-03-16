import java.util.Scanner;

public class Array {
    public static void main(String[] argv) {
        int randNum = (int)(Math.random()*(20 - 10 + 1) + 10);
        int[] x = new int[randNum];
        for (int i = 0; i < randNum; i++) {
            x[i] = (int)(Math.random()*(50 - (-50) + 1) + (-50));
            System.out.print(x[i] + " ");
        }
        System.out.println("\r\n");
        for (int i = 0; i <= x.length - 1; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {
                if (x[j] > x[j + 1]) { 
                    int tmp = x[j]; 
                    x[j] = x[j + 1];
                    x[j + 1] = tmp;
                }
            }
            for (int k = 0; k <= x.length - 1; k++) {
                System.out.print(x[k] + " ");
            }
            System.out.println();
        }
        System.out.println(randNum);
        for (int i = 0; i <= randNum - 1; i++) {
            System.out.print(x[i] + " ");
            
        }
    }
}
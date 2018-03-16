import java.util.Scanner;

class ChuCooLet {

    private static int n; // ´XºØ¤f¨ý
    private static Pudding[] pud; // ¥¬¤B

    public static void main(String[] argv) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("How many flavors?");
        n = input.nextInt();
        
        System.out.println("Insert pudding data");
        pud = new Pudding[n]; // input ¥¬¤B
        for(int i = 0 ; i < n ; i++) {
            String f = input.next();
            int p = input.nextInt();
            int q = input.nextInt();
            pud[i] = new Pudding(f, p, q);
        }
        int[] perTotal = new int[n];
        int money = totalMoney();
        for(int i = 0; i < n ; i++) {
            perTotal[i] = pud[i].getPrice() * pud[i].getQuantity();
            System.out.println(pud[i].getFlavor() + ": " +perTotal[i]);
        }
        System.out.println("Total Money: " + money);
    }

    public static int totalMoney() {
        int totalMoney = 0;
        for(int i = 0 ; i < n ; i++) {
            totalMoney += pud[i].getPrice() * pud[i].getQuantity();
        }
        return totalMoney;
    }
}
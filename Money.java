import java.util.Scanner;

public class Money {
    String name;
    int money;
    public Money(String name, int money) {
        this.name = name;
        this.money = money;
    }
    
    public void earnMoney(int amount) { // 賺 or 拿到錢
        money = money + amount;
    }
    
    public void spendMoney(int amount) { // 花錢
        money = money - amount;
    }
    
    public void print() {
        System.out.println(name +" 錢包裡有 "+ money + " 元"); 
    }
    
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 有幾個錢包
        Money[] wallets = new Money[n];
        for (int i = 0; i < n; i++) {
            String name = input.next();
            int money = input.nextInt();
            wallets[i] = new Money(name, money);
        }
        
        String name = input.next();
        String command = input.next();
        for (int i = 0; i < n; i++) {
            if (name.equals(wallets[i].name) && command.equals("earn")) {
                wallets[i].earnMoney(input.nextInt());
            } else if (name.equals(wallets[i].name) && command.equals("spend")) {
                wallets[i].earnMoney(input.nextInt());
            }
        }
        for (int i = 0; i < n; i++) {
            wallets[i].print();
        }
    }
}
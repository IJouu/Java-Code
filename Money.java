import java.util.Scanner;

public class Money {
    String name;
    int money;
    public Money(String name, int money) {
        this.name = name;
        this.money = money;
    }
    
    public void earnMoney(int amount) { // �� or �����
        money = money + amount;
    }
    
    public void spendMoney(int amount) { // ���
        money = money - amount;
    }
    
    public void print() {
        System.out.println(name +" ���]�̦� "+ money + " ��"); 
    }
    
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // ���X�ӿ��]
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
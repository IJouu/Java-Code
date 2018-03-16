import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        int bonus = 0, getmoney;
        
        int[] data = new int[6];   
        int[] bet = new int[7];
        
        Scanner input = new Scanner(System.in);
        newLotto(data);
        sort(data);
        
        System.out.print("Answer : " );
        for(int i = 0; i <= 5; i++) {
            System.out.print(data[i]+"    ");
        }
        System.out.println();
        
        System.out.println("請輸入頭獎金額");
        int least = input.nextInt();
        
        Guess(bet);
        for (int j = 0; j < 6; j++) {
            bet[j] = input.nextInt();
        }
        
        Judge(data, bet, least);
        while(true) {
            System.out.println("是否要再挑戰夢想?");
            String r = input.next();
            if (r.equals("Y") || r.equals("y")) {
                bonus += least;
                System.out.println("累積頭彩上看....... "+bonus);
            } else {
                break;
            }
            System.out.println();
        }
    }
    public static void newLotto(int[] data) { //當期樂透號碼
        for (int i = 0; i <= 6; i++) {
            data[i] = (int)Math.floor(Math.random()*49+1); //抽數字
             //檢查是否重複
            for(int j = 0; j < i; j++) {
                if (data[i] == data[j]) {
                    i--;
                    break;
                }
            }       
        }
    }
    public static void sort(int[] data) { // insertion sort
        int x = data.length;
        //i代表要insert的元素位置
        for(int i = 1; i < x; i++){
            int tmp = data[i];
            //j代表要比較的位置
            int j = i - 1;
            while(j >= 0 && data[j] > tmp){
                data[j + 1 ] = data[j];
                j = j -1 ;
            }
            data[j + 1] = tmp;
        }
    }
    public static void Guess(int[] bet) {
        int y = bet.length; //下注號碼
        for (int i = 0; i <= y; i++) {
            if (i == 0) {
                System.out.println("請輸入6個號碼");
            } else if (i > 0 && i < 6){
                System.out.println("還有 "+(6 - i)+" 個號碼可以輸入");
            } else {
                System.out.println("還有 "+(6 - i)+" 個號碼可以輸入");
                break;
            }
            //檢查是不是1~49
            if (bet[i] < 1) {
                System.out.println("請勿小於1");
                i--;
                continue;
            } else if (bet[i] > 49) {
                System.out.println("請勿大於49");
                i--;
                continue;
            }
            //檢查有無重複
            for(int j = 0; j < i; j++) {
                if (bet[i] == bet[j]) {
                    i--;
                    System.out.println("這個號碼已經輸入過了");
                    break;
                }
            }
        }
    }   
    public static void Judge(int[] data, int[] bet, int least) {
        int bonus = 0;
        int getmoney = 0;
        int win = 0;//中獎幾個數字
        //對獎
        for(int i = 0; i <= 5; i++){
            for(int j = 0; j <= 5; j++) {
                if (bet[i] == data[j]) {
                    win++;
                }
            }
        }
        switch(win) {
                case 5:
                    bonus *= (4 / 5);
                    getmoney = bonus * (1 / 5);
                    bonus = bonus - getmoney + least;
                    System.out.println("答對5個!!");
                    System.out.println("獲得Bonus的五分之一 : " + getmoney);
                    break;
                case 6:
                    bonus = least;
                    getmoney = bonus;
                    bonus = bonus - getmoney + least;
                    System.out.println("夢想達成了");
                    System.out.println("獲得全部Bonus : " + getmoney);
                    break;
                default:
                    bonus *= 1;
                    getmoney = 0;
                    bonus = bonus - getmoney + least;
                    System.out.println("加油R");
                    break;
         }
    }
}
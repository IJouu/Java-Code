import java.util.Scanner;

public class Lotto {
    int bonus, least, getmoney;
    public static void newLotto(int[] data) {
        int x = data.length; //�����ֳz���X
        for (int i = 0; i <= x; i++) {
            data[i] = (int)Math.floor(Math.random()*49+1); //��Ʀr
             //�ˬd�O�_����
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
        //i�N���ninsert��������m
        for(int i = 1; i < x; i++){
            int tmp = data[i];
            //j�N���n�������m
            int j = i - 1;
            while(j >= 0 && data[j] > tmp){
                data[j + 1 ] = data[j];
                j = j -1 ;
            }
            data[j + 1] = tmp;
        }
    }
    public static void Guess(int[] bet) {
        int y = bet.length; //�U�`���X
        for (int i = 0; i <= y; i++) {
            if (i == 0) {
                System.out.println("�п�J6�Ӹ��X");
            } else if (i > 0 && i < 6){
                System.out.println("�٦� "+(6 - i)+" �Ӹ��X�i�H��J");
            } else {
                System.out.println("�٦� "+(6 - i)+" �Ӹ��X�i�H��J");
                break;
            }
            //�ˬd�O���O1~49
            if (bet[i] < 1) {
                System.out.println("�ФŤp��1");
                i--;
                continue;
            } else if (bet[i] > 49) {
                System.out.println("�ФŤj��49");
                i--;
                continue;
            }
            //�ˬd���L����
            for(int j = 0; j < i; j++) {
                if (bet[i] == bet[j]) {
                    i--;
                    System.out.println("�o�Ӹ��X�w�g��J�L�F");
                    break;
                }
            }
        }
    }   
    public static void judge(int[] data, int[] bet) {
        int win = 0;//�����X�ӼƦr
        //���
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
                    System.out.println("����5��!!");
                    System.out.println("��oBonus���������@ : " + getmoney);
                    break;
                case 6:
                    bonus = least;
                    getmoney = bonus;
                    bonus = bonus - getmoney + least;
                    System.out.println("�ڷQ�F���F");
                    System.out.println("��o����Bonus : " + getmoney);
                    break;
                default:
                    bonus *= 1;
                    getmoney = 0;
                    bonus = bonus - getmoney + least;
                    System.out.println("�[�oR");
                    break;
         }
    }
    public static void main(String[] args) {
        data[] x = new data[6];
        bet[] y = new bet[7];
        Scanner input = new Scanner(System.in);
        newLotto(x);
        sort(x);
        System.out.print("Answer : " );
        for(int i = 0; i <= 5; i++) {
            System.out.print(x[i]+"    ");
        }
        System.out.println();
        System.out.println("�п�J�Y�����B");
        int least = input.nextInt();
        Guess(y);
        for (int j = 0; j <= 6; j++) {
            y[j] = input.nextInt();
        }
        judge(x, y);
        while(true) {
            System.out.println("�O�_�n�A�D�ԹڷQ?");
            if (r.equals("Y") || r.equals("y")) {
                bonus += least;
                System.out.println("�ֿn�Y�m�W��....... "+bonus);
            } else {
                break;
            }
            System.out.println();
        }
    }
}
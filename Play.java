/*
*104213027
*�����X
*/
import java.util.Scanner;
import java.lang.Math; 
class Car {
    private String name; // �]�r��name�����l���W�r
    private int pointX = 0; 
    private int pointY = 0; 
    
    public Car(String name) { // �]�w���l�W�r
        this.name = name;
    }
    
    public int[] getPoints() { // ���o�I����I���m
        int[] site = new int[2];
        site[0] = pointX;
        site[1] = pointY;
        return site;
    }
    
    public void setPoints(int X, int Y) { // �]�w�I����I���m
        pointX = X;
        pointY = Y;
    }
    
    public String getName() { // �^�Ǩ��l�W�r
        return name;
    }
    
    public void go(int X, int Y) { // ���l���ʨ� X , Y
        int moveX = X - pointX; // �e�i���B��
        int moveY = Y - pointY;
        // �P�_Y���V�W�ΦV�U���X�B
        if (moveY > 0) { 
            System.out.println("�V�U�� ��"+ moveY + "�B");
        } else if (moveY < 0) {
            System.out.println("�V�W�� ��"+ Math.abs(moveY) + "�B");
        }
        // �P�_X���V�k�ΦV�����X�B
        if (moveX > 0) {
            System.out.println("�V�k�� ��"+ moveX + "�B");
        } else if (moveX < 0) {
            System.out.println("�V���� ��"+ Math.abs(moveX) + "�B");
        }
        setPoints(X, Y); // ���ʫ᪺�y��
    }
}

public class Play {
    public static void main (String[] argv) {
        Scanner input = new Scanner(System.in);
        System.out.print("��J���W : ");
        Car MyCar = new Car(input.next()); // ��J���l���W�r
        for ( ; ; ) {
            System.out.print("�п�J���O:");
            String command = input.next();
            if (command.equals("go")) { // ���ʨ��l
                int x = input.nextInt(); // ��J�V�W(or�U)��x�B
                int y = input.nextInt(); // ��J�V��(or�k)��y�B
                // �ˬd�O�_�W�X�ѽL�d��
                if (0 <= x && x <= 10 && 0 <= y && y <= 10) { 
                    MyCar.go(x, y); // �b�d�򤺫h�~��e�i
                } else {
                    System.out.println("�W�X�ѽL�d��");
                }
            } else if(command.equals("list")) { // ��ܲ{�b�y��
                System.out.println(MyCar.getName() + " " + "�b(" + MyCar.getPoints()[0] + "," + MyCar.getPoints()[1]+ ")");
            } else if(command.equals("end")) { // �����{��
                System.out.println("���}...");
                break;
            } else {
                System.out.println("���O�L�ġA���s��J");
            }
        }
    }
}
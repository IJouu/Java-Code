import java.lang.*;
import java.util.Scanner;

public class �ìP {
    String name; // object variable
    static int total�ìP; // class variable
    public �ìP() { // constructor
        System.out.println("�s�ìP���ͤF");
        total�ìP ++;
    }
    // method finalize() will be called by GC
    protected void finalize() { 
        System.out.println(name + " �Q�^���F");
        total�ìP --;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        �ìP ����Y; // �ܼƫ��A�Oreference to �ìP
        ����Y = new �ìP();
        ����Y.name = "��y";
        ����Y = new �ìP();
        ����Y.name = "���2";
        System.gc(); // garbage collection
        input.next(); // ����
        System.out.println("�o�@�ɳѤU " + �ìP.total�ìP + " �ӽìP");
        
        /*int i = 0; // local variable
        for (;;) {
            �ìP x = new �ìP();
            x.name = "�ìP"+ i++;
        }
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();*/
    }
}

// byte short int long float double char boolean
// 8�إH�~�ҬOreference
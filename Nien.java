// ��r��
import java.util.Scanner;
public class Nien {
    public static void main (String[] argv) {
        ��r�� ���ߪ���r�� = new ��r��();
        Scanner input = new Scanner(System.in);
        int count = 0; // �ΥH�p���J�Ӽ�

        while (true) {
            String cmd = input.next();
            if ( cmd.equals("break") ) {
                break;
            }
            ���ߪ���r��.add( new ��r( cmd, input.next() ) );
            count++;
        }

        for (int i = 0; i < count; i++) {
            ��r temp = ���ߪ���r��.display(i);
            System.out.print(temp.��� + " ");
        }
        System.out.println();
        for (int i = 0; i < count; i++) {
            ��r temp = ���ߪ���r��.display(i);
            System.out.print(temp.���� + " ");
        }
    }
}

class ��r {
    String ���;
    String ����;

    ��r (String ���, String ����) {
        this.��� = ���;
        this.���� = ����;
    }
}

class ��r�� {
    ��r[] ��r�s = new ��r[100];
    int size;

    void add (��r temp) {
        ��r�s[size++] = temp;
    }

    ��r display (int n) {
        return ��r�s[n];
    }
}

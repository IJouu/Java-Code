import java.util.Scanner;
public class �_����r�� {
    public static void main(String[] argv) {
        ��r�� �ڪ���r�� = new ��r��();
        Scanner input = new Scanner(System.in);
        System.out.println("�п�J���O");
        System.out.println(" - �s�W��r�Gadd [��r] [����]");
        System.out.println(" - ����Gquiz [�D��]");
        System.out.println(" - ��W��r���Gquit");
        while ( input.hasNext() ) {
            String command = input.next();
            if ( command.equals("add") ) {
                �ڪ���r��.add( input.next(), input.next() );
            } else if ( command.equals("quiz") ) {
                int �D�� = input.nextInt();
                int ���� = 0;
                for (int i = 1; i <= �D��; i++) {
                    ��r �D�� = �ڪ���r��.get();
                    System.out.print(�D��.���� + " ");
                    String ���� = input.next();
                    if ( ����.equals(�D��.title) ) {
                        ����++;
                        System.out.println("����I");
                    } else {
                        System.out.println("�����I");
                    }
                }
                System.out.println("�@��o�G " + ���� + " ��");
            } else if ( command.equals("quit") ) {
                break;
            }
        }
    }
}

class ��r {
    String title;
    String ����;
    ��r next;
}

class ��r�� {
    ��r head, tail;
    int size;
    void add(String ��r, String ����) {
        ��r tmp = new ��r();
        tmp.title = ��r;
        tmp.���� = ����;
        if (tail != null) {
            tail.next = tmp;
            tail = tmp;
        } else {
            head = tail = tmp;
        }
        size++;
    }
    ��r get() {
        int randNum = (int)(Math.random()*size + 1);
        ��r tmp = head;
        for (int i = 1; i < randNum; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }
}
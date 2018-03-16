/*
*104213027
*�����X
*/
import java.util.Scanner;

public class Homework {
    private String name, time; // �]�r��name���@�~�W�١Atime���@�~ú��ɶ�
    private boolean state; // �]state���@�~ú�檬�A
    
    public void submit() { // ��X�@�~
        state = true; // �h���A��ܤwú��
    }
    
    public boolean compareDate(String deadline) { // �������P�_�O�_�O��
        String[] timeArray = time.split("-"); // �N��r��Q��"-"��}�s�J�r��}�C
        String[] deadlineArray = deadline.split("-");
        for (int i = 0; i < timeArray.length; i++) {
            int x = Integer.parseInt(timeArray[i]); // �N�r���ର��ƫ��A�h������j�p
            int y = Integer.parseInt(deadlineArray[i]);
            if (x > y) { // �W�Lú�����
                return true;
            } else if (x < y) { // �|���O��
                return false;
            }
        }
        return false;
    }
    
    public Homework (String name, String time) { // 
        this.name = name;
        this.time = time;
    }
    
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        Homework[] MyHw = new Homework[100]; // �]�@�Ӧs�J�@�~���}�C
        int numHw = 0; // �@�~�ƶq
        System.out.println("�п�J�\���`�I��ɶ� : ");
        String deadline = input.next(); // ��J�\���`�I��ɶ�
        while (true) {
            String command = input.next();
            if (command.equals("new")) { // �s�W�@�~
                MyHw[numHw++] = new Homework(input.next(), input.next());
            } else if (command.equals("end")) { // �����{���A�̫�L�X���G
                break;
            } else if (command.equals("submit")) { // ú��@�~
                String name = input.next(); // ��J�wú�檺�@�~
                for (int i = 0; i < numHw; i++) { // �ˬd�O�_��ú��@�~
                    if (MyHw[i].name.equals(name)) { // �wú��h�^��true
                        MyHw[i].submit(); 
                    }
                }
            }
        }
        for (int i = 0; i < numHw; i++) { // �ˬd�@�~���A���O�_��ú��@�~�άO�_�O��
            // �|��ú��B�O���A�h�|��ܸӥ\�ҿ��
            if (MyHw[i].compareDate(deadline) == true && MyHw[i].state == false) { 
                System.out.println("�@�~ : " + MyHw[i].name + " " + "���"); 
            // �|��ú��B�|���O���A�h�|��ܰO�o�n�@�~
            } else if (MyHw[i].compareDate(deadline) == false && MyHw[i].state == false) { 
                System.out.println("�@�~ : " + MyHw[i].name + " " + "�O�o�n�@�~"); 
            } else { // �w�gú��A�h�|��ܤw�gú��
                System.out.println("�@�~ : " + MyHw[i].name + " " + "�w�gú��");
            }
        }
    }
}
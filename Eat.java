import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Eat {
    public static void main(String [] argv) throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("����\�U�п�J1");
        System.out.println("��s�W��п�J2");
        System.out.print("�� ");
        int next = input.nextInt();
        System.out.println();

        if (next == 1){
            FileReader fr = new FileReader("restaurant.txt");
            BufferedReader br = new BufferedReader(fr);
            String[] allrestaurant = new String[2000];
            int length = 0;
            
            while(br.ready()){
                allrestaurant[length++] = br.readLine();
            }
            
            length = 0;
            while(allrestaurant[length] != null){
                // System.out.println(allrestaurant[length++]);
                length++;
            }

            int rand = (int)(Math.random() * length);
            if (allrestaurant[rand] != null) {
                System.out.println("���ѧڭ̴N�Y " + allrestaurant[rand] + " �a�I�I");
            } else {
                System.out.println("�\�U�w�g�Χ��F��A�Э��s��s");
            }

            length = 0;
            FileWriter fw = new FileWriter("restaurant.txt");
            while(allrestaurant[length] != null){
                if(allrestaurant[length] != allrestaurant[rand]){
                    fw.write(allrestaurant[length] + "\r\n");
                }
                length++;
            }
            fw.close();

        } else if (next == 2) {
            FileReader fr = new FileReader("allrestaurant.txt");
            BufferedReader br = new BufferedReader(fr);
            String [] allrestaurant = new String[2000];
            int length = 0;

            while(br.ready()){
                allrestaurant[length++] = br.readLine();
            }

            length = 0;
            while(allrestaurant[length] != null){
                // System.out.println(allrestaurant[length++]);
                length++;
            }

            System.out.println("�W��w��s");
            length = 0;
            FileWriter fw = new FileWriter("restaurant.txt");
            while(allrestaurant[length] != null){
                fw.write(allrestaurant[length] + "\r\n");
                length++;
            }
            fw.close();
        }
    }
}
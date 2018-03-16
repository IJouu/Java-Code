import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

class Personal {
    public String name;
    public int math;
    public int prog;
    public int total;
    public Personal(String na, int ma, int pr, int to) {
        name = na;
        math = ma;
        prog = pr;
        total = to;
    }
}

public class Exam01 {
    public static void print(int times) {
        System.out.println("材" + times + ":");
    }
    public static void main(String[] argv) throws IOException {
        int tmp, min;
        String tmpn;
        Personal[] data = new Personal[10];
        int[] ma = new int [10];
        int[] pr = new int [10];
        int[] to = new int[10];
        String[] na = new String[10]; 
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("output.txt");
        br.readLine();
        while (br.ready()) {           
            String[] test = br.readLine().split(" ");
            String[] test01 = br.readLine().split(" ");
            String[] test02 = br.readLine().split(" ");
            for (int i = 0; i < 10; i++) {
                na[i] = test[i];
            }
            for (int i = 0; i < 10; i++) {
                ma[i] = Integer.parseInt(test01[i]);
            }
            for (int i = 0; i < 10; i++) {
                pr[i] = Integer.parseInt(test02[i]);
            }
            for (int i = 0; i < 10; i++) {
                to[i] = ma[i] + pr[i];
            }
            for (int i = 0; i < 10; i++) {
                data[i] = new Personal(na[i], ma[i], pr[i], to[i]);
            }
            
            System.out.println("﹍だ计:..........");
            fw.write("﹍だ计:.........");
            fw.write("\r\n");
            for (int i = 0; i < data.length; i++) {
                System.out.println(data[i].name + "(计厩:" + data[i].math + " 祘砞:" + data[i].prog + " 羆だ:" + data[i].total + ")");
                fw.write(data[i].name + "(计厩:" + data[i].math + " 祘砞:" + data[i].prog + " 羆だ:" + data[i].total + ")");
                fw.write("\r\n");
            }
            System.out.println("\r\n");
            fw.write("\r\n");
            // 逼
            for (int i = 0; i < data.length - 1; i++) {
                min = i;
                for (int j = i + 1; j < data.length; j++) {
                    if (data[j].total < data[min].total) {
                        min = j;
                    }
                }
                tmp = data[min].total;
                data[min].total = data[i].total;
                data[i].total = tmp;
                
                tmpn = data[min].name;
                data[min].name = data[i].name;
                data[i].name = tmpn;

                print(i + 1);
                for (int k = 0; k < data.length; k++) {
                    fw.write(data[k].name + "(" + data[k].total + ")  ");
                    System.out.print(data[k].name + "(" + data[k].total + ")  ");
                }
                fw.write("\r\n");
                System.out.println("\r\n");
            }
            fw.flush();
            fw.close();
        }    
        fr.close();
    }
}
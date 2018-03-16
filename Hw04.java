import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Hw04 {
    public static void main(String[] argv) throws IOException {
        int[] num = new int [10];
        int tmp, min;

        FileReader fr = new FileReader("data.txt");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("output.txt");
        
        br.readLine();
        while (br.ready()) {           
            String[] test = br.readLine().split(" ");
            for (int i = 0; i < test.length; i++) {
                num[i] = Integer.parseInt(test[i]);
            }
            for (int i = 1; i < num.length; i++) {
                tmp = num[i];
                int j = i - 1;
                while (j > -1 && tmp < num[j]) {
                    num[j + 1] = num[j];
                    j--;
                }
                num[j + 1] = tmp;

                for (int k = 0; k < num.length; k++) {
                    fw.write(num[k] + " " );
                }
                fw.write("\r\n");
            }
            fw.flush();
            fw.close();
        }    
        fr.close();
    }
}
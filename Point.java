import java.util.Scanner;
import java.lang.Math;
class Car {
    public String name;
    public double pointX = 0;
    public double pointY = 0;

    public Point(String name, double pointX, double pointY) {
        this.name = name;
        this.pointX = pointX;
        this.pointY = pointY;
    }
    public void distance(Car[] allcars, int num) {
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; i < num; j++) {
                double x = Math.pow(allcars[i].pointX - allcars[j].pointX, 2);
                double y = Math.pow(allcars[i].pointY - allcars[j].pointY, 2);
                double result = Math.sqrt(x + y);
                System.out.println(result);
            }
        }
    }
}

public class Car {
    public static void main (String[] argv) {
        Scanner input = new Scanner(System.in);
        Car[] allCars = new Car[10000];
        int num = 0;
        for ( ; ; ) {
            System.out.print("請輸入指令:");
            String command = input.next();
            if (command.equals("new")) {
                allCars[num++] = new Car(input.next(), input.nextDouble(), input.nextDouble());
            } else if (command.equals("cal")) {
                distance(allCars, num);
            } else if(command.equals("end")) {
                System.out.println("離開...");
                break;
            } else {
                System.out.println("指令無效，重新輸入");
            }
        }
    }
}

import java.util.Scanner;
import java.lang.Math;

public class Car {
    String name;
    double x;
    double y;
    public Car(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public void east(double x){
        this.x += x;
    }
    public void west(double x){
        this.x -= x;
    }
    public void north(double y){
        this.y += y;
    }
    public void south(double y){
        this.y -= y;
    }

    public void print(){
        System.out.println(name + " " + x + " " + y);
    }

    public static void distance(Car[] allcars, int num) {
        for (int i = 0; i < num; i++) {
            if (allcars[i] != null) {
                for (int j = i + 1; j < num; j++) {
                    if (allcars[j] != null) {
                        double pointx = Math.pow(allcars[j].x - allcars[i].x, 2);
                        double pointy = Math.pow(allcars[j].y - allcars[i].y, 2);
                        double result = Math.sqrt(pointx + pointy);
                        System.out.println(allcars[i].name + " to " + allcars[j].name + " " + result);
                    }
                }
            }
        }
    }
    public static void line(Car car1, Car car2) {
        double a = (car2.y - car1.y) / (car2.x - car1.x);
        double b = car1.y - (a * car1.x);
        if ((car2.x - car1.x) == 0) {
            System.out.println("x = " + car1.x);
        } else if (a == 0) {
            System.out.println("y = " + car1.y);
        } else {
            System.out.println("y = " + a + " * x + " + b);
        }
    }

    public static void main(String[] argv) {
        Car[] allCars = new Car[1000];
        int num = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            String command = input.next();
            if (command.equals("new")) {
                allCars[num++] = new Car(input.next(), input.nextInt(), input.nextInt());
            } else if (command.equals("destroy")) {
                String name = input.next();
                int i;
                for (i = 0; i < num; i++) {
                    if (allCars[i].name.equals(name)) {
                        allCars[i] = null;
                    }
                }
            } else if (command.equals("line")) {
                String name1 = input.next();
                String name2 = input.next();
                for (int i = 0; i < num; i++) {
                    for (int j = 0; j < num; j++) {
                        if (allCars[i] != null && allCars[j] != null) {
                            if (allCars[i].name.equals(name1) && allCars[j].name.equals(name2)) {
                                line(allCars[i], allCars[j]);
                            }
                        }
                    }
                }
            } else if (command.equals("end")) {
                break;
            } else {
                int i;
                String name = input.next();
                for (i = 0; i < num; i++) {
                    if (allCars[i].name.equals(name)) {
                        break;
                    }
                }
                if (command.equals("east")) {
                    double move = input.nextDouble();
                    allCars[i].east(move);
                } else if (command.equals("west")) {
                    double move = input.nextDouble();
                    allCars[i].west(move);
                } else if (command.equals("south")) {
                    double move = input.nextDouble();
                    allCars[i].south(move);
                } else if (command.equals("north")) {
                    double move = input.nextDouble();
                    allCars[i].north(move);
                }
            }
        }
        for (int i = 0; i < num; i++) {
            if (allCars[i] != null) {
                allCars[i].print();
            }
        }
        distance(allCars, num);
    }
}

import java.util.Scanner;
import java.lang.Math;

class Student {
    private String id;
    private double score;

    public Student(String id, double score) {
        this.id = id;
        this.score = score;
    }
    public String getId() {
        return id;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double newScore) {
        if (newScore < 0) {
            newScore = 0;
        } else if (newScore > 100) {
            newScore = 100;
        }
        score = newScore;
    }

}

public class Score {
    public static void print(Student[] allstu, int num) {
        double total = 0;
        double avg = 0;
        for(int i = 0; i < num; i++) {
            total += allstu[i].getScore();
            avg = total / num;
        }
        System.out.println("Class Average : " + avg);
        System.out.println("flunked :");
        for (int i = 0; i < num; i++) {
            if (allstu[i].getScore() < 60) {
                System.out.println(allstu[i].getId() + ": " + allstu[i].getScore());
            }
        }
    }
    public static void plus(Student[] allstu, int num, double score) {
        double[] finscore = new double[num];
        for (int i = 0; i < num; i++) {
            finscore[i] = allstu[i].getScore() + score;
            allstu[i].setScore(finscore[i]);
        }
    }
    public static void lineplus(Student[] allstu, int num, double x, double y) {
        double[] finscore = new double[num];
        for (int i = 0; i < num; i++) {
            finscore[i] = allstu[i].getScore() * x + y;
            allstu[i].setScore(finscore[i]);
        }
    }
    public static void root(Student[] allstu, int num) {
        double[] finscore = new double[num];
        for (int i = 0; i < num; i++) {
            finscore[i] = Math.sqrt(allstu[i].getScore()) *  10;
            allstu[i].setScore(finscore[i]);
        }
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        Student[] allstu = new Student[num];
        for (int i = 0; i < num; i++) {
            allstu[i] = new Student(input.next(), input.nextDouble());
        }
        print(allstu, num);
        while(true) {
            String command = input.next();
            if (command.equals("plus")) {
                double x = input.nextDouble();
                plus(allstu, num, x);
                print(allstu, num);
            } else if (command.equals("line")) {
                 double x = input.nextDouble();
                 double y = input.nextDouble();
                 lineplus(allstu, num, x, y);
                 print(allstu, num);
             } else if (command.equals("root")) {
                  root(allstu, num);
                  print(allstu, num);
            } else if (command.equals("end")) {
                break;
            }
        }
    }
}

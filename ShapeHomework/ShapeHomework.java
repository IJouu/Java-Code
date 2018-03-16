/*
*104213027
*黃奕柔
*/
import java.util.Scanner;
public class ShapeHomework { // 主要執行程式
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 設變數n為輸入的圖形個數
        Shape2D[] x = new Shape2D[n]; // 設一個存放圖形的陣列
        for (int i = 0; i <= n - 1; i++) {
            String type, nickname; // type為圖形類別，nickname為暱稱
            type = input.next(); // 讀入圖形類別
            nickname = input.next(); // 讀入暱稱
            if (type.equals("Circle")) { // 如果圖形類別是Circle
                double r = input.nextDouble(); // 讀入參數
                x[i] = new Circle(nickname, r); // 把暱稱和參數存放在陣列裡
            } else if (type.equals("Rectangle")) { // 如果圖形類別是Rectangle
                double w = input.nextDouble(); // 讀入參數
                double h = input.nextDouble();
                x[i] = new Rectangle(nickname, w, h); // 把暱稱和參數存放在陣列裡
            } else if (type.equals("Square")) { // 如果圖形類別是Square
                double l = input.nextDouble(); // 讀入參數
                x[i] = new Square(nickname, l); // 把暱稱和參數存放在陣列裡
            } else if (type.equals("Triangle")) { // 如果圖形類別是Triangle
                double b = input.nextDouble(); // 讀入參數
                double h = input.nextDouble();
                x[i] = new Triangle(nickname, b, h); // 把暱稱和參數存放在陣列裡
            } else if (type.equals("RegularOctagon")) { // 如果圖形類別是RegularOctagon
                double l = input.nextDouble(); // 讀入參數
                x[i] = new RegularOctagon(nickname, l); // 把暱稱和參數存放在陣列裡
            } else if (type.equals("Trapezoid")) { // 如果圖形類別是Trapezoid
                double u = input.nextDouble(); // 讀入參數
                double d = input.nextDouble();
                double h = input.nextDouble();
                x[i] = new Trapezoid(nickname, u, d, h); // 把暱稱和參數存放在陣列裡
            }
        }
        sort(x);
        for (int i = 0; i <= n - 1; i++) {
            System.out.println(x[i].getName() + " " + x[i].area()); // 印出讀入的暱稱和面積
        }
        System.out.println(); // 換行
        System.out.println(SumShape.sum(x)); // 印出總面積
    }
    public static void sort(Shape2D[] list) { // 使輸出的圖形按照面積大小升冪排列
        for (int i = 0; i <= list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if(list[j].area() > list[j + 1].area()) { // 比較小面積的圖形留下，其他的圖形進行下一輪的比較
                    Shape2D tmp = list[j]; // tmp為暫存
                    list[j] = list[j + 1];
                    list[j + 1] = tmp;
                }
            }
        }
    }
}
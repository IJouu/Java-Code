/*
*104213027
*黃奕柔
*/
import java.util.Scanner;
import java.lang.Math; 
class Car {
    private String name; // 設字串name為車子的名字
    private int pointX = 0; 
    private int pointY = 0; 
    
    public Car(String name) { // 設定車子名字
        this.name = name;
    }
    
    public int[] getPoints() { // 取得點Ｘ及點Ｙ位置
        int[] site = new int[2];
        site[0] = pointX;
        site[1] = pointY;
        return site;
    }
    
    public void setPoints(int X, int Y) { // 設定點Ｘ及點Ｙ位置
        pointX = X;
        pointY = Y;
    }
    
    public String getName() { // 回傳車子名字
        return name;
    }
    
    public void go(int X, int Y) { // 車子移動到 X , Y
        int moveX = X - pointX; // 前進的步數
        int moveY = Y - pointY;
        // 判斷Y為向上或向下走幾步
        if (moveY > 0) { 
            System.out.println("向下走 走"+ moveY + "步");
        } else if (moveY < 0) {
            System.out.println("向上走 走"+ Math.abs(moveY) + "步");
        }
        // 判斷X為向右或向左走幾步
        if (moveX > 0) {
            System.out.println("向右走 走"+ moveX + "步");
        } else if (moveX < 0) {
            System.out.println("向左走 走"+ Math.abs(moveX) + "步");
        }
        setPoints(X, Y); // 移動後的座標
    }
}

public class Play {
    public static void main (String[] argv) {
        Scanner input = new Scanner(System.in);
        System.out.print("輸入車名 : ");
        Car MyCar = new Car(input.next()); // 輸入車子的名字
        for ( ; ; ) {
            System.out.print("請輸入指令:");
            String command = input.next();
            if (command.equals("go")) { // 移動車子
                int x = input.nextInt(); // 輸入向上(or下)走x步
                int y = input.nextInt(); // 輸入向左(or右)走y步
                // 檢查是否超出棋盤範圍
                if (0 <= x && x <= 10 && 0 <= y && y <= 10) { 
                    MyCar.go(x, y); // 在範圍內則繼續前進
                } else {
                    System.out.println("超出棋盤範圍");
                }
            } else if(command.equals("list")) { // 顯示現在座標
                System.out.println(MyCar.getName() + " " + "在(" + MyCar.getPoints()[0] + "," + MyCar.getPoints()[1]+ ")");
            } else if(command.equals("end")) { // 結束程式
                System.out.println("離開...");
                break;
            } else {
                System.out.println("指令無效，重新輸入");
            }
        }
    }
}
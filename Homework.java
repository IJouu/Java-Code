/*
*104213027
*黃奕柔
*/
import java.util.Scanner;

public class Homework {
    private String name, time; // 設字串name為作業名稱，time為作業繳交時間
    private boolean state; // 設state為作業繳交狀態
    
    public void submit() { // 交出作業
        state = true; // 則狀態顯示已繳交
    }
    
    public boolean compareDate(String deadline) { // 比較日期判斷是否逾期
        String[] timeArray = time.split("-"); // 將原字串利用"-"拆開存入字串陣列
        String[] deadlineArray = deadline.split("-");
        for (int i = 0; i < timeArray.length; i++) {
            int x = Integer.parseInt(timeArray[i]); // 將字串轉為整數型態去做比較大小
            int y = Integer.parseInt(deadlineArray[i]);
            if (x > y) { // 超過繳交期限
                return true;
            } else if (x < y) { // 尚未逾期
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
        Homework[] MyHw = new Homework[100]; // 設一個存入作業的陣列
        int numHw = 0; // 作業數量
        System.out.println("請輸入功課總截止時間 : ");
        String deadline = input.next(); // 輸入功課總截止時間
        while (true) {
            String command = input.next();
            if (command.equals("new")) { // 新增作業
                MyHw[numHw++] = new Homework(input.next(), input.next());
            } else if (command.equals("end")) { // 結束程式，最後印出結果
                break;
            } else if (command.equals("submit")) { // 繳交作業
                String name = input.next(); // 輸入已繳交的作業
                for (int i = 0; i < numHw; i++) { // 檢查是否有繳交作業
                    if (MyHw[i].name.equals(name)) { // 已繳交則回傳true
                        MyHw[i].submit(); 
                    }
                }
            }
        }
        for (int i = 0; i < numHw; i++) { // 檢查作業狀態→是否有繳交作業及是否逾期
            // 尚未繳交且逾期，則會顯示該功課遲交
            if (MyHw[i].compareDate(deadline) == true && MyHw[i].state == false) { 
                System.out.println("作業 : " + MyHw[i].name + " " + "遲交"); 
            // 尚未繳交且尚未逾期，則會顯示記得要作業
            } else if (MyHw[i].compareDate(deadline) == false && MyHw[i].state == false) { 
                System.out.println("作業 : " + MyHw[i].name + " " + "記得要作業"); 
            } else { // 已經繳交，則會顯示已經繳交
                System.out.println("作業 : " + MyHw[i].name + " " + "已經繳交");
            }
        }
    }
}
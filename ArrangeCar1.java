import java.util.Scanner;
class CarInfo {
    int carid;
    boolean[] hasToGo; // stations must visited
}
public class ArrangeCar1 {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int totalCars, totalStations;
        totalCars = input.nextInt();
        totalStations = input.nextInt();
        // read in data
        CarInfo[] list = new CarInfo[totalCars];
        int remain = 0; // total stations must be visited
        for (int i = 0; i < totalCars; i++) {
            list[i] = new CarInfo();
            list[i].carid = i + 1;
            list[i].hasToGo = new boolean[totalStations];
            int stationsToGo = input.nextInt();
            remain += stationsToGo;
            for (int j = 0; j < stationsToGo; j++) {
                list[i].hasToGo[input.nextInt() - 1] = true;
            }
        }

        // arrange cars
        // 當還有車要上貨時
        while(remain > 0) {
            // 設定每台車都有空
            boolean[] busy = new boolean[totalCars];
            // 幫每個點找台車上貨
            for(int stationNo = 0; stationNo < totalStations; stationNo++) {
                // 掃描每台車，如果要在這個點上貨，且有空
                int at = -1;
                for(int carNo = 0; carNo < totalCars; carNo++) {
                    if(list[carNo].hasToGo[stationNo] && !busy[carNo]) {
                        at = carNo;
                        // 設定這台車這個點已經不用來了
                        list[carNo].hasToGo[stationNo] = false;
                        // 設定這台車沒空
                        busy[carNo] = true;
                        // 要上貨的點-1
                        remain--;
                        // 處理剩下一個點
                        break;
                    }
                }
                System.out.print((at + 1) + " ");
            }
            // 輸出換行符號
            System.out.println();
        }
    }
}

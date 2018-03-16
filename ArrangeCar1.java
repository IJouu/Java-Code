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
        // ���٦����n�W�f��
        while(remain > 0) {
            // �]�w�C�x��������
            boolean[] busy = new boolean[totalCars];
            // ���C���I��x���W�f
            for(int stationNo = 0; stationNo < totalStations; stationNo++) {
                // ���y�C�x���A�p�G�n�b�o���I�W�f�A�B����
                int at = -1;
                for(int carNo = 0; carNo < totalCars; carNo++) {
                    if(list[carNo].hasToGo[stationNo] && !busy[carNo]) {
                        at = carNo;
                        // �]�w�o�x���o���I�w�g���ΨӤF
                        list[carNo].hasToGo[stationNo] = false;
                        // �]�w�o�x���S��
                        busy[carNo] = true;
                        // �n�W�f���I-1
                        remain--;
                        // �B�z�ѤU�@���I
                        break;
                    }
                }
                System.out.print((at + 1) + " ");
            }
            // ��X����Ÿ�
            System.out.println();
        }
    }
}

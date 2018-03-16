import java.util.Scanner;

public class JFC{
	public static void main(String[] args){
		int bonus = 0;//獎金
		int period = 0;//期數
		Scanner console = new Scanner(System.in);
		int least = 0;
		while(true){
			period++;
			int[] lotto = new int[6];//當期樂透號碼
			for(int i=0;i<=5;i++){
				lotto[i] = (int)Math.floor(Math.random()*49+1);//抽數字
				//檢查是否重複
				for(int j=0;j<i;j++){
					if(lotto[i] == lotto[j]){
						i--;
						break;
					}
				}
			}
			sort(lotto);//從小到大排序
			//輸出結果
			System.out.print("本期樂透號碼: ");
			for(int n=0;n<=5;n++){
				System.out.print(lotto[n]+" ");
			}
			System.out.println();
			if(period == 1){
				System.out.println("請輸入頭獎金額");
				least = console.nextInt();//每期頭獎獎金
			}
			bonus += least;
			System.out.println("目前是第"+period+"期  累積頭獎獎金上看 "+bonus+" 元");
			int[] bet = new int[6];//下注號碼
			for(int k=0;k<=5;k++){
				if(k == 0){
					System.out.println("請輸入6個號碼");
				}else{
					System.out.println("還有 "+(6-k)+" 個號碼可以輸入");
				}
				bet[k] = console.nextInt();
				//檢查是不是1~49
				if(bet[k]<1 || bet[k]>49){
					System.out.println("請輸入1~49的數字");
					k--;
					continue;
				}
				//檢查有無重複
				for(int l=0;l<k;l++){
					if(bet[k] == bet[l]){
						k--;
						System.out.println("這個號碼已經輸入過了");
						break;
					}
				}
			}
			int win = 0;//中獎幾個數字
			//對獎
			for(int m=0;m<=5;m++){
				for(int o=0;o<=5;o++){
					if(bet[m] == lotto[o]){
						win++;
					}
				}
			}
			System.out.print("此次共對中 "+win+" 個數字 ");
			System.out.println();
			switch(win){
				case 0:
					System.out.println("加油R");
					break;
				case 5:
					System.out.println("差一點點");
					bonus *= (4/5);
					break;
				case 6:
					System.out.println("夢想達成");
					bonus = 0;
					break;
				default:
					System.out.println();
			}
			System.out.println();
			//是否要再挑戰夢想?
			System.out.println("是否要再挑戰夢想?");
			String r = console.next();
			if(r.equals("Y") || r.equals("y")){
				;
			}else{
				break;
			}
			System.out.println();
		}
	}

	public static void sort(int[] data){//insertion sort
		int n = data.length;
		//i代表要insert的元素位置
		for(int i=1;i<n;i++){
			int tmp = data[i];
			//j代表要比較的位置
			int j = i -1;
			while(j>=0 && data[j]>tmp){
				data[j+1]=data[j];
				j = j -1 ;
			}
			data[j+1] = tmp;
		}
	}
}
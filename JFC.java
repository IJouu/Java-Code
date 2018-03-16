import java.util.Scanner;

public class JFC{
	public static void main(String[] args){
		int bonus = 0;//����
		int period = 0;//����
		Scanner console = new Scanner(System.in);
		int least = 0;
		while(true){
			period++;
			int[] lotto = new int[6];//����ֳz���X
			for(int i=0;i<=5;i++){
				lotto[i] = (int)Math.floor(Math.random()*49+1);//��Ʀr
				//�ˬd�O�_����
				for(int j=0;j<i;j++){
					if(lotto[i] == lotto[j]){
						i--;
						break;
					}
				}
			}
			sort(lotto);//�q�p��j�Ƨ�
			//��X���G
			System.out.print("�����ֳz���X: ");
			for(int n=0;n<=5;n++){
				System.out.print(lotto[n]+" ");
			}
			System.out.println();
			if(period == 1){
				System.out.println("�п�J�Y�����B");
				least = console.nextInt();//�C���Y������
			}
			bonus += least;
			System.out.println("�ثe�O��"+period+"��  �ֿn�Y�������W�� "+bonus+" ��");
			int[] bet = new int[6];//�U�`���X
			for(int k=0;k<=5;k++){
				if(k == 0){
					System.out.println("�п�J6�Ӹ��X");
				}else{
					System.out.println("�٦� "+(6-k)+" �Ӹ��X�i�H��J");
				}
				bet[k] = console.nextInt();
				//�ˬd�O���O1~49
				if(bet[k]<1 || bet[k]>49){
					System.out.println("�п�J1~49���Ʀr");
					k--;
					continue;
				}
				//�ˬd���L����
				for(int l=0;l<k;l++){
					if(bet[k] == bet[l]){
						k--;
						System.out.println("�o�Ӹ��X�w�g��J�L�F");
						break;
					}
				}
			}
			int win = 0;//�����X�ӼƦr
			//���
			for(int m=0;m<=5;m++){
				for(int o=0;o<=5;o++){
					if(bet[m] == lotto[o]){
						win++;
					}
				}
			}
			System.out.print("�����@�襤 "+win+" �ӼƦr ");
			System.out.println();
			switch(win){
				case 0:
					System.out.println("�[�oR");
					break;
				case 5:
					System.out.println("�t�@�I�I");
					bonus *= (4/5);
					break;
				case 6:
					System.out.println("�ڷQ�F��");
					bonus = 0;
					break;
				default:
					System.out.println();
			}
			System.out.println();
			//�O�_�n�A�D�ԹڷQ?
			System.out.println("�O�_�n�A�D�ԹڷQ?");
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
		//i�N��ninsert��������m
		for(int i=1;i<n;i++){
			int tmp = data[i];
			//j�N��n�������m
			int j = i -1;
			while(j>=0 && data[j]>tmp){
				data[j+1]=data[j];
				j = j -1 ;
			}
			data[j+1] = tmp;
		}
	}
}
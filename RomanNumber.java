// ù���Ʀr�P���ԧB�Ʀr���ഫ
import java.util.*;
public class RomanNumber{
    public static int[] rule={1,5,10,50,100,500,1000};
    public static char[] rrule={'I','V','X','L','C','D','M'};
    public static void main(String[] argv){
        Scanner input=new Scanner(System.in);
        for(;;){
            if(input.hasNextInt()){
                int x=input.nextInt();
                if(x<4000&&x>0)
                    System.out.println("�ഫ���G�G"+trans(x));
                else
                    System.out.println("�ƭȻݤ���0~4000����");
            }
            else{
                String x=input.next();
                int ans=trans(x);
                if(ans<4000&&ans>0)
                    System.out.println("�ഫ���G�G"+ans);
                else
                    System.out.println("�ƭȻݤ���0~4000����");
            }
        }
    }
    //��ƦP�W�A�ǤJ�ƭȤ��P�A�s��overloading
    public static String trans(int x){//���ԧB��ù��
        int count=0;
        String sum=new String();
        while(x!=0){//�[�`���ɭԦb�����[�J +""+ ����Y�ǯS�ҷ|����r�ন�Ʀr�A�ר�b9�����p�|�X���D
            if(x%10==4)//4�����p
                sum=rrule[count]+""+rrule[count+1]+""+sum;
            else if(x%10==9)//9�����p
                sum=rrule[count]+""+rrule[count+2]+""+sum;
            else if(x%10<4)//0~3�����p
                for(int i=0;i<x%10;i++)
                    sum=rrule[count]+""+sum;
            else{
                for(int i=0;i<x%10-5;i++)//5~8�����p
                    sum=rrule[count]+""+sum;
                sum=rrule[count+1]+""+sum;
            }
            count+=2;//��ƨC�������A�ھ�rule���Ʀr�A�@��� 0~1 �G��� 2~3 �T��� 4~5 �|��� 6
            x/=10;
        }
        return sum;
    }
    public static int trans(String s){//ù������ԧB
        int[] data=new int[s.length()];
        for(int i=0;i<s.length();i++){//�N�r���ഫ���Ʀr�x�s�i�}�C
            for(int j=0;j<rrule.length;j++)//�P�_�r����Ʀr���۹��m
                if(s.charAt(i)==rrule[j])
                    data[i]=rule[j];
        }
        int sum=0;
        int count=0;//�p��{�b�b�ĴX�Ӧr��
        while(count<data.length){//�p���`�M
            sum+=data[count];
            if(count>0&&data[count]>data[count-1])
                sum-=data[count-1]*2;
            count++;
        }
        return sum;
    }
}
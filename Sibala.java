public class Sibala {
    int[] dice;  // ��l
    int score;   // ����
    String name; // ���a�W�r
    public Sibala(String pname) {
        this.dice = new int[3];
        this.name = pname;
        // ��X�H���I��( 1~6 )
        for (int i = 0; i< dice.length; i++) {
            dice[i] = (int)(Math.random()*6+1);
        }
    }
    // �P�_�I�ƪ��j�p�εP��
    public String check() {
        if (dice[0] + dice[1] + dice[2] == 3) {
            this.score = 0;
            return "BG";
        } else if (dice[0] == dice[1] && dice[1] == dice[2]) {
            this.score = 100;
            return "�Q�K��";
        } else {
            this.score = dice[0] + dice[1] + dice[2];
            return Integer.toString(this.score) + "�I";
        }
    }
    public static void main(String[] args) {
        Sibala ���z�B = new Sibala("���z�B");
        Sibala ssyu = new Sibala("ssyu");
        // �L�X��l�I�ƤεP��
        System.out.println(���z�B.name + "�Y�X�G" + 
                ���z�B.dice[0] + ", " + 
                ���z�B.dice[1] + ", " + 
                ���z�B.dice[2] + " ");
        System.out.println(���z�B.check());
        System.out.println(ssyu.name + "�Y�X�G" + 
                ssyu.dice[0] + ", " +
                ssyu.dice[1] + ", " +
                ssyu.dice[2] + " ");
        System.out.println(ssyu.check());
        // �P�_��Ĺ
        if(���z�B.score > ssyu.score)
            System.out.println(���z�B.name + " win!!");
        else if(ssyu.score > ���z�B.score)
            System.out.println(ssyu.name + " win!!");
        else
            System.out.println("����A���Ӥ@��");
    }
}
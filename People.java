public class People{
    // 物件的屬性
    String name;
    int id;
    int money = 0;
    static int allmoney;
    // 建構子
    public People(int id, String name){
        this.id = id;
        this.name = name;
    }
    // 物件的方法
    public void sayYourName(){
        System.out.println(this.name);
    }
    public void getMoney(int x){
        this.money = this.money + x;
    }
    // 主程式
    public static void main(String[] argv){
        People ref = new People(26,"Ryan");
        allmoney = allmoney+100;
        ref.money = ref.money+100;

        ref = new People(11,"Amy");
        allmoney = allmoney+100;
        ref.money = ref.money+100;

        ref = new People(30,"John");
        allmoney = allmoney+100;
        ref.money = ref.money+100;

        ref.sayYourName();
        // ref.getMoney(999);
        
        // allmoney是一個static變數
        System.out.println(allmoney); //300
        System.out.println(ref.money); //100
    }
}
// 1. 設定內定值(含所有父子類別)
// 2. call constructor
//  2.1 call parent's constructor
//    2.1.1 call grand parent's constructor
//        .............
//    2.1.2 excute init in parent's declaration
//    2.1.3 excute parent's constructor
//  2.2 excute init in declaration
//  2.3 excute constructor
class Parent {
    int pmoney = 10;
    public Parent() {
    }
    public Parent(int born) {
        pmoney = born;
    }
}
// (1) money = 0, pmoney = 0 // set by jvm
// (2) money = 0, pmoney = 10 // parent's declaration init
// (3) money = 0, pmoney = 200 // parent's constructor
// (4) money = 100, pmoney = 200 // child declaration init
public class Child extends Parent {
    int money = pmoney / 2;
    public Child(int m) {
        // 什麼都沒寫 電腦會幫你加 super();
        super(2 * m);
        // excute declaration init
        // excute constructor body
    }
    public static void main(String[] argv) {
        Child c = new Child(100);
        System.out.println(c.pmoney);
        System.out.println(c.money);
    }
}

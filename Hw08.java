import java.util.Scanner;

class LSNode {
    public String name;
    public int age;
    public LSNode next;
    public LSNode(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public LSNode() { // 預設
        this.name = "";
        this.age = 0;
    }
}

class LinkList {
    LSNode head, tail;
    public LinkList() {
        
    }
    void addAt(LSNode n, int at) { // 加入某一項到List
        LSNode location = head;
        for (int i = 2; i <= at - 1; i++) { // 指向加入的前一項
            // 判斷location是否空值，是 → 跳出，否 → 繼續
            if (location == null) { 
                return;
            }
            location = location.next; 
        }
        if (location == null) { 
            return;
        }
        n.next = location.next;
        location.next = n;
        if (location == tail) { // 判斷location是否為tail，是 → tail指向n
            tail = n;
        }
    }
    void addTail(LSNode n) { // 加到List最後一項
        if (tail != null) {
            tail.next = n;
        } else {
            head = n;
        }
        tail = n;
    }
    void rmHead() { // 刪除List最前一項
        if (head != null) { 
            head = head.next; // 將head指向下一項，原本的head即不存在
        }
        
        if (head == null) { // 判斷head是否為空值，是 → tail也是空值
            tail = null;
        }
    }
    void rmAt(int at) { // 刪除某一項
        LSNode location = head;
        for (int i = 0; i < at - 2; i++) { // 指向刪除的前一項
            if (location == null) { 
                return;
            }
            location = location.next;
        }
        if (location == null) {
            return;
        }
        location.next = location.next.next; // 將刪除的前一項next指向刪除的下一項
        if (location.next == null) {
            tail = location;
        }
    }
    void rmTail() { // 刪除最後一項
        LSNode location = head;
        while(location.next != tail) { 
            location = location.next;
        }
        location.next = null;
        tail = location;
    }
    void reverse() { // 反轉
        if (head == null) {
            return;
        }
        LSNode f1 = head;
        LSNode f2 = head.next;
        LSNode f3;
        
        while(f2 != null) { // 當f2不是空值 → 繼續
            f3 = f2.next;
            f2.next = f1;
            f1 = f2;
            f2 = f3;
        }
        head.next = null; // 反轉後，原本的head變成tail，因此head.next為空值
        tail = head; // 反轉後，原本的tail變成head
        head = f1; // 最後，f1指向的最後一項為head
    }
}

public class Hw08 {
    static int getRandIndex(int n) {
        return (int)(Math.random()*n);
    }
    static int getRandAge() {
        return (int)(Math.random()*41 + 20);
    }
    static void showList(LinkList ll) {
        LSNode location = ll.head;
        int i = 0;
        while(location != null) {
            i++;
            String format = "第 %2d筆資料 姓名 : %12s  年齡 : %d\n";
            System.out.printf(format, i, location.name, location.age);
            location = location.next; // 印完指向下一項
        }
        System.out.println();
    }
    static LinkList merge(LinkList a, LinkList b) {
        a.tail.next = b.head;
        a.tail = b.tail;
        return a;
    }
    public static void main(String[] argv) {
        String[] namePool = {"James","David","Christopher","George","Ronald","John","Richard","Daniel",
                            "Kenneth","Anthony","Robert","Charles","Paul","Steven","Kevin","Michael",
                            "Joseph","Mark","Edward","Jason", "William","Thomas", "Donald","Brian","Jeff"};
        String[] cNamePool = {"曹淑珍","陳士萱","侯淑娟","李冠禾","張佳心","馮昀妤","盧嘉惠","洪淑萍","朱卉一","楊茹俐",
                            "柳子晴","陳詠晴","蕭宜蓁","江品妤","黃子涵","趙品妍","陳詩涵","張思妤","孫品睿","李宸睿"};

        LinkList ll = new LinkList();
        
        for (int i = 1; i <=20; i++) { // 加入List
            ll.addTail(new LSNode(namePool[getRandIndex(namePool.length)], getRandAge()));
        }
        showList(ll);
        
        ll.rmTail(); // 刪除最後一項
        showList(ll);
        
        ll.rmHead(); // 刪除最前一項
        showList(ll);
        
        ll.rmAt(5); // 刪除某一項
        showList(ll);
        
        ll.addAt(new LSNode("資管", 22), 5); // 加入某一項
        showList(ll);
        
        ll.reverse(); // 反轉
        showList(ll);
        
        LinkList ll2 = new LinkList(); // 加入List
        for (int i = 1; i <= 20; i++) {
            ll2.addTail( new LSNode(cNamePool[getRandIndex(cNamePool.length)], getRandAge()));
        }
        showList(ll2);
        
        ll = merge(ll, ll2); // 合併
        ll2 = null;
        showList(ll);
    }
}
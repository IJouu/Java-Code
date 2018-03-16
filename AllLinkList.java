import java.util.Scanner;

class LSNode {
    public String name;
    public int age = 0;
    public LSNode Next = null;
    public LSNode(String name, int age, LSNode Next) {
        this.name = name;
        this.age = age;
        this.Next = Next;
    }
}

public class AllLinkList {
    static LSNode Head;
    static LSNode Tail;
    static int Lenghth = 0;
    //重算Linked List 的長度
    public static void LS_CountLength(LSNode Head, int Length) {
        LSNode ptr = new LSNode();
        ptr = Head; 
        int count = 0;
        while (ptr != null) {
            count++;
            ptr = ptr.Next;
        }
        Length = count;
    }
    //加到 Linked List 最前面
    public static void LS_AddToHead(LSNode node, LSNode Head, LSNode Tail, int Length) {    
        if ((Head == null) && (Tail == null)) {
            Head = node;
            Tail = node;         
        } else {
            node.Next = Head;       
            Head = node;         
        }
        Length++;       
    }
    //加到最後
    public static void LS_Add(LSNode node, LSNode Head, LSNode Tail, int Length) {           
        if ((Head == null) && (Tail ==null)) {
            Head = node;
            Tail = node;                
        } else {
            Tail.Next = node;       
            Tail = node;        
        }
        Length++;        
    }
    //刪去第一項
    public static boolean LS_RemoveHead(LSNode Head, LSNode Tail, int Lenghth) {
        if (Head == null) {
            return false;
        } else {
            LSNode ptr;        
            ptr = Head;         
            Head = Head.Next;       
            ptr = null;        
            Lenghth--;        
            return true;        
        }
    }
    //加在 location 位置之後
    public static boolean LS_InsertAt(LSNode node, LSNode Head, LSNode Tail, int Length, int location) {
        int i = 0;       
        if ((location > Length) || (location < 0)) {//Index 是從0 開始
            return false;       
        } else {
            i = 1;       
            LSNode ptr1 = new LSNode();       
            LSNode ptr2 = new LSNode();
            ptr1 = Head;       
            while (i != location) {
                i++;
                ptr2 = ptr1;
                ptr1 = ptr1.Next;
            }
            ptr2.Next = node;
            node.Next= ptr1;
            Length++;
            return true;
        }
    }
    //remove the item in the location position 
    public static boolean LS_RemoveAt(LSNode Head, LSNode Tail, int Length, int location) {
        int i = 0;        
        if ((location >= Length) || (location < 0)) { //Index 是從0 開始        
            return false;
        } else {
            if (location == 0) {
                LS_RemoveHead(Head, Tail, Length);
                 return true;       
            } else {
                if (location == Length - 1) {
                    LS_Remove(Head, Tail, Length); //LS_Remove 就是 remove 最後一個
                    return true;
                } else {
                    i = 1;
                    LSNode ptr1= new LSNode();
                    LSNode ptr2= new LSNode();
                    ptr1 = Head;
                    while (i != location) {
                        i++;
                        ptr2 = ptr1;
                        ptr1 = ptr1.Next;
                    }
                    ptr2.Next = ptr1.Next;

                    ptr1 = null;
                    Length--;
                    return true;
                }
            }            
        }
    }
    //default remove the last item
    public static boolean LS_Remove(LSNode Head, LSNode Tail, int Lenghth) {
        if ((Head == null) && (Tail == null)) { //nothing to remove
            return false;    
        } else {
            LSNode ptr01, ptr02;        
            ptr02=Head;       
            ptr01 = Head.Next;         
            while (ptr01 != Tail) {
                ptr02 = ptr01;        
                ptr01 = ptr01.Next;         
            }
            if (ptr01 == Tail) {
                Tail = ptr02;        
                ptr02.Next = null;        
                Lenghth--;        
            }
            return true;        
        }
    }
    public static void LS_Reverse(LSNode Head, LSNode Tail) {
        LSNode forward = new LSNode();            
        LSNode current = new LSNode();
        LSNode prev = new LSNode(); 
        if ((Head == null) || (Tail == null)) {
            return;
        } else {
            forward = Head; current = null;         
            while (forward != null) {
                prev = current;
                current = forward;
                forward = forward.Next;
                current.Next = prev; 
            }
            Head = current;

            while (current != null) {
                Tail = current;
                current = current.Next; 
            }
        }
    }
    public static void ShowLS(LSNode Head) {
        LSNode ptr = new LSNode();      
        ptr = Head;        
        while (ptr != null) {
            for (int i = 0; i < Length; i++) {
                System.out.println("第" + i + "個   大名 : " + ptr.name + "年齡 : " + ptr.age);
            }   
            ptr = ptr.Next;
        }
        System.out.println("\r\n");
    }
   public static void main(String[] argv) {
        //25 English names
        String[] NamePool = new String[]{"James","David","Christopher","George","Ronald","John","Richard",
                                        "Daniel","Kenneth","Anthony","Robert","Charles","Paul","Steven",
                                        "Kevin","Michael", "Joseph","Mark","Edward","Jason", "William",
                                        "Thomas", "Donald","Brian","Jeff"};	
        String[] CNamePool = new String[]{"曹淑珍","陳士萱","侯淑娟","李冠禾","張佳心","馮昀妤","盧嘉惠","洪淑萍",
                                        "朱卉一","楊茹俐","柳子晴","陳詠晴","蕭宜蓁","江品妤","黃子涵","趙品妍",
                                        "陳詩涵","張思妤","孫品睿","李宸睿"};
          
        int x = (int)(Math.random()*(25 - 0 + 1) + 0);
        int y = (int)(Math.random()*(61 - 20 + 1) + 20);
        LSNode Head01 = new LSNode(); 
        Head01 = null;
        LSNode Tail01 = new LSNode();   
        Tail01 = null;
        int Length01 = 0;
            
        LSNode ptr = new LSNode();      

        for (int i = 1; i <= 20; i++) {
            LSNode node = new LSNode(NamePool[x], y);
            node.LS_Add(node, Head01, Tail01, Length01); //加到 List 最後面
        }
        ptr.ShowLS(Head01);//印出List 所有的內容

        System.out.println("We are going to remove the last item ...");
        boolean flag = ptr.LS_Remove(Head01, Tail01, Length01); //刪除List最後面一項
        ptr.ShowLS(Head01);

        System.out.println("We are going to remove the first item ...");
        flag = ptr.LS_RemoveHead(Head01, Tail01, Length01); //刪除List最前面一項
        ptr.ShowLS(Head01);

        System.out.println("We are going to remove the item in between ...");
        flag = ptr.LS_RemoveAt(Head01, Tail01, Length01, 5); //刪除List某一項
        ptr.ShowLS(Head01);

        System.out.println("We are going to add one item in between ...");
        LSNode aNode = new LSNode("資管", 22);
        flag = ptr.LS_InsertAt(aNode, Head01, Tail01, Length01, 5); //加入某一項到List
        ptr.ShowLS(Head01);

        //reverse a linked list 
        System.out.println("We are going to reverse a linked list ...");
        ptr.LS_Reverse(Head01, Tail01);
        ptr.ShowLS(Head01);

        LSNode Head02 = new LSNode(); 
        Head02 = null;
        LSNode Tail02 = new LSNode(); 
        Tail02 = null;
        int Length02 = 0;

        for (int i = 1; i <= 20; i++) {
            LSNode node = new LSNode(CNamePool[x], y);
            node.LS_Add(node, Head02, Tail02, Length02); //加到 List 最後面
        }
        ptr.ShowLS(Head02); //印出List 所有的內容

        //merge the two linked list 
        Tail01.Next = Head02;
        Tail01 = Tail02;
        Length01 += Length02;
        ptr.ShowLS(Head01); //印出List 所有的內容 
    }
}
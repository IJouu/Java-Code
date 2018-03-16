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
    //����Linked List ������
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
    //�[�� Linked List �̫e��
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
    //�[��̫�
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
    //�R�h�Ĥ@��
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
    //�[�b location ��m����
    public static boolean LS_InsertAt(LSNode node, LSNode Head, LSNode Tail, int Length, int location) {
        int i = 0;       
        if ((location > Length) || (location < 0)) {//Index �O�q0 �}�l
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
        if ((location >= Length) || (location < 0)) { //Index �O�q0 �}�l        
            return false;
        } else {
            if (location == 0) {
                LS_RemoveHead(Head, Tail, Length);
                 return true;       
            } else {
                if (location == Length - 1) {
                    LS_Remove(Head, Tail, Length); //LS_Remove �N�O remove �̫�@��
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
                System.out.println("��" + i + "��   �j�W : " + ptr.name + "�~�� : " + ptr.age);
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
        String[] CNamePool = new String[]{"��Q��","���h��","�J�Q�S","���a��","�i�Τ�","������","�c�Ŵf","�x�Q��",
                                        "���c�@","�����W","�h�l��","������","���y�","���~��","���l�[","���~��",
                                        "���ֲ[","�i�䧱","�]�~��","���f��"};
          
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
            node.LS_Add(node, Head01, Tail01, Length01); //�[�� List �̫᭱
        }
        ptr.ShowLS(Head01);//�L�XList �Ҧ������e

        System.out.println("We are going to remove the last item ...");
        boolean flag = ptr.LS_Remove(Head01, Tail01, Length01); //�R��List�̫᭱�@��
        ptr.ShowLS(Head01);

        System.out.println("We are going to remove the first item ...");
        flag = ptr.LS_RemoveHead(Head01, Tail01, Length01); //�R��List�̫e���@��
        ptr.ShowLS(Head01);

        System.out.println("We are going to remove the item in between ...");
        flag = ptr.LS_RemoveAt(Head01, Tail01, Length01, 5); //�R��List�Y�@��
        ptr.ShowLS(Head01);

        System.out.println("We are going to add one item in between ...");
        LSNode aNode = new LSNode("���", 22);
        flag = ptr.LS_InsertAt(aNode, Head01, Tail01, Length01, 5); //�[�J�Y�@����List
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
            node.LS_Add(node, Head02, Tail02, Length02); //�[�� List �̫᭱
        }
        ptr.ShowLS(Head02); //�L�XList �Ҧ������e

        //merge the two linked list 
        Tail01.Next = Head02;
        Tail01 = Tail02;
        Length01 += Length02;
        ptr.ShowLS(Head01); //�L�XList �Ҧ������e 
    }
}
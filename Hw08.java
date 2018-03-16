import java.util.Scanner;

class LSNode {
    public String name;
    public int age;
    public LSNode next;
    public LSNode(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public LSNode() { // �w�]
        this.name = "";
        this.age = 0;
    }
}

class LinkList {
    LSNode head, tail;
    public LinkList() {
        
    }
    void addAt(LSNode n, int at) { // �[�J�Y�@����List
        LSNode location = head;
        for (int i = 2; i <= at - 1; i++) { // ���V�[�J���e�@��
            // �P�_location�O�_�ŭȡA�O �� ���X�A�_ �� �~��
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
        if (location == tail) { // �P�_location�O�_��tail�A�O �� tail���Vn
            tail = n;
        }
    }
    void addTail(LSNode n) { // �[��List�̫�@��
        if (tail != null) {
            tail.next = n;
        } else {
            head = n;
        }
        tail = n;
    }
    void rmHead() { // �R��List�̫e�@��
        if (head != null) { 
            head = head.next; // �Nhead���V�U�@���A�쥻��head�Y���s�b
        }
        
        if (head == null) { // �P�_head�O�_���ŭȡA�O �� tail�]�O�ŭ�
            tail = null;
        }
    }
    void rmAt(int at) { // �R���Y�@��
        LSNode location = head;
        for (int i = 0; i < at - 2; i++) { // ���V�R�����e�@��
            if (location == null) { 
                return;
            }
            location = location.next;
        }
        if (location == null) {
            return;
        }
        location.next = location.next.next; // �N�R�����e�@��next���V�R�����U�@��
        if (location.next == null) {
            tail = location;
        }
    }
    void rmTail() { // �R���̫�@��
        LSNode location = head;
        while(location.next != tail) { 
            location = location.next;
        }
        location.next = null;
        tail = location;
    }
    void reverse() { // ����
        if (head == null) {
            return;
        }
        LSNode f1 = head;
        LSNode f2 = head.next;
        LSNode f3;
        
        while(f2 != null) { // ��f2���O�ŭ� �� �~��
            f3 = f2.next;
            f2.next = f1;
            f1 = f2;
            f2 = f3;
        }
        head.next = null; // �����A�쥻��head�ܦ�tail�A�]��head.next���ŭ�
        tail = head; // �����A�쥻��tail�ܦ�head
        head = f1; // �̫�Af1���V���̫�@����head
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
            String format = "�� %2d����� �m�W : %12s  �~�� : %d\n";
            System.out.printf(format, i, location.name, location.age);
            location = location.next; // �L�����V�U�@��
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
        String[] cNamePool = {"��Q��","���h��","�J�Q�S","���a��","�i�Τ�","������","�c�Ŵf","�x�Q��","���c�@","�����W",
                            "�h�l��","������","���y�","���~��","���l�[","���~��","���ֲ[","�i�䧱","�]�~��","���f��"};

        LinkList ll = new LinkList();
        
        for (int i = 1; i <=20; i++) { // �[�JList
            ll.addTail(new LSNode(namePool[getRandIndex(namePool.length)], getRandAge()));
        }
        showList(ll);
        
        ll.rmTail(); // �R���̫�@��
        showList(ll);
        
        ll.rmHead(); // �R���̫e�@��
        showList(ll);
        
        ll.rmAt(5); // �R���Y�@��
        showList(ll);
        
        ll.addAt(new LSNode("���", 22), 5); // �[�J�Y�@��
        showList(ll);
        
        ll.reverse(); // ����
        showList(ll);
        
        LinkList ll2 = new LinkList(); // �[�JList
        for (int i = 1; i <= 20; i++) {
            ll2.addTail( new LSNode(cNamePool[getRandIndex(cNamePool.length)], getRandAge()));
        }
        showList(ll2);
        
        ll = merge(ll, ll2); // �X��
        ll2 = null;
        showList(ll);
    }
}
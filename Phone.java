import java.util.Scanner;

class PhoneNode {
    String name;
    String number;
    PhoneNode next;
    public PhoneNode(String name, String number) {
        this.name = name;
        this.number = number;
    }
}

class PhoneLL {
    PhoneNode head;
    public void add(String name, String number) {
        PhoneNode tmp = new PhoneNode(name, phone);
        tmp.next = head;
        head = tmp;
    }
    public void delete(String name) {
        if (head.name.equals(name)) {
            head = head.next;
            return;
        }
        PhoneNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.name.equals(name)) {
                break;
            }
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
    }
    public void search(String name) {
        PhoneNode tmp = head;
        while (tmp != null) {
            if (tmp.name.equals(name)) {
                break;
            }
            tmp = tmp.next;
        }
        return tmp.phone;
    }
    public void modify(String name, String phone) {
        PhoneNode tmp = head;
        while (tmp != null) {
            if (tmp.name.equals(name)) {
                break;
            }
            tmp = tmp.next;
        }
        tmp.phone = phone;
    }
}

public class Phone {

}

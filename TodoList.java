import java.util.Scanner;
public class TodoList {
    String listname;
    public TodoList (String listname) {
            this.listname = listname;
    }
    public void print() {
        System.out.println(listname + "«Ý¿ì¨Æ¶µ:"); 
    }
    public static void main(String[] argv) {
        List mylist = new List();
        Scanner input = new Scanner(System.in);
        int numlist = 0;
        TodoList[] allList = new TodoList[50];
        while ( input.hasNext() ) {
            String command = input.next();
            if ( command.equals("new") ) {
                allList[numlist++] = new TodoList(input.next());
            } else if (command.equals("add")) {
                mylist.add(input.next(), input.next());
            } else if (command.equals("remove")) {
                if 
                mylist.remove(input.next());
            } else if (command.equals("end")) {
                break;
            }
        }
        for (int i = 0; i < numlist; i++) {
            allList[i].print();
        }
    }
}

class listname {
    String title;
    String taskname;
    listname next;
}

class List {
    listname head, tail;
    int size;
    void add(String listname, String taskname) {
        listname tmp = new listname();
        tmp.title = listname;
        tmp.taskname = taskname;
        if (tail != null) {
            tail.next = tmp;
            tail = tmp;
        } else {
            head = tail = tmp;
        }
        size++;
    }
    listname get() {
        int num = 0;
        listname tmp = head;
        for (int i = 1; i < num; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }
}
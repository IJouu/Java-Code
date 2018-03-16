import java.util.Scanner;

class PersonNode {
	String name;
	String phone;
	PersonNode next;
	public PersonNode(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
}

class PersonLL {
	PersonNode head;
	public void add(String name, String phone) {
		PersonNode tmp = new PersonNode(name, phone);
		tmp.next = head;
		head = tmp;
	}
	public String search(String name) {
		PersonNode tmp = head;
		while (tmp != null) {
			if (tmp.name.equals(name))
				break;
			tmp = tmp.next;
		}
		return tmp.phone;
	}
	public void delete(String name) {
		if (head.name.equals(name)) {
			head = head.next;
			return;
		}
		PersonNode tmp = head;
		while (tmp.next != null) {
			if (tmp.next.name.equals(name)) {
				break;
			}
			tmp = tmp.next;
		}
		tmp.next = tmp.next.next;
	}
	public void modify(String name, String phone) {
        PersonNode tmp = head;
        while (tmp != null) {
            if (tmp.name.equals(name)) {
                break;
            }
            tmp = tmp.next;
        }
        tmp.phone = phone;
    }
	public void print() {
		PersonNode tmp = head;
		while (tmp != null) {
			System.out.println("Name : " + tmp.name + " Phone : " + tmp.phone);
			tmp = tmp.next;
		}
	}
	public boolean isEmpty() {
		return head == null;
	}
}

public class Contacts {
	static PersonLL[] group;
	public static int indexJudge(String name) throws Exception {
		if (name.charAt(0) >= 'A' && name.charAt(0) <= 'Z') {
			return name.charAt(0)-'A';
		} else if (name.charAt(0) >= 'a' && name.charAt(0) <= 'z') {
			return name.charAt(0) - 'a';
		} else {
			throw new Exception();
		}

	}
	public static void main(String[] argv) {
		Scanner input = new Scanner(System.in);
		group = new PersonLL[26];
		for (int i = 0; i < 26; i++) {
			group[i] = new PersonLL();
		}
		String command;
		int index;
		while (true) {
			command = input.next();
			try {
				if (command.equals("add")) {
					String name = input.next();
					String phone = input.next();
					index = indexJudge(name);
					group[index].add(name, phone);
				} else if (command.equals("search")) {
					String name = input.next();
					index = indexJudge(name);
					System.out.println(name + " " + group[index].search(name));
				} else if (command.equals("print")) {
					String word = input.next();
					index = indexJudge(word);
					group[index].print();
				} else if (command.equals("printAll")) {
					for (int i = 0; i < 26; i++) {
						if (!group[i].isEmpty()) {
							System.out.println((char)(i + 65) + " :");
							group[i].print();
						}
					}
				} else if (command.equals("delete")) {
					String name = input.next();
					index = indexJudge(name);
					group[index].delete(name);
				} else if (command.equals("break")) {
					System.out.println("End of program!");
					break;
				} else if (command.equals("modify")) {
					String name = input.next();
					String number = input.next();
					index = indexJudge(name);
					group[index].modify(name, number);
				}
			} catch (Exception err) {
				System.out.println("Wrong input of name!");
			}
		}
	}
}

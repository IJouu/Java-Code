class EmployeeDefault {
    String name;
    String sex;
    double salary;
    double overtimeMoney;
    double overtimeHours;
    public EmployeeDefault(String name, String sex, double salary) {
        this.name = name;
        this.sex = sex;
        this.salary = salary;
        overtimeMoney = 0;
        overtimeHours = 0;
    }
    public double getMonthMoney() {
        return salary + overtimeMoney;
    }
    public double setOvertimeMoney(double hours) {
        /* complete the code */
    }
}

class ChargeDefault extends EmployeeDefault {
    double lunchAllowance;
    double duties;
    public ChargeDefault(String name, String sex, double salary) {
        /* complete the code */
    }
    public double getMonthMoney() {
        /* complete the code */
    }
}

public class Company {
    public static void main(String[] argc) {
        /* hint: Car.java¡BShape2D.java¡BAnimal.java */
        /* complete the code */
    }
}

/*
*104213027
*�����X
*/
import java.util.Scanner;
public class ShapeHomework { // �D�n����{��
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // �]�ܼ�n����J���ϧέӼ�
        Shape2D[] x = new Shape2D[n]; // �]�@�Ӧs��ϧΪ��}�C
        for (int i = 0; i <= n - 1; i++) {
            String type, nickname; // type���ϧ����O�Anickname���ʺ�
            type = input.next(); // Ū�J�ϧ����O
            nickname = input.next(); // Ū�J�ʺ�
            if (type.equals("Circle")) { // �p�G�ϧ����O�OCircle
                double r = input.nextDouble(); // Ū�J�Ѽ�
                x[i] = new Circle(nickname, r); // ��ʺ٩M�ѼƦs��b�}�C��
            } else if (type.equals("Rectangle")) { // �p�G�ϧ����O�ORectangle
                double w = input.nextDouble(); // Ū�J�Ѽ�
                double h = input.nextDouble();
                x[i] = new Rectangle(nickname, w, h); // ��ʺ٩M�ѼƦs��b�}�C��
            } else if (type.equals("Square")) { // �p�G�ϧ����O�OSquare
                double l = input.nextDouble(); // Ū�J�Ѽ�
                x[i] = new Square(nickname, l); // ��ʺ٩M�ѼƦs��b�}�C��
            } else if (type.equals("Triangle")) { // �p�G�ϧ����O�OTriangle
                double b = input.nextDouble(); // Ū�J�Ѽ�
                double h = input.nextDouble();
                x[i] = new Triangle(nickname, b, h); // ��ʺ٩M�ѼƦs��b�}�C��
            } else if (type.equals("RegularOctagon")) { // �p�G�ϧ����O�ORegularOctagon
                double l = input.nextDouble(); // Ū�J�Ѽ�
                x[i] = new RegularOctagon(nickname, l); // ��ʺ٩M�ѼƦs��b�}�C��
            } else if (type.equals("Trapezoid")) { // �p�G�ϧ����O�OTrapezoid
                double u = input.nextDouble(); // Ū�J�Ѽ�
                double d = input.nextDouble();
                double h = input.nextDouble();
                x[i] = new Trapezoid(nickname, u, d, h); // ��ʺ٩M�ѼƦs��b�}�C��
            }
        }
        sort(x);
        for (int i = 0; i <= n - 1; i++) {
            System.out.println(x[i].getName() + " " + x[i].area()); // �L�XŪ�J���ʺ٩M���n
        }
        System.out.println(); // ����
        System.out.println(SumShape.sum(x)); // �L�X�`���n
    }
    public static void sort(Shape2D[] list) { // �Ͽ�X���ϧΫ��ӭ��n�j�p�ɾ��ƦC
        for (int i = 0; i <= list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if(list[j].area() > list[j + 1].area()) { // ����p���n���ϧίd�U�A��L���ϧζi��U�@�������
                    Shape2D tmp = list[j]; // tmp���Ȧs
                    list[j] = list[j + 1];
                    list[j + 1] = tmp;
                }
            }
        }
    }
}
public class ShapeHomework {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Shape2D[] x = new Shape2D[n];
        for (int i = 0; i <= n - 1; i++) {
            String type, nickname;
            type = input.next();
            nickname = input.next();
            if (type.equals("Circle")) {
                double r = input.nextDouble();
                x[i] = new Circle(nickname, r);
            } else if (type.equals("Rectangle")) {
                double w = input.nextDouble();
                double h = input.nextDouble();
                x[i] = new Rectangle(nickname, w, h);
            } else if (type.equals("Square")) {
                double l = input.nextDouble();
                x[i] = new Square(nickname, l);
            } else if (type.equals("Triangle")) {
                double b = input.nextDouble();
                double h = input.nextDouble();
                x[i] = new Triangle(nickname, b, h);
            } else if (type.equals("RegularOctagon")) {
                double l = input.nextDouble();
                x[i] = new RegularOctagon(nickname, l);
            } else if (type.equals("Trapezoid")) {
                double u = input.nextDouble();
                double d = input.nextDouble();
                double h = input.nextDouble();
                x[i] = new Trapezoid(nickname, u, d, h)
            }
        }
        sort(x);
        for (int i = 0; i <= n - 1; i++) {
            System.out.println(x[i].getName() + " " + x[i].area());
        }
        System.out.println();
        System.out.println(SumShape.sum(x));
    }
    public static void sort(Shape2D[] list) {
        
    }
}
package bg.tu_varna.sit.f24621905_task1;

public class task1 {
    public static void main(String[] args) {
        double a = 3;
        double b = 4;
        double c = 5;

        if (isTriangle(a, b, c)) {
            System.out.println("The three numbers can form a triangle.");

            if (isRightTriangle(a, b, c)) {
                System.out.println("The triangle is right-angled.");
            } else {
                System.out.println("The triangle is not right-angled.");
            }
        } else {
            System.out.println("The three numbers CANNOT form a triangle.");
        }
    }

    public static boolean isTriangle(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static boolean isRightTriangle(double a, double b, double c) {
        double a2 = a * a, b2 = b * b, c2 = c * c;
        return Math.abs(a2 + b2 - c2) < 0.0001 ||
                Math.abs(a2 + c2 - b2) < 0.0001 ||
                Math.abs(b2 + c2 - a2) < 0.0001;
    }
}

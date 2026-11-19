public class Task1 {

    public static int calculateArea(int length, int width) {
        return length * width;
    }

    public static double calculateArea(double length, double width) {
        return length * width;
    }

    public static void main(String[] args) {

        int area1 = calculateArea(10, 5);
        double area2 = calculateArea(10.5, 5.5);

        System.out.println("Integer Area: " + area1);
        System.out.println("Double Area: " + area2);
    }
}
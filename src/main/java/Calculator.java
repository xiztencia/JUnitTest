
public class Calculator {

    private int number;
    private int anotherNumber;

    public Calculator() {
    }

    public Calculator(int number) {
        this.number = number;
    }

    public Calculator(int number, int anotherNumber) {
        this.number = number;
        this.anotherNumber = anotherNumber;
    }

    public static int division(int a, int b) {
        return a / b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static boolean isSqrtPositive(int number) {
        return Math.sqrt(number) >= 0;
    }

    public int getNumber() {
        return number;
    }

    public int getAnotherNumber() {
        return anotherNumber;
    }

    public static int checkArrayLength(int i){
        int[] array  = new int [i];
        return array.length;
    }

    public static double areaOfRightAngleTriangleA(double c){
        c = areaOfRectangleFromTriangelA(6.0,1.0)/2;
        return c;
    }

    private static double areaOfRectangleFromTriangelA(double a, double b){
        double c = a*b;
        return c;
    }
}

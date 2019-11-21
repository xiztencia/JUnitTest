import java.util.ArrayList;
import java.util.List;

public class Calculator {

    //private int number;
    private String input;
    private int anotherNumber;

    public Calculator() {
    }

    public Calculator(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public double convertStringToDouble(String input){
        double number = 0.0;
        try {
            number =Double.parseDouble(input);
        } catch (NumberFormatException e) {
            inputError();
        }
        return number;
    }

    private void inputError() {
        System.out.println("Wrong format. Should be numbers!");
        throw new NumberFormatException();
    }

    private void division() {
        int a=  (int) convertStringToDouble(input);
        int b=  (int)convertStringToDouble(input);
        divide(a,b);
    }

    private void divisionError() {
        System.out.println("Error! Impossible to divide by 0!");
        throw new ArithmeticException();
    }

    private void multiply() {
        double number1=  convertStringToDouble(input);
        double number2=  convertStringToDouble(input);

        multiplication(number1,number2);
    }

    private void add() {
        double number1=  convertStringToDouble(input);
        double number2=  convertStringToDouble(input);
        addMethod(number1, number2);
    }

    public double addMethod(double a, double b){
        return a+b;
    }

    private void substraction() {
        int a=  (int) convertStringToDouble(input);
        int b=  (int)convertStringToDouble(input);
        substract(a,b);
    }

    public static boolean isSqrtPositive(int number) {
        return Math.sqrt(number) >= 0;
    }

    public double multiplication(double i, double i1) {
        return i*i1;
    }

    public double substract(int i, int i1) {
        return (double)i-i1;
    }

    public double divide(int i, int i1) {
        if (i1 == 0) {
            divisionError();
        }

        return (double)i/i1;
    }

    public List<String> menu(){
        List<String> list = new ArrayList<>();
        list.add("1. +");
        list.add("2. -");
        list.add("3. x");
        list.add("4. /");
        list.add("5. Exit");

        return list;
    }
    private int convertStringToInt(String str){
        int number = 0;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            convertError();
        }
        return number;
    }

    public void choices(String str) {
        int choice = convertStringToInt(str);
        List<String> list = menu();
        for (String s : list) {
            System.out.println(s);
        }
        switch (choice) {
            case 1:
                add();
            case 2:
                substraction();
            case 3:
                multiply();
            case 4:
                division();
            case 5:
                return;
            default:
                errorChoice();

        }
    }
        private void errorChoice() {
            System.out.println("Please number 1 to 5.");
            throw new NumberFormatException();
        }
        private void convertError(){
            System.out.println("It must be a number");
            throw new NumberFormatException();
        }

    /*
    public Calculator(int number, int anotherNumber) {
        this.number = number;
        this.anotherNumber = anotherNumber;
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

    public double areaOfRightAngleTriangleA(double a, double b){
        double c = areaOfRectangleFromTriangelA(a , b)/2;
        return c;
    }

    private static double areaOfRectangleFromTriangelA(double a, double b){
        double c = a*b;
        return c;
    }*/



    }

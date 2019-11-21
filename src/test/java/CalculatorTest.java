import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void initEach(){
        calculator = new Calculator();
        System.out.println("New Calculator is set up.");
    }
    @AfterEach
    void afterEach(){
        calculator = null;
        System.out.println(" clear up ");
    }

    @Test
    @DisplayName("Test of a default constructor")
    void constructorTest(){
        Calculator calculat = new Calculator("7");
        Assertions.assertEquals("7",calculat.getInput() );
    }

    @Test
    void additionTest () {
        Assertions.assertEquals(5.0, calculator.addMethod(3, 2));
    }
    @Test
    void convertStringToDoubleTest(){
        Assertions.assertEquals(9.0, calculator.convertStringToDouble("9"));
    }
    @Test
    void convertStringToDoubleExceptionTest(){
        Assertions.assertThrows(NumberFormatException.class, () ->
                calculator.convertStringToDouble("p"));
    }
    @Test
    @Disabled
    @DisplayName("Multiply Test is disabled on purpose to check how it works")
    void multiplyTest(){
        Assertions.assertEquals(6.0,calculator.multiplication(9,3));
    }
    @Test
    void substractionTest(){
        Assertions.assertEquals(6, calculator.substract(-10,-16));
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class DivisionTest{

        @Test
        @Order(1)
        void divisionTest(){
            Assertions.assertEquals(6,calculator.divide(6,1));
        }
       @Test
       @Order(2)
       void divisionExceptionTest(){
           Assertions.assertThrows(ArithmeticException.class, () ->
                   calculator.divide(6,0));
       }
    }

    @ParameterizedTest
    @ValueSource (ints = {5})
    void sizeTest(int number){
        List<String> list = calculator.menu();
        Assertions.assertEquals(number, list.size());
    }

    @DisplayName("Test of a private method via virtual method using 'invoke'")
    @Test
    void convertStringToIntTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Calculator.class.getDeclaredMethod("convertStringToInt", String.class);
        method.setAccessible(true);
        int number = (int) method.invoke(calculator, "3");
        Assertions.assertEquals(3, number);
    }

    @Test
    void errorChoiceTest(){
        Assertions.assertThrows(NumberFormatException.class, ()->
                calculator.choices("99"));
    }

    @Test
    @Disabled
    void convertErrortest() throws NoSuchMethodException {
        Method method = Calculator.class.getDeclaredMethod("convertStringToInt", String.class);
        method.setAccessible(true);
        Assertions.assertThrows(NumberFormatException.class, ()->
                method.invoke(calculator, "p"));
    }


    /*@Test
    @DisplayName("Test of triangel area")
    public void triangelAreaTest(){
       Assertions.assertEquals(4.0,calculator.areaOfRightAngleTriangleA(4.0));
    }

    @Test
    @Order(7)
    @DisplayName("Check-array-length Test")
    public void checkArrayTest(){
         Assertions.assertEquals(6, Calculator.checkArrayLength(6));
    }

    @DisplayName("Square-valid-value Test")
    @ParameterizedTest
    @Order(6)
    @ValueSource(ints = {0, 4, 100, -3, 15})
    void isSqrt_ShouldReturnTrueForPositiveNumbers(int number) {
        if (number < 0) {
            Assertions.assertFalse(Calculator.isSqrtPositive(number));
        } else
        Assertions.assertTrue(Calculator.isSqrtPositive(number));
    }

    @DisplayName("Division Test")
    @Test
    @Order(2)
    void testOfDivisionFunction(TestInfo testInfo){
        Assertions.assertEquals(5,Calculator.division(5, 1));
    }

    @DisplayName("Division-by-zero Test")
    @Test
    @Order(3)
    public void arithmeticExceptionWhileDivideByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> Calculator.division(5,0));
    }

    @DisplayName("Add Test")
    @Test
    @Order(4)
    void testOfAddFunction(TestInfo testInfo){
        Assertions.assertEquals(5 ,Calculator.add(5, 0));
    }

    @DisplayName("Multiply Test")
    @RepeatedTest(3)
    @Order(5)
    void testOfMultiplyFunction(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println("Running test -> " + repetitionInfo.getCurrentRepetition());
        Assertions.assertEquals(6*repetitionInfo.getCurrentRepetition(),Calculator.multiply(repetitionInfo.getCurrentRepetition(),6));
    }

    @BeforeEach
    @Order(1)
    public void initEach(){
    calculator = new Calculator();
    System.out.println("New Calculator is set up.");
    }

    //@AfterEach
    //public void cleanUpEach(){
     //   System.out.println("Skickar printraden ändå....även om jag inte skulle");
    //}*/
}
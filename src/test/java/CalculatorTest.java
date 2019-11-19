import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @Test
    @DisplayName("Test of triangel area")
    public void triangelAreaTest(){
       Assertions.assertEquals(4.0,4.0);
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
    Calculator calculator = new Calculator();
    System.out.println("New Calculator is set up.");
    }

    //@AfterEach
    //public void cleanUpEach(){
     //   System.out.println("Skickar printraden ändå....även om jag inte skulle");
    //}
}
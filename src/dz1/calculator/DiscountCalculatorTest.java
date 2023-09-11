package dz1.calculator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/* Этот тестовый класс используется для расчета суммы счета в зависимости от различных скидочных карт.
*/
public class DiscountCalculatorTest {
    private DiscountCalculator calculator = null;
    @BeforeEach
    void init(){

        List<DiscountSlab> slabs = List.of(
                new DiscountSlab(CustomerType.REGULAR, 10000, 0.2),
                new DiscountSlab(CustomerType.REGULAR, 5000, 0.1)
        );
        calculator = new DiscountCalculator(slabs);
    }

    @Test
    @DisplayName("Calculate Billing Amount based on discount slab")
    void testCalculateBillingAmount() {
        assertAll(
                () -> assertEquals(0, calculator.calculateBillingAmount(-1)),
                () -> assertEquals(0, calculator.calculateBillingAmount(0)),
                () -> assertEquals(1000, calculator.calculateBillingAmount(1000)),
                () -> assertEquals(5000, calculator.calculateBillingAmount(5000)),
                () -> assertEquals(9500, calculator.calculateBillingAmount(10000)),
                () -> assertEquals(13500, calculator.calculateBillingAmount(15000)),
                () -> assertEquals(17500, calculator.calculateBillingAmount(20000))

        );
    }

    @AfterEach
    void cleanup(){
        calculator=null;
    }
}

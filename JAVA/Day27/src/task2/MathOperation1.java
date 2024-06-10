package task2;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathOperation1 {

	private MathOperation1 mathOperations;

    @BeforeEach
    public void setUp() {
        mathOperations = new MathOperation1();
    }

    @Test
    public void testAdd() {
        assertEquals(5, mathOperations.add(2, 3));
        assertEquals(-1, mathOperations.add(2, -3));
        assertEquals(0, mathOperations.add(0, 0));
    }

    private Integer add(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
    public void testSubtract() {
        assertEquals(1, mathOperations.subtract(3, 2));
        assertEquals(5, mathOperations.subtract(2, -3));
        assertEquals(0, mathOperations.subtract(0, 0));
    }

    private Integer subtract(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
    public void testMultiply() {
        assertEquals(6, mathOperations.multiply(2, 3));
        assertEquals(-6, mathOperations.multiply(2, -3));
        assertEquals(0, mathOperations.multiply(2, 0));
    }

    private Integer multiply(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
    public void testDivide() {
        assertEquals(2.0, mathOperations.divide(6, 3), 0.001);
        assertEquals(-2.0, mathOperations.divide(6, -3), 0.001);
        assertThrows(IllegalArgumentException.class, () -> {
            mathOperations.divide(1, 0);
        });
    }

	private double divide(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}
}
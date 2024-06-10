package task1;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathOperations {

    private static MathOperations mathOperations;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        // Code executed once before any of the test methods in this class
        System.out.println("Setting up before class");
        mathOperations = new MathOperations();
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        // Code executed once after all the test methods in this class
        System.out.println("Tearing down after class");
    }

    @BeforeEach
    public void setUp() throws Exception {
        // Code executed before each test method
        System.out.println("Setting up before test");
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Code executed after each test method
        System.out.println("Tearing down after test");
    }

    @Test
    public void testAdd() {
        assertEquals(5, mathOperations.add(2, 3));
        assertEquals(-1, mathOperations.add(2, -3));
        assertEquals(0, mathOperations.add(0, 0));
    }

    Integer add(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
    public void testSubtract() {
        assertEquals(1, mathOperations.subtract(3, 2));
        assertEquals(5, mathOperations.subtract(2, -3));
        assertEquals(0, mathOperations.subtract(0, 0));
    }

    Integer subtract(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
    public void testMultiply() {
        assertEquals(6, mathOperations.multiply(2, 3));
        assertEquals(-6, mathOperations.multiply(2, -3));
        assertEquals(0, mathOperations.multiply(2, 0));
    }

    Integer multiply(int i, int j) {
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

	double divide(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}
}
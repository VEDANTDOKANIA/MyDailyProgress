import JunitTester.StringHelper;
import org.junit.After;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {
    StringHelper stringHelper = new StringHelper();
    @BeforeEach
    public void setup(){
        System.out.println("Before");
    }

    @Test
    @Timeout(value = 1000,unit = MILLISECONDS)
    void truncateAInFirst2Positions() {
        assertTimeout(1000, MILLISECONDS);
        for(;;){
            assertTimeout(1000, MILLISECONDS);
        }



    }

    private void assertTimeout(int i, TimeUnit milliseconds) {
    }

    @Test
    void test2(){

        assertEquals("CD", stringHelper.truncateAInFirst2Positions("AACD"));

    }

   @Test
    void areFirstAndLastTwoCharactersTheSame() {
       assertTrue(stringHelper.areFirstAndLastTwoCharactersTheSame("AABBAA"));

    }

    @Test
    public void ArrayComparison(){
        int[] numbers ={10,45,9,76};
        int[] expected ={9,10,45,76};
        Arrays.sort(numbers);
        assertArrayEquals(expected,numbers);
    }
    @After
   public void tearDown(){
        System.out.println("After Test");
    }

}
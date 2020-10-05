package ConsoleAndUnitTestingPractice.src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



public class BadFracTest {
    
    @Test
    public void testIsRuduced() {
        assertTrue( new BadFrac( 1, 2 ).isReduced() );
        assertTrue( new BadFrac( 5, 1 ).isReduced() );
        assertTrue( new BadFrac( 2, 5 ).isReduced() );
        assertTrue( new BadFrac( 0, 1 ).isReduced() );
        assertFalse( new BadFrac( 2, 4 ).isReduced() );
        assertFalse( new BadFrac( 6, 2 ).isReduced() );
        assertFalse( new BadFrac( 0, 2 ).isReduced() );
    }


    @Test
    public void testAdd() {
        System.out.println( new BadFrac( 2, 5 ).add( new BadFrac( 3, 5 ) ) );
        assertTrue( new BadFrac( 1, 2 ).add( new BadFrac( 2, 3 ) ).equals( new BadFrac( 7, 6 ) ) );
        assertTrue( new BadFrac( 5, 1 ).add( new BadFrac( 5, 2 ) ).equals( new BadFrac( 15, 2 ) ) );
        assertTrue( new BadFrac( 2, 5 ).add( new BadFrac( 3, 5 ) ).equals( new BadFrac( 1, 1 ) ) );
        assertTrue( new BadFrac( 0, 1 ).add( new BadFrac( 1, 1 ) ).equals( new BadFrac( 1, 1 ) ) );
        assertTrue( new BadFrac( 2, 4 ).add( new BadFrac( 2, 4 ) ).equals( new BadFrac( 1, 1 ) ) );
        assertTrue( new BadFrac( 1, 2 ).add( new BadFrac( 1, 4 ) ).equals( new BadFrac( 3, 4 ) ) );
        assertTrue( new BadFrac( 0, 2 ).add( new BadFrac( 1, 2 ) ).equals( new BadFrac( 1, 2 ) ) );
    }
}

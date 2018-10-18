/* functions that perform similar operations should be grouped
 * this makes for reduced context switching when reading through a source file 
 */

public class Assert {

    static public void assertTrue(String message, boolean condition) {
        if (!condition)
            fail(message);
    }

    static public void assertTrue(boolean condition) {
        assertTrue(null, condition);
    }

    static public void assertFalse(String message, boolean condition) {
        assertTrue(message, !condition)
    }

    static public void assertFalse(boolean condition) {
        assertFalse(null, condition);
    }
}


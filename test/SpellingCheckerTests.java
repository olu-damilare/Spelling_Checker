import com.spellingCheck.SpellingCheck;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpellingCheckerTests {
    SpellingCheck spellingCheck;
    @BeforeEach
    void setUp(){
        spellingCheck = new SpellingCheck();
    }

    @AfterEach
    void tearDown(){
        spellingCheck = null;
    }

    @Test
    void testThatWordIsSpelledCorrectly(){
        assertEquals("Word is spelled correctly", spellingCheck.check("large"));
    }

    @Test
    void testThatWordIsNotSpelledCorrectly(){
        assertEquals("Word is not spelled correctly", spellingCheck.check("suorce"));
    }

    @Test
    void testThatTransposedLettersInWordsCanBeCorrected(){
        assertEquals("Did you mean source?", spellingCheck.checkTransposed("suorce"));
        assertEquals("Did you mean large?", spellingCheck.checkTransposed("lrage"));
    }

    @Test
    void testThatAccidentallyDoubleTypedCharactersCanBeCorrected(){
        assertEquals("Did you mean source?", spellingCheck.checkDoubleTyped("sourrce"));
    }
}

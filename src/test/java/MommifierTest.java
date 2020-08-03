import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class MommifierTest {
    @Test
    void should_return_original_string_when_insert_between_continuous_vowels_given_string_has_the_number_of_vowels_less_then_30_percentage(){
        Mommifier mommifier = new Mommifier();
        //given
        String[] sourse = {"afbcd","abcde"};
        //when
        String[] original_string = mommifier.insertBetweenContinuesVowels(sourse);
        //then
        assertArrayEquals(sourse,original_string);
    }
    @Test
    void should_return_inserted_string_when_insert_between_continuous_vowels_given_string_has_the_number_of_vowels_more_then_30_percentage(){
        Mommifier mommifier = new Mommifier();
        //given
        String[] sourse = {"aabcede","abcde"};
        //when
        String[] expected = {"amommyabcede","abcde"};
        String[] inserted_string = mommifier.insertBetweenContinuesVowels(sourse);
        //then
        assertArrayEquals(expected,inserted_string);
        //assertEquals(expected,result);
    }

    @Test
    void should_return_original_string_when_insert_between_continuous_vowels_given_string_has_the_number_of_vowels_more_then_30_percentage_but_not_continue(){
        Mommifier mommifier = new Mommifier();
        //given
        String[] sourse = {"afecid","afAbicudefI"};
        //when
        String[] original_string = mommifier.insertBetweenContinuesVowels(sourse);
        //then
        assertArrayEquals(sourse,original_string);
    }
}


package exercises;

import static org.junit.Assert.assertEquals;

import com.sun.source.tree.NewArrayTree;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

public class Exercises {

    /**
     * Create a string that consists of the first letters of each
     * word in the input list.
     */
    @Test
    public void ex01AccumulateFirstLetters() {
        List<String> input = Arrays.asList(
                "alfa", "bravo", "charlie", "delta", "echo", "foxtrot");
        StringBuilder sb = new StringBuilder();
        input.forEach((a) -> {
            sb.append(a.charAt(0));
        });
        String result = sb.toString(); //
        assertEquals("abcdef", result);

    }

    /**
     * Remove the words that have odd lengths from the list.
     */
    @Test
    public void ex02_removeOddLengthWords() {
        List<String> list = new ArrayList<>(Arrays.asList(
                "alfa", "bravo", "charlie", "delta", "echo", "foxtrot"));

        //list.removeIf(s -> (s.length() % 2 != 0));
        list.removeIf((s) -> ((s.length() & 1) == 1));
        assertEquals("[alfa, echo]", list.toString());
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Collection.removeIf().
    // </editor-fold>


    /**
     * Replace every word in the list with its upper case equivalent.
     */
    @Test
    public void ex03_upcaseAllWords() {
        List<String> list = new ArrayList<>(Arrays.asList(
                "alfa", "bravo", "charlie", "delta", "echo", "foxtrot"));

        //TODO code to modify list
        list.replaceAll(String::toUpperCase);
//        list.replaceAll(s -> s.toUpperCase());


        assertEquals("[ALFA, BRAVO, CHARLIE, DELTA, ECHO, FOXTROT]", list.toString());
    }

    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use List.replaceAll().
    // </editor-fold>


    /**
     * Convert every key-value pair of a map into a string and append them all
     * into a single string, in iteration order.
     */
    @Test
    public void ex04_stringifyMap() {
        Map<String, Integer> input = new TreeMap<>();
        input.put("c", 3);
        input.put("b", 2);
        input.put("a", 1);
        StringBuilder sb = new StringBuilder();
        /*input.forEach((x,y)->{
            sb.append(x);
            sb.append(y);
        });*/
        input.forEach((k, v) -> sb.append(String.format("%s%s", k, v)));

        String result = sb.toString(); // TODO

        assertEquals("a1b2c3", result);
    }

    /**
     * Given a list of words, create a map whose keys are the first letters of
     * each words, and whose values are the sum of the lengths of those words.
     */
    @Test
    public void ex05_mapOfStringLengths() {
        List<String> list = Arrays.asList(
                "aardvark", "bison", "capybara",
                "alligator", "bushbaby", "chimpanzee",
                "avocet", "bustard", "capuchin");
        Map<String, Integer> result = new TreeMap<>();

        list.forEach(s -> result.merge(s.substring(0, 1), s.length(), Integer::sum));

        //TODO code to populate result

        assertEquals("{a=23, b=20, c=26}", result.toString());
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.merge() within Iterable.forEach().
    // </editor-fold>

}

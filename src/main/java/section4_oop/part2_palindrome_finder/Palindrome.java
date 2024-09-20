package section4_oop.part2_palindrome_finder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Palindrome {

    HashMap<Character, Character> conversion = new HashMap<>() {
        {
            put('A', 'T');
            put('T', 'A');
            put('C', 'G');
            put('G', 'C');
        }
    };
    public static void main(String[] args) {
        Palindrome app = new Palindrome();
        app.start(args);
    }
    public void start(String[] args){
        char[] letters = args[0].toUpperCase().toCharArray();
        Stack<Character> seqRight= new Stack<>();
        Stack<Character> seqLeft= new Stack<>();
        List<Character> rateRight = new ArrayList<>();
        List<Character> rateLeft = new ArrayList<>();

        for (int i = 0; i < letters.length /2; i++) {
            if(isCounterpart(letters[i],letters[letters.length - i - 1])){
                seqRight.push(letters[i]);
                seqLeft.push(letters[letters.length - i - 1]);
                rateRight.add('<');
            }else {

            }
            rateLeft.add('>');

        }
    }

    public boolean isCounterpart(char left, char right) {
        return conversion.get(left) == right;
    }
}

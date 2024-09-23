package section4_oop.part2_palindrome_finder;

import java.util.*;

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
        List<Character> seqLeft= new ArrayList<>();
        Stack<Character> rateRight = new Stack<>();
        List<Character> rateLeft = new ArrayList<>();

        for (int i = 0; i < (letters.length + 1) /2; i++) {
            if(isCounterpart(letters[i],letters[letters.length - i - 1])){
                seqRight.push(letters[letters.length - i - 1]);
                rateRight.push('<');
            }else {
            seqRight.push(Character.toLowerCase(letters[letters.length - i - 1]));
            rateRight.push('*');
            }
            seqLeft.add(letters[i]);
            rateLeft.add('>');
        }
        String seq =listToString(seqLeft) + stackToString(seqRight);
        String quality = listToString(rateLeft) + stackToString(rateRight);

        System.out.println(seq);
        System.out.println(quality);
    }
    private String stackToString(Stack<Character> letters){
        StringBuilder sb = new StringBuilder();
        while (!letters.empty()){
            sb.append(letters.pop());
        }
        return sb.toString();
    }

    private String listToString(List<Character> letters){
        StringBuilder sb = new StringBuilder();
        for (Character c : letters){
            sb.append(c);
        }
        return sb.toString();
    }
    private boolean isCounterpart(char left, char right) {
        return conversion.get(left) == right;
    }
}

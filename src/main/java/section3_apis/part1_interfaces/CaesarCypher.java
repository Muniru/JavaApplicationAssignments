package section3_apis.part1_interfaces;

public class CaesarCypher implements EncryptionEngine {

    private boolean IsLetter(char myChar){
        return (myChar >= 'A' && myChar <= 'Z') || (myChar >= 'a' && myChar <= 'z');
    }

    private char ChangeCipher(char myChar, int amount){
        if(!IsLetter(myChar))
          return myChar;

        amount %= 26;
        char lowest = Character.isLowerCase(myChar)? 'a' : 'A';
        int cipher =  myChar - lowest + amount;

        if (cipher < 0)
            cipher += 26;
        else if (cipher >= 26)
            cipher -= 26;

        return (char) (cipher + lowest);
    }

    @Override
    public String encrypt(String message) {
        //YOUR CODE HERE (and remove the throw statement)
        char[] letters = message.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            letters[i] = ChangeCipher(letters[i], -3);
        }
        return String.valueOf(letters);
    }

    @Override
    public String decrypt(String encryptedMessage) {
        //YOUR CODE HERE (and remove the throw statement)
        char[] letters = encryptedMessage.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            letters[i] = ChangeCipher(letters[i], +3);
        }
        return String.valueOf(letters);
    }
}

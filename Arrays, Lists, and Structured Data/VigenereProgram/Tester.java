
/**
 * Write a description of Tester here.
 * 
 * @author Joan Perez Lozano
 */
import edu.duke.*;

public class Tester {
    
    public void testCaesarCipher() {
        // Testing with file
        FileResource message = new FileResource("data/titus-small.txt");
        String messageStr = message.asString();
        
        int key = 6;
        CaesarCipher cc = new CaesarCipher(key);
        String encrypted = cc.encrypt(messageStr);
        String decrypted = cc.decrypt(encrypted);
        
        System.out.println("Key used was: " + key);
        System.out.println("Message encrypted: \n" + encrypted);
        System.out.println("Message decrypted: \n" + decrypted);
        
        System.out.println("**********************");
        //Testing with letter
        char letter = 'h';
        char letter2 = 'a';
        key = 9;
        CaesarCipher cc2 = new CaesarCipher(key);
        char encryptedLetter = cc2.encryptLetter(letter);
        char decryptedLetter = cc2.decryptLetter(letter2);
        
        System.out.println("Key used was: " + key);
        System.out.println("Letter encrypted: \n" + encryptedLetter);
        System.out.println("Letter decrypted: \n" + decryptedLetter);
    }
    
    public void testCaesarCracker() {
        // Testing file in english. Therefore, without parameter in constructor 
        // method that uses the default most common word 'e' since this is the 
        // most common word in english language.
        String filename = "titus-small_key5.txt";
        System.out.println("File used: " + filename);
        FileResource message = new FileResource("data/" + filename);
        String messageStr = message.asString();

        CaesarCracker ccrack = new CaesarCracker();
        int key = ccrack.getKey(messageStr);
        
        System.out.println("The key retrieved is: " + key);
        String decrypted = ccrack.decrypt(messageStr);
        System.out.println("The decrypted message is: \n" + decrypted);
        
        System.out.println("**********************");
        // Testing file in portuguese. Therefore, with parameter in constructor 
        // method 'a' since this is the most common word in portuguese language.
        filename = "oslusiadas_key17.txt";
        System.out.println("File used: " + filename);
        message = new FileResource("data/" + filename);
        messageStr = message.asString();
        
        ccrack = new CaesarCracker('a');
        key = ccrack.getKey(messageStr);
        System.out.println("The key retrieved is: " + key);
        decrypted = ccrack.decrypt(messageStr);
        System.out.println("The decrypted message is: \n" + decrypted);
    }
    
    public void testVigenereCipher() {
        // Testing with file
        String filename = "titus-small.txt";
        System.out.println("File used: " + filename);
        FileResource message = new FileResource("data/" + filename);
        String messageStr = message.asString();
        
        int[] keys = {20, 14, 12, 4};
        VigenereCipher vc = new VigenereCipher(keys);
        String encrypted = vc.encrypt(messageStr);
        String decrypted = vc.decrypt(encrypted);
        System.out.println("Encrypted Message: \n" + encrypted);
        System.out.println("Decrypted Message: \n" + decrypted);
        
        System.out.println("**********************");
        // Testing with word
        
        VigenereCipher vc2 = new VigenereCipher(keys);
        String word = "rome";
        encrypted = vc2.encrypt(word);
        decrypted = vc2.decrypt(encrypted);
        
        System.out.println("Encrypted word: " + encrypted);
        System.out.println("Decrypted word: " + decrypted);
        
        System.out.println("**********************");
        //Testing sliceString
        VigenereCipher vc3 = new VigenereCipher(keys);
        String stringLine = "abcdefghijklm";
        String slice = vc3.sliceString(stringLine, 0, 3);
        System.out.println("Complete String: " + stringLine);
        System.out.println("Returning Slice: " + slice);
    }
    
}

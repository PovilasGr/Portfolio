
import java.util.HashMap;


public class HashCodeGenerator {
    HashMap<Character, Integer> alphabet = new HashMap();
    
    public HashCodeGenerator() {
        alphabet.put('a', 1); alphabet.put('b', 2);   alphabet.put('c', 3); 
        alphabet.put('d', 4); alphabet.put('e', 5);   alphabet.put('f', 6); 
        alphabet.put('g', 7); alphabet.put('h', 8);   alphabet.put('i', 9); 
        alphabet.put('j', 10); alphabet.put('k', 11); alphabet.put('l', 12);
        alphabet.put('m', 13); alphabet.put('n', 14); alphabet.put('o', 15); 
        alphabet.put('p', 16); alphabet.put('q', 17); alphabet.put('r', 18); 
        alphabet.put('s', 19); alphabet.put('t', 20); alphabet.put('u', 21);
        alphabet.put('v', 22); alphabet.put('w', 23); alphabet.put('x', 24); 
        alphabet.put('y', 25); alphabet.put('z', 26);
    }
    
    // https://stackoverflow.com/questions/8894258/fastest-way-to-iterate-over-all-the-chars-in-a-string?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
    
    public int generate1(String str) {
        int h = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if ( alphabet.containsKey(str.charAt(i)) ) {
                h += alphabet.get(str.charAt(i));
            }
        }
        return h; 
    }
    
    public int generate2(String str) {
        return generate1(str) % 11;
    }
    
    public int generate3(String str, int arryLength) {
        int h = 0;
        for (int i = 0; i < str.length(); i++) {
            if ( alphabet.containsKey(str.charAt(i)) ) {
                h = h * 31 + alphabet.get(str.charAt(i));
            }
        }
        return h % arryLength;
    }
}

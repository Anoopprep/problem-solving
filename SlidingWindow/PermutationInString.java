import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Exactly same as Find all anagrams in a string
 * permutation is ntg but anagram
 * In Angarams problem, you find indices of all anagrams
 * Here you just quit as soon as you get an anagram.
 */

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int windowSize = s1.length();
        int[] freq = new int[26];
        List<Integer> res = new ArrayList<Integer>();

        for(int i = 0; i < windowSize; i++) freq[s1.charAt(i) - 97]++;
        String hashSignature = Arrays.toString(freq);

        Arrays.fill(freq, 0);
        for(int j = 0; j < s1.length(); j++) freq[s2.charAt(j) - 97]++;

        if (Arrays.toString(freq).equals(hashSignature)) return true;

        for(int i = 1; i < s2.length() - windowSize + 1; i++) {
            freq[s2.charAt(i - 1) - 97]--;
            freq[s2.charAt(i + windowSize - 1) - 97]++;
            String windowSignature = Arrays.toString(freq);

            if(windowSignature.equals(hashSignature)) return true;
        }
        return false;
    }
}

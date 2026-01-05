/**
 * 205. Isomorphic Strings
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 * Time Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sToT = new HashMap<Character, Character>();
        Map<Character, Character> tToS = new HashMap<Character, Character>();

        for(int i = 0; i < s.length(); i++) {
            if(sToT.containsKey(s.charAt(i))) {
                Character c = sToT.get(s.charAt(i));
                if(c != t.charAt(i)) return false;
            } else sToT.put(s.charAt(i), t.charAt(i));

            if(tToS.containsKey(t.charAt(i))) {
                Character c = tToS.get(t.charAt(i));
                if(c != s.charAt(i)) return false;
            } else tToS.put(t.charAt(i), s.charAt(i));
        }

        return true;
    }

    // ContainsValue method approach
    // ContainsValue is o(n)
    public boolean isIsomorphicOneMap(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) != t.charAt(i)) 
                    return false;
            } 
            else {
                if(map.containsValue(t.charAt(i))) return false;
                else map.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }
}

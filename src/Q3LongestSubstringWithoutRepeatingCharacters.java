import java.util.HashSet;
import java.util.Set;

/**
 * Created by littlejie on 2017/5/18.
 */
public class Q3LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int length = s.length();
        int i = 0, j = 0;
        int result = 0;
        while (i < length && j < length) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            }
        }
        return result;
    }

//    public static int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0, i = 0, j = 0;
//        while (i < n && j < n) {
//            // try to extend the range [i, j]
//            if (!set.contains(s.charAt(j))) {
//                set.add(s.charAt(j++));
//                ans = Math.max(ans, j - i);
//            } else {
//                set.remove(s.charAt(i++));
//            }
//        }
//        return ans;
//    }

}

/**
 * Created by littlejie on 2017/6/7.
 */
public class Q14LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs1 = {"abc","ab","a"};
        System.out.println(longestCommonPrefix(strs1));

        String[] strs2 = {"ab","ab","abc"};
        System.out.println(longestCommonPrefix(strs2));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < prefix.length() && j < strs[i].length()
                    && prefix.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}

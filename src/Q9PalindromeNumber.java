/**
 * Created by littlejie on 2017/6/1.
 */
public class Q9PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(1001));
        System.out.println(isPalindrome(123454321));
    }

    public static boolean isPalindrome(int x) {
        //负数不是回文数
        if (x < 0) {
            return false;
        }

        //求出x的位数
        int max = 1;
        while ((x / max) >= 10) {
            max *= 10;
        }
        System.out.println("max = " + max);

        //最高位与最低位是否相等
        while (x > 0) {
            if (x / max != x % 10) {
                System.out.println("false");
                return false;
            }
            //123454321
            //x % max = 23454321
            //x / 10 = 2345432
            x = x % max;
            x = x / 10;
            max /= 100;
            System.out.println("x = " + x + "; length = " + max);
        }

        return true;
    }
}

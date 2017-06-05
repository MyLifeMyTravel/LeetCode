/**
 * Created by littlejie on 2017/6/5.
 */
public class Q7ReserveInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-1));
        System.out.println(reverse(-123));
        System.out.println(reverse(100));
        System.out.println(reverse(1000000003));
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        //此处 result 得使用 long 类型
        long result = 0;
        int abs = Math.abs(x);
        while (abs > 0) {
            result *= 10;
            result += abs % 10;
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
            abs /= 10;
        }
        return (int) (x < 0 ? -result : result);
    }
}

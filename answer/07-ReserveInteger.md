# 07-ReserveInteger

该题是让我们求一个数字的反转，比如：-123 的反转为 -321，100 的反转为 1，同时，需要考虑到反转后的数字出现溢出的情况。
 
```
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
```
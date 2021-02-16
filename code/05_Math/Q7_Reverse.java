package Math;


public class Q7_Reverse {
    public int reverse(int x) {

        int res = 0;

        while (x != 0) {
            int pop = x % 10; //取末1位
            x /= 10; // 删末1位

            //如果 res = pop * 10 + pop导致溢出，
            //那么一定有res >= intmax / 10
            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            } else if (res < Integer.MIN_VALUE / 10) {
                return 0;
            }

            // 往前一位，并把末1位加上刚刚取出来的
            // 有可能加来之后会导致溢出，所在加之前先判断
            res = res * 10 + pop;
        }
        return res;
    }

}
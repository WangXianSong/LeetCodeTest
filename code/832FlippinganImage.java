
/**
 * Created by SongSong on 2019/11/3 0003
 * Email:374155400@qq.com
 * <p>
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * <p>
 * //1.水平翻转，左右对换
 * //2.数值反转，0变1 1变0
 */


public class FlippinganImage832 {

    public static void main(String[] args) {
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {1, 1, 1}};
        flipAndInvertImage(A);
    }


    /**
     * 暴力解法
     *
     * @param A
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        int c = A[0].length; //计算列数
        //每一行的遍历
        for (int[] row : A) {
            // 列遍历，只遍历到一半即可
            for (int i = 0; i < (c + 1) / 2; ++i) {
                //一边翻转一边翻转
                //位异或运算（^）:两个数转为二进制，然后从高位开始比较，如果相同则为0，不相同则为1。
                int tmp = row[i] ^ 1;//前一个
                row[i] = row[c - 1 - i] ^ 1;//后一个
                row[c - 1 - i] = tmp;
            }
        }
        return A;
    }

}



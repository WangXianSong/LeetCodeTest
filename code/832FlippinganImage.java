
/**
 * Created by SongSong on 2019/11/3 0003
 * Email:374155400@qq.com
 * <p>
 * ����: [[1,1,0],[1,0,1],[0,0,0]]
 * ���: [[1,0,0],[0,1,0],[1,1,1]]
 * <p>
 * //1.ˮƽ��ת�����ҶԻ�
 * //2.��ֵ��ת��0��1 1��0
 */


public class FlippinganImage832 {

    public static void main(String[] args) {
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {1, 1, 1}};
        flipAndInvertImage(A);
    }


    /**
     * �����ⷨ
     *
     * @param A
     * @return
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        int c = A[0].length; //��������
        //ÿһ�еı���
        for (int[] row : A) {
            // �б�����ֻ������һ�뼴��
            for (int i = 0; i < (c + 1) / 2; ++i) {
                //һ�߷�תһ�߷�ת
                //λ������㣨^��:������תΪ�����ƣ�Ȼ��Ӹ�λ��ʼ�Ƚϣ������ͬ��Ϊ0������ͬ��Ϊ1��
                int tmp = row[i] ^ 1;//ǰһ��
                row[i] = row[c - 1 - i] ^ 1;//��һ��
                row[c - 1 - i] = tmp;
            }
        }
        return A;
    }

}



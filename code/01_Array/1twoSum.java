import java.util.HashMap;

public class Solution1 {
    public static void main(String[] args) {

        //int[] nums = new int[]{2, 7, 11, 15};
        int[] nums = new int[]{-1, -2, -3, -4, -5};
        int target = -8;

        int[] result = Solution1.twoSum3(nums, target);

        System.out.println(result[0] + "," + result[1]);
    }

    /**
     * 所谓的暴力法，外层循环计算当前元素与target之间的差值，内层循环寻找该差值，若有则返回下标。
     * 时间复杂度：0(n^2)，空间复杂度：O(1)
     */
    private static int[] twoSum1(int[] nums, int target) {
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == diff) {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 两遍哈希表，第一次迭代将每个元素的值和它索引添加到表中，第二次迭代将检查每个元素对应的目标元素(target-nums[i])是否存在；
     * 时间复杂度：0(n),空间复杂度：O(n)
     */
    private static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{i, map.get(diff)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍哈希表，在进行迭代将元素添加到表中的时候，还会回头来检查表中是否已存在当前元素所对应的目标元素；
     */
    private static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 索引法，左右索引，两值相加，大了就降右边，小了就增左边。
     * 错误，当出现都是负数的情况将无法实现
     */
    private static int[] twoSum4(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;

        while (sum != target && left < nums.length && right > 0) {
            sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            }
            if (sum < target) {
                left++;
            }
        }
        return new int[]{left, right};
    }
}

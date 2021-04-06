package code.java.dailypractice;

/**
 * 删除数组中重复项
 * 原地删除，返回删除后数组的长度，不可使用额外的数组空间，O(1)
 */
public class Arrays20210406 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3};
        int duplicate = removeDuplicates(nums);
        System.out.println(duplicate);
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int slow = 1, fast = 1;
        while (fast < n) {
            if (nums[slow - 1] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

}

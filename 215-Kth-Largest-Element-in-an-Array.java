 import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return quickSelect(list, k);
    }

    private int quickSelect(List<Integer> nums, int k) {
        int pivot = nums.get(new Random().nextInt(nums.size()));

        List<Integer> left = new ArrayList<>();   // > pivot
        List<Integer> mid = new ArrayList<>();    // == pivot
        List<Integer> right = new ArrayList<>();  // < pivot

        for (int num : nums) {
            if (num > pivot) left.add(num);
            else if (num == pivot) mid.add(num);
            else right.add(num);
        }

        if (k <= left.size()) {
            return quickSelect(left, k);
        }
        if (k <= left.size() + mid.size()) {
            return pivot;
        }
        return quickSelect(right, k - left.size() - mid.size());
    }
}
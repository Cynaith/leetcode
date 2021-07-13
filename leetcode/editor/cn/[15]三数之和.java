//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 3489 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        if (length < 3) {
            return result;
        }

        for (int first = 0; first < length; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < length; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }


//                for (int third = length - 1; third > second; --third) {
//                    if (third < length - 1 && nums[third] == nums[third + 1]) {
//                        continue;
//                    }
//                    if (nums[first] + nums[second] + nums[third] > 0) {
//                        break;
//                    }
//
//                    if (nums[first] + nums[second] + nums[third] == 0) {
//                        List<Integer> resultRow = new ArrayList<>();
//                        resultRow.add(nums[first]);
//                        resultRow.add(nums[second]);
//                        resultRow.add(nums[third]);
//                        result.add(resultRow);
//                    }
//                }

                int third = length - 1;
                while (second < third && nums[second] + nums[third] + nums[first] > 0) {
                    --third;
                }

                if (second == third){
                    break;
                }

                if (nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> resultRow = new ArrayList<>();
                    resultRow.add(nums[first]);
                    resultRow.add(nums[second]);
                    resultRow.add(nums[third]);
                    result.add(resultRow);
                    continue;
                }

            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

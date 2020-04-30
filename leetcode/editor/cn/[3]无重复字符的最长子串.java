//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        int thismax = 0;
        for (int i = 0 ,j = i+1 ; i < s.length()&&j<s.length()+1;) {
            if (isUnique(s,i,j)){
                j++;
            }
            else {
                i++;
            }
            thismax = Math.max(thismax,j-i);
        }
        return thismax-1;
    }

    public boolean isUnique(String str, int start, int end) {
        Set set = new HashSet<Character>();
        for (; start < end; start++) {
            if (!set.add(str.charAt(start))) return false;
        }
        return true;
    }


//    public static void main(String[] args) {
//
//        System.out.println(new Solution().lengthOfLongestSubstring("aaa"));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

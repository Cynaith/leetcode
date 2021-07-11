//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1684 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        int strShortLength = 200;
        for (String str : strs) {
            if (str.length() < strShortLength) {
                strShortLength = str.length();
            }
        }
        if (strShortLength == 0) {
            return "";
        }
        if (length == 0) {
            return "";
        }

        String common = "";
        boolean falg = true;
        for (int i = 0; i < strShortLength; i++) {
            char indexChar = 0;
            for (int i1 = 0; i1 < length; i1++) {
                if (i1 > 0) {
                    if (indexChar != strs[i1].charAt(i)) {
                        falg = false;
                    }
                } else {
                    indexChar = strs[i1].charAt(i);
                }
            }

            if (falg) {
                common  = common + String.valueOf(indexChar);
            } else {
                break;
            }
        }
        return common;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

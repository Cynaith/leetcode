//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2495 👎 0


import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution20 {
    public boolean isValid(String s) {
        Map<String, String> pairMap = new HashMap<String, String>();
        pairMap.put("(", ")");
        pairMap.put("{", "}");
        pairMap.put("[", "]");


        if (s.length() == 0) {
            return true;
        }

        char[] stack = new char[s.length()];
        int stackIndex = 0;

        char[] strChars = s.toCharArray();
        for (int i = 0; i < strChars.length; i++) {

            if (stackIndex > 0 && String.valueOf(strChars[i]).equals(pairMap.get(String.valueOf(stack[stackIndex - 1])))) {
                stack[stackIndex - 1] = 0;
                stackIndex--;
            } else {
                stack[stackIndex] = strChars[i];
                stackIndex++;
            }
        }

        if (stackIndex == 0) {
            return true;
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

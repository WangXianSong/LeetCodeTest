## 20 有效的括号 Valid Parentheses

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

1. 左括号必须用相同类型的右括号闭合。

2. 左括号必须以正确的顺序闭合。

注意空字符串可被认为是有效字符串。



## 解题思路

利用栈的后进先出的原理，即若遇到左括号**入栈**，遇到右括号时将对应栈顶左括号**出栈**，则遍历完所有括号后 `stack` 仍然为空；

**复杂度分析**

- 时间复杂度 O(N)：正确的括号组合需要遍历 N遍 `s`；
- 空间复杂度 O(N)：栈使用的空间大小。



## 实现代码

```java
class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                // 栈顶为空，没有匹配
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == '}' && topChar != '{') {
                    return false;
                }
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
            }
        }
        // 只有栈最后为空才返回true
        return stack.isEmpty();
    }
}
```


import java.util.Stack;

/**
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * <p>
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * <p>
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * <p>
 * 输入："/../"
 * 输出："/"
 */
class Solution {
    public String simplifyPath(String path) {
        if (path == null)
            return null;

        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < paths.length; i++) {
            String p = paths[i];

            if (p.equals(".") || p.equals(""))
                continue;
            else if (p.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(p);
        }

        if (stack.isEmpty())
            return "/";

        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.toString();

    }
}
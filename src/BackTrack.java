import java.util.ArrayList;
import java.util.List;

public class BackTrack {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    private static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        if (n >= 0) {
            StringBuilder stack = new StringBuilder(n * 2);
            backtrack(0, 0, stack, res, n);
        }

        return res;
    }

    private static void backtrack(int openCount, int closedCount, StringBuilder stack, List<String> res, int max) {
        if (openCount == max && closedCount == max) {
            res.add(stack.toString());
            return;
        }

        if (openCount < max) {
            stack.append('(');
            backtrack(openCount + 1, closedCount, stack, res, max);
            stack.deleteCharAt(stack.length() - 1);
        }

        if (closedCount < openCount) {
            stack.append(')');
            backtrack(openCount, closedCount + 1, stack, res, max);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}

package leetcode.generateparentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        solution.generateParenthesis(3).forEach(s -> System.out.println(s));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        DFS(0, "", 0, 0, result, n);
        return result;
    }

    private void DFS(int index, String sum, int openCount, int closeCount, List<String> result, int n) {
        if (index == n * 2) {
            result.add(sum);
            return;
        } else {
            if (openCount < n) {
                DFS(index + 1, sum + "(", openCount + 1, closeCount, result, n);
            }

            if (closeCount < openCount) {
                DFS(index + 1, sum + ")", openCount, closeCount + 1, result, n);
            }
        }
    }
}

class Solution {
    Set<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int leftRemove = 0;
        int rightRemove = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftRemove++;
            } else if (c == ')') {
                if (leftRemove > 0) {
                    leftRemove--;
                } else {
                    rightRemove++;
                }
            }
        }

        dfs(s, 0, leftRemove, rightRemove, 0, new StringBuilder());

        return new ArrayList<>(result);
    }

    private void dfs(String s, int index, int leftRemove,
                     int rightRemove, int balance, StringBuilder path) {

        if (balance < 0) return;

        if (index == s.length()) {
            if (leftRemove == 0 && rightRemove == 0 && balance == 0) {
                result.add(path.toString());
            }
            return;
        }

        char c = s.charAt(index);

        path.append(c);

        if (c == '(') {
            dfs(s, index + 1, leftRemove, rightRemove,
                balance + 1, path);
        } else if (c == ')') {
            if (balance > 0) {
                dfs(s, index + 1, leftRemove, rightRemove,
                    balance - 1, path);
            }
        } else {
            dfs(s, index + 1, leftRemove, rightRemove,
                balance, path);
        }

        path.deleteCharAt(path.length() - 1);

        if (c == '(' && leftRemove > 0) {
            dfs(s, index + 1, leftRemove - 1, rightRemove,
                balance, path);
        }

        if (c == ')' && rightRemove > 0) {
            dfs(s, index + 1, leftRemove, rightRemove - 1,
                balance, path);
        }
    }
}
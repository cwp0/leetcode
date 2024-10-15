// 
// @Question: [79]单词搜索 
// @Author: cwp0
// @CreatedTime: 2024-10-09 21:45:07
// @Description: 
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 字符串 回溯 矩阵 👍 1885 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean found = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, word, 0);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    // 从(i, j)开始向四周匹配，视图匹配word[p..]
    private void dfs(char[][] board, int i, int j, String word, int p) {
        // 整个word已经被匹配完，找到一个答案
        if (p == word.length()) {
            found = true;
            return ;
        }
        if (found) {
            return ;
        }
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return ;
        }
        if (board[i][j] != word.charAt(p)) {
            return ;
        }
        // 已经匹配过的字符串，添加一个负号作为标记，避免走回头路
        board[i][j] = (char)(-board[i][j]);
        // word[p]被board[i][j]，开始搜索word[p+1..]
        dfs(board, i, j+1, word, p+1);
        dfs(board, i+1, j, word, p+1);
        dfs(board, i-1, j, word, p+1);
        dfs(board, i, j-1, word, p+1);
        // 将该单元格恢复成其原来的值。因为DFS的搜索路径是回溯的，在探索完一个路径之后，必须将路径上“被标记过的”单元格恢复成初始状态，以便继续探索其他可能的路径。
        board[i][j] = (char)(-board[i][j]);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 
// @Question: [51]N 皇后 
// @Author: cwp0
// @CreatedTime: 2024-10-15 16:25:24
// @Description: 
//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 2148 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
         for (int i = 0; i < n; i++) {
             sb.append(".");
         }
         for (int i = 0; i < n; i++) {
             board.add(sb.toString());
         }
         backtrack(board, 0);
         return res;
    }

    // board中小于row的行已经被成功放置皇后
    // 选择列表：第row行的所有列都是放置皇后的选择
    // 结束条件：row超过board的最后一行
    private void backtrack(List<String> board, int row) {
        // 结束条件
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
            return ;
        }

        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            char[] rowChars = board.get(row).toCharArray();
            rowChars[col] = 'Q';
            board.set(row, new String(rowChars));
            // 进入下一行决策
            backtrack(board, row+1);
            // 撤销选择
            rowChars[col] = '.';
            board.set(row, new String(rowChars));
        }

    }

    // 是否可以在 board[row][col] 放置皇后？
    private boolean isValid(List<String> board, int row, int col) {
        int n = board.size();
        // 检查列是否有皇后互相冲突
        for (int i = 0; i <= row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

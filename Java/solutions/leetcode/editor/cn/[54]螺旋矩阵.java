// 
// @Question: [54]螺旋矩阵 
// @Author: cwp0
// @CreatedTime: 2024-08-07 20:25:46
// @Description: 
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1733 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) return res;

        boolean[][] isVisited = new boolean[m][n];
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int total = m * n;
        int row = 0, col = 0, directionIndex = 0;
        for (int i = 0; i < total; i++) {
            res.add(matrix[row][col]);
            isVisited[row][col] = true;

            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || isVisited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }

            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

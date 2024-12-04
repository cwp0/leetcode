// 
// @Question: [2056]棋盘上有效移动组合的数目 
// @Author: cwp0
// @CreatedTime: 2024-12-04 13:07:16
// @Description: 
//有一个 8 x 8 的棋盘，它包含 n 个棋子（棋子包括车，后和象三种）。给你一个长度为 n 的字符串数组 pieces ，其中 pieces[i] 表示第
// i 个棋子的类型（车，后或象）。除此以外，还给你一个长度为 n 的二维整数数组 positions ，其中 positions[i] = [ri, ci] 表
//示第 i 个棋子现在在棋盘上的位置为 (ri, ci) ，棋盘下标从 1 开始。 
//
// 棋盘上每个棋子都可以移动 至多一次 。每个棋子的移动中，首先选择移动的 方向 ，然后选择 移动的步数 ，同时你要确保移动过程中棋子不能移到棋盘以外的地方。
//棋子需按照以下规则移动： 
//
// 
// 车可以 水平或者竖直 从 (r, c) 沿着方向 (r+1, c)，(r-1, c)，(r, c+1) 或者 (r, c-1) 移动。 
// 后可以 水平竖直或者斜对角 从 (r, c) 沿着方向 (r+1, c)，(r-1, c)，(r, c+1)，(r, c-1)，(r+1, c+1)，(
//r+1, c-1)，(r-1, c+1)，(r-1, c-1) 移动。 
// 象可以 斜对角 从 (r, c) 沿着方向 (r+1, c+1)，(r+1, c-1)，(r-1, c+1)，(r-1, c-1) 移动。 
// 
//
// 移动组合 包含所有棋子的 移动 。每一秒，每个棋子都沿着它们选择的方向往前移动 一步 ，直到它们到达目标位置。所有棋子从时刻 0 开始移动。如果在某个时刻
//，两个或者更多棋子占据了同一个格子，那么这个移动组合 不有效 。 
//
// 请你返回 有效 移动组合的数目。 
//
// 注意： 
//
// 
// 初始时，不会有两个棋子 在 同一个位置 。 
// 有可能在一个移动组合中，有棋子不移动。 
// 如果两个棋子 直接相邻 且两个棋子下一秒要互相占据对方的位置，可以将它们在同一秒内 交换位置 。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：pieces = ["rook"], positions = [[1,1]]
//输出：15
//解释：上图展示了棋子所有可能的移动。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：pieces = ["queen"], positions = [[1,1]]
//输出：22
//解释：上图展示了棋子所有可能的移动。
// 
//
// 示例 3: 
//
// 
//
// 
//输入：pieces = ["bishop"], positions = [[4,3]]
//输出：12
//解释：上图展示了棋子所有可能的移动。
// 
//
// 示例 4: 
//
// 
//
// 
//输入：pieces = ["rook","rook"], positions = [[1,1],[8,8]]
//输出：223
//解释：每个车有 15 种移动，所以总共有 15 * 15 = 225 种移动组合。
//但是，有两个是不有效的移动组合：
//- 将两个车都移动到 (8, 1) ，会导致它们在同一个格子相遇。
//- 将两个车都移动到 (1, 8) ，会导致它们在同一个格子相遇。
//所以，总共有 225 - 2 = 223 种有效移动组合。
//注意，有两种有效的移动组合，分别是一个车在 (1, 8) ，另一个车在 (8, 1) 。
//即使棋盘状态是相同的，这两个移动组合被视为不同的，因为每个棋子移动操作是不相同的。
// 
//
// 示例 5： 
//
// 
//
// 
//输入：pieces = ["queen","bishop"], positions = [[5,7],[3,4]]
//输出：281
//解释：总共有 12 * 24 = 288 种移动组合。
//但是，有一些不有效的移动组合：
//- 如果后停在 (6, 7) ，它会阻挡象到达 (6, 7) 或者 (7, 8) 。
//- 如果后停在 (5, 6) ，它会阻挡象到达 (5, 6) ，(6, 7) 或者 (7, 8) 。
//- 如果象停在 (5, 2) ，它会阻挡后到达 (5, 2) 或者 (5, 1) 。
//在 288 个移动组合当中，281 个是有效的。
// 
//
// 
//
// 提示： 
//
// 
// n == pieces.length 
// n == positions.length 
// 1 <= n <= 4 
// pieces 只包含字符串 "rook" ，"queen" 和 "bishop" 。 
// 棋盘上最多只有一个后。 
// 1 <= ri, ci <= 8 
// 每一个 positions[i] 互不相同。 
// 
//
// Related Topics 数组 字符串 回溯 模拟 👍 27 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static int[][] rookDirections = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] bishopDirections = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static int[][] queenDirections = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    String[] pieces;
    int[][] positions;
    int n;
    int res = 0;
    List<Movement> stack = new ArrayList<Movement>();

    public int countCombinations(String[] pieces, int[][] positions) {
        this.pieces = pieces;
        this.positions = positions;
        this.n = pieces.length;
        dfs(0);
        return res;
    }

    public void dfs(int u) {
        if (u == n) {
            res++;
            return;
        }
        int[][] directions;
        if ("rook".equals(pieces[u])) {
            directions = rookDirections;
        } else if ("queen".equals(pieces[u])) {
            directions = queenDirections;
        } else {
            directions = bishopDirections;
        }

        // 处理第 u 个棋子原地不动的情况
        stack.add(new Movement(positions[u][0], positions[u][1], positions[u][0], positions[u][1], 0, 0));
        if (check(u)) {
            dfs(u + 1);
        }
        stack.remove(stack.size() - 1);

        // 枚举第 u 个棋子在所有方向、所有步数的情况
        for (int i = 0; i < directions.length; i++) {
            for (int j = 1; j < 8; j++) {
                int x = positions[u][0] + directions[i][0] * j;
                int y = positions[u][1] + directions[i][1] * j;
                if (x < 1 || x > 8 || y < 1 || y > 8) {
                    break;
                }
                stack.add(new Movement(positions[u][0], positions[u][1], x, y, directions[i][0], directions[i][1]));
                if (check(u)) {
                    dfs(u + 1);
                }
                stack.remove(stack.size() - 1);
            }
        }
    }

    // 判断第 u 个棋子是否之前的棋子在移动过程中相遇
    public boolean check(int u) {
        for (int v = 0; v < u; v++) {
            if (stack.get(u).cross(stack.get(v))) {
                return false;
            }
        }
        return true;
    }
}

class Movement {
    public final int START_X;
    public final int START_Y;
    public final int END_X;
    public final int END_Y;
    public final int DX;
    public final int DY;
    public int curX;
    public int curY;

    public Movement(int startX, int startY, int endX, int endY, int dx, int dy) {
        this.START_X = startX;
        this.START_Y = startY;
        this.END_X = endX;
        this.END_Y = endY;
        this.DX = dx;
        this.DY = dy;
        this.curX = startX;
        this.curY = startY;
    }

    public void reset() {
        curX = START_X;
        curY = START_Y;
    }

    public boolean stopped() {
        return curX == END_X && curY == END_Y;
    }

    public void advance() {
        if (!stopped()) {
            curX += DX;
            curY += DY;
        }
    }

    public boolean cross(Movement oth) {
        // 每次判断是否相遇时需要重置 cur
        reset();
        oth.reset();
        while (!stopped() || !oth.stopped()) {
            advance();
            oth.advance();
            if (curX == oth.curX && curY == oth.curY) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


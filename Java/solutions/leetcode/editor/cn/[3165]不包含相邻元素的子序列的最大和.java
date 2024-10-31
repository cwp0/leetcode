// 
// @Question: [3165]不包含相邻元素的子序列的最大和 
// @Author: cwp0
// @CreatedTime: 2024-10-31 17:08:39
// @Description: 
//给你一个整数数组 nums 和一个二维数组 queries，其中 queries[i] = [posi, xi]。 
//
// 对于每个查询 i，首先将 nums[posi] 设置为 xi，然后计算查询 i 的答案，该答案为 nums 中 不包含相邻元素 的 子序列 的 最大 和。
// 
//
// 返回所有查询的答案之和。 
//
// 由于最终答案可能非常大，返回其对 10⁹ + 7 取余 的结果。 
//
// 子序列 是指从另一个数组中删除一些或不删除元素而不改变剩余元素顺序得到的数组。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [3,5,9], queries = [[1,-2],[0,-3]] 
// 
//
// 输出：21 
//
// 解释： 执行第 1 个查询后，nums = [3,-2,9]，不包含相邻元素的子序列的最大和为 3 + 9 = 12。 执行第 2 个查询后，nums =
// [-3,-2,9]，不包含相邻元素的子序列的最大和为 9 。 
//
// 示例 2： 
//
// 
// 输入：nums = [0,-1], queries = [[0,-5]] 
// 
//
// 输出：0 
//
// 解释： 执行第 1 个查询后，nums = [-5,-1]，不包含相邻元素的子序列的最大和为 0（选择空子序列）。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 1 <= queries.length <= 5 * 10⁴ 
// queries[i] == [posi, xi] 
// 0 <= posi <= nums.length - 1 
// -10⁵ <= xi <= 10⁵ 
// 
//
// Related Topics 线段树 数组 分治 动态规划 👍 34 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class SegNode {
    long v00, v01, v10, v11;
    SegNode() {
        v00 = v01 = v10 = v11 = 0;
    }

    void set(long v) {
        v00 = v01 = v10 = 0;
        v11 = Math.max(v, 0);
    }

    long best() {
        return v11;
    }
}

class SegTree {
    int n;
    SegNode[] tree;

    SegTree(int n) {
        this.n = n;
        tree = new SegNode[n * 4 + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new SegNode();
        }
    }

    void init(int[] nums) {
        internalInit(nums, 1, 1, n);
    }

    void update(int x, int v) {
        internalUpdate(1, 1, n, x + 1, v);
    }

    long query() {
        return tree[1].best();
    }

    private void internalInit(int[] nums, int x, int l, int r) {
        if (l == r) {
            tree[x].set(nums[l - 1]);
            return;
        }
        int mid = (l + r) / 2;
        internalInit(nums, x * 2, l, mid);
        internalInit(nums, x * 2 + 1, mid + 1, r);
        pushup(x);
    }

    private void internalUpdate(int x, int l, int r, int pos, int v) {
        if (l > pos || r < pos) {
            return;
        }
        if (l == r) {
            tree[x].set(v);
            return;
        }
        int mid = (l + r) / 2;
        internalUpdate(x * 2, l, mid, pos, v);
        internalUpdate(x * 2 + 1, mid + 1, r, pos, v);
        pushup(x);
    }

    private void pushup(int x) {
        int l = x * 2, r = x * 2 + 1;
        tree[x].v00 = Math.max(tree[l].v00 + tree[r].v10, tree[l].v01 + tree[r].v00);
        tree[x].v01 = Math.max(tree[l].v00 + tree[r].v11, tree[l].v01 + tree[r].v01);
        tree[x].v10 = Math.max(tree[l].v10 + tree[r].v10, tree[l].v11 + tree[r].v00);
        tree[x].v11 = Math.max(tree[l].v10 + tree[r].v11, tree[l].v11 + tree[r].v01);
    }
}

class Solution {
    public static final int MOD = 1000000007;
    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int n = nums.length;
        SegTree tree = new SegTree(n);
        tree.init(nums);

        long ans = 0;
        for (int[] q : queries) {
            tree.update(q[0], q[1]);
            ans = (ans + tree.query()) % MOD;
        }
        return (int) ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

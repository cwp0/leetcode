// 
// @Question: [210]课程表 II 
// @Author: cwp0
// @CreatedTime: 2024-11-15 12:48:01
// @Description: 
//现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 
//prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。 
//
// 
// 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。 
// 
//
// 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：[0,1]
//解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
// 
//
// 示例 2： 
//
// 
//输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//输出：[0,2,1,3]
//解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。 
//
// 示例 3： 
//
// 
//输入：numCourses = 1, prerequisites = []
//输出：[0]
// 
//
// 
//提示：
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// 所有[ai, bi] 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 983 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 初始化入度数组和邻接表
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();

        // 初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // 构建图并计算每个节点的入度
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            adjList.get(pre).add(course);
            inDegree[course]++;
        }

        // 创建队列，加入所有入度为 0 的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 用于保存拓扑排序的结果
        int[] order = new int[numCourses];
        int index = 0;

        // Kahn 拓扑排序
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;

            // 遍历当前课程的邻接节点
            for (int neighbor : adjList.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // 如果结果中的课程数等于总课程数，说明没有环
        return index == numCourses ? order : new int[0];
    }
}

//leetcode submit region end(Prohibit modification and deletion)

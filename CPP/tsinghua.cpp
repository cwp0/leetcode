/**
 * @Program: CPP
 * @File: tsinghua.cpp
 * @Description: 2023 “清华社杯”大学生算法竞赛
 * @Author: cwp0
 * @CreatedTime: 2024/01/06 16:22
 * @Version: 1.0
 */

//#include <iostream>
//#include <vector>
//#include <set>
//
//using namespace std;
//
//bool isStarTree(int n, int m, vector<pair<int, int>>& edges) {
//    if (m != n - 1) {
//        return false;  // 星形树的边数应为顶点数减一
//    }
//
//    set<int> nodes;  // 用集合存储图中的节点
//    set<int> endpoints;  // 用集合存储星形树的端点
//
//    for (const auto& edge : edges) {
//        nodes.insert(edge.first);
//        nodes.insert(edge.second);
//    }
//
//    for (const auto& edge : edges) {
//        endpoints.insert(edge.first);
//    }
//
//    // 星形树的特征是有一个节点与其他所有节点相连
//    if (endpoints.size() != 1) {
//        return false;
//    }
//
//    // 检查是否形成链
//    int endpoint = *(endpoints.begin());
//    int current = endpoint;
//
//    while (!nodes.empty()) {
//        nodes.erase(current);
//
//        bool found = false;
//        for (const auto& edge : edges) {
//            if (edge.first == current) {
//                current = edge.second;
//                found = true;
//                break;
//            } else if (edge.second == current) {
//                current = edge.first;
//                found = true;
//                break;
//            }
//        }
//
//        if (!found) {
//            return false;  // 无法找到下一个节点，不是链
//        }
//    }
//
//    return true;
//}
//
//int main() {
//    int t;
//    cin >> t;
//
//    for (int i = 0; i < t; ++i) {
//        int n, m;
//        cin >> n >> m;
//
//        vector<pair<int, int>> edges;
//        for (int j = 0; j < m; ++j) {
//            int u, v;
//            cin >> u >> v;
//            edges.push_back({u, v});
//        }
//
//        if (isStarTree(n, m, edges)) {
//            cout << "Yes" << endl;
//        } else {
//            cout << "No" << endl;
//        }
//    }
//
//    return 0;
//}



//#include <iostream>
//#include <vector>
//#include <algorithm>
//
//using namespace std;
//
//int calculate(const vector<int> p) {
//    int sum = 0;
//    for(size_t i = 0; i < p.size()-1; i++) {
//        sum += abs(p[i] - p[i+1]);
//    }
//    return sum;
//}
//
//int generatePermutations(int n) {
//    vector<vector<int>> permutations;
//
//    vector<int> currentPermutation(n);
//    for(int i = 0; i < n; i ++) {
//        currentPermutation[i] = i + 1;
//    }
//    int res = 0;
//    do {
//        if(currentPermutation[0] != 1 || currentPermutation[0] != n || currentPermutation.back() != 1 || currentPermutation.back() != n) {
//            res = max(calculate(currentPermutation), res);
//        }
//
//    } while(next_permutation(currentPermutation.begin(), currentPermutation.end()) && currentPermutation.back() <= n);
//
//    return res;
//
//}
//
//
//
//int main() {
//
//    int T;
//    cin >> T;
//    int n[T];
//    for (int i = 0; i < T; i ++) {
//        cin >> n[i];
//    }
//    int m = 0;
//    for (int i = 0; i < T; i ++) {
//        int result = generatePermutations(n[i]);
//        if(n[i] == 1) {
//            cout << 0 << endl;
//        } else {
//            cout << result << endl;
//        }
//    }
//
//
//    return 0;
//}




//6.
//#include <iostream>
//
//using namespace std;
//
//int main() {
//    int T;
//    int N;
//    cin >> T;
//
//    for(int j = 0; j < T; j ++) {
//
//        cin >> N;
//
//        int B[T][N];
//        for (int i = 0; i < N; i ++) {
//            cin >> B[j][i];
//        }
//
//        int Xi[j][N];
//        for (int i = 0; i < N; i ++) {
//            cin >> Xi[j][i];
//        }
//
//    }
//
//
////    for(int j = 0; j < T; j ++) {
////        int res = B[j][0];
////        cout << endl;
////        for (int i = 0; i < N; i ++) {
////            for(int k = 1; k < Xi[j][i]; k ++) {
////                int max = std::max(res, B[j][k]);
////                if(max <= Xi[j][i]) {
////                    res = max;
////                }
////            }
////            if(res <= Xi[j][i]) {
////                cout << res << endl;
////            }
////            else {
////                cout << -1 << endl;
////            }
////        }
////    }
//
//
//
//    return 0;
//}


////7.
//#include <iostream>
//
//using namespace std;
//
//int main() {
//    long long int day;
//    cin >> day;
//
//    long long int sum = (1 + day) * day / 2;
//
//    long long int a = sum / day;
//
//    cout << sum << endl;
//    cout << a;
//
//    return 0;
//}



// 1.
//#include <iostream>
//#include <iomanip>
//
//using namespace std;
//
//int main() {
//    double oldS;
//    cin >> oldS;
//
//    double newS = 0.75 * oldS;
//
//    cout << fixed << setprecision(6) << newS;
//
//    return 0;
//}

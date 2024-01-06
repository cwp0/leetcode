/**
 * @Program: CPP
 * @File: qjs.cpp
 * @Description: 2023-2024第四届全国大学生算法设计与编程挑战赛 写了5题。
 * @Author: cwp0
 * @CreatedTime: 2024/01/06 16:17
 * @Version: 1.0
 */

////2.
//#include <iostream>
//// #include<bits/stdc++.h>
//#include <map>
//
//using namespace std;
//
//const int maxn = 2e5 + 5;
//
//int get_fa(vector<pair<int,int>> &fa, int x) {
//    return x == fa[x].first ? x : fa[x].first = get_fa(fa, fa[x].first);
//}
//
//void unionfa(vector<pair<int, int>> &fa, int x, int y) {
//    int fax = get_fa(fa, x);
//    int fay = get_fa(fa, y);
//    if(fa[fax].second > fa[fay].second ) {
//        fa[fay].first = fax;
//    } else {
//        fa[fax].first = fay;
//        if(fa[fax].second == fa[fay].second) {
//            fa[fay].second += 1;
//        }
//    }
//}
//
//map<int, vector<int>>get_set(vector<pair<int, int >> &fa, int n) {
//    map<int, vector<int>> m;
//    for(int i = 1; i <= n; i ++) {
//        int f = get_fa(fa,i);
//        if(!m.count(f)) {
//            m[f] = vector<int>{i};
//        } else {
//            m[f].push_back(i);
//        }
//    }
//    return m;
//}
//
//pair<int, int> calculate(vector<pair<int, int>> &fa, vector<int> v) {
//    int maxv = -1, minv = maxn;
//    map<int, int> count;
//    for(auto x: v) {
//        int f = get_fa(fa, x);
//        if(count.count(f)) {
//            count[f] += 1;
//        } else {
//            count[f] = 1;
//        }
//    }
//    for(auto i :count) {
//        maxv = max(maxv, i.second);
//        minv = min(minv, i.second);
//    }
//    return pair<int, int>(maxv, minv);
//}
//
//int main() {
//    int n, m;
//    cin >> n >> m;
//    vector<pair<int, int >> fm(n+5);
//    for(int i = 0; i <= n; i++) {
//        fm[i] = pair<int, int> {i, i};
//    }
//    while (m -- ) {
//        int a, b;
//        cin >> a >> b;
//        unionfa(fm, a, b);
//    }
//
//    int k;
//    cin >> k;
//    vector<pair<int, int >> ft(n + 5);
//
//    for(int i = 0; i <= n; i++) {
//        ft[i] = pair<int, int>{i, 1};
//    }
//
//    while(k -- ) {
//        int a, b;
//        cin >> a >> b;
//        unionfa(ft, a, b);
//    }
//    map<int, vector<int>> mp = get_set(ft, n);
//    int maxv = 1, minv = 2e5;
//
//    for(auto  v: mp) {
//        pair<int, int> p = calculate(fm, v.second);
//        maxv = max(maxv, p.first);
//        minv = min(minv, p.second);
//    }
//
//    cout << maxv << " " << minv << endl;
//
//    return 0;
//}

////3.
////#include<bits/stdc++.h>
//#include <iostream>
//
//using namespace std;
//
//int main() {
//    int n;
//    cin >> n;
//
//    int count = 0;
//    for(int i = 1; i <= n; i++ ) {
//        if(i % 4 ==0) {
//            count ++;
//        }
//        if (i % 2 == 1) {
//            count ++;
//        }
//    }
//
//    cout << count << endl;
//
//    return 0;
//}



////6.
////#include<bits/stdc++.h>
//#include <iostream>
//
//using namespace std;
//
//int main() {
//    int res = 0;
//    char str[200];
//    cin.getline(str, 200);
//
//    for(int i = 0; i < strlen(str); i ++) {
//        if(str[i] == ' ') {
//            res ++;
//        } else if (str[i] == 'a'||str[i] == 'd'||str[i] == 'g'||str[i] == 'j'||str[i] == 'm'||str[i] == 'p'||str[i] == 't'||str[i] == 'w') {
//            res ++;
//        } else if (str[i] == 'b'||str[i] == 'e'||str[i] == 'h'||str[i] == 'k'||str[i] == 'n'||str[i] == 'q'||str[i] == 'u'||str[i] == 'x'){
//            res += 2;
//        } else if (str[i] == 'c'||str[i] == 'f'||str[i] == 'i'||str[i] == 'l'||str[i] == 'o'||str[i] == 'r'||str[i] == 'v'||str[i] == 'y') {
//            res += 3;
//        } else if(str[i] == 's'||str[i] == 'z') {
//            res += 4;
//        }
//    }
//
//    cout << res << endl;
//
//    return 0;
//}


//// 9.
//#include<bits/stdc++.h>
//#include <iostream>
//#include <cmath>
//
//using namespace std;
//
//void decompose(long long int b, long long int& a, int& q) {
//    q = b % 10;
//    a = b / 10;
//}
//
//int main() {
//    int n;
//    cin >> n;
//    long long int b[n];
//    for(int i = 0; i < n; i ++) {
//        cin >> b[i];
//    }
//    long long int a[n];
//    int q[n];
//    long long int sum = 0;
//    for(int i = 0; i < n; i ++) {
//        decompose(b[i], a[i], q[i]);
//        sum += pow(a[i], q[i]);
//    }
//    cout << sum << endl;
//    return 0;
//}





//// 1.
//#include <iostream>
//#include <bitset>
//#include <string>
//
//using namespace std;
//
//int countZeros(string str) {
//    int count = 0;
//    for(char c: str) {
//        if(c == '0') {
//            count ++;
//        }
//    }
//    return count;
//}
//
//int main() {
//    unsigned int a;
//    cin >> a;
//    string atobit = bitset<sizeof(unsigned int)*8>(a).to_string();
//    string temp = atobit.substr(atobit.find_first_of("1"));
//    unsigned int num = countZeros(temp);
//    cout << num << endl;
//    return 0;
//}
# 1874 스택 수열

## 문제

스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.

1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.

---

## 입력
첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.

---

## 출력
입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.

---

## 예제 입력 1
```
8
4
3
6
8
7
5
2
1
```

## 예제 출력 1 
```
+
+
+
+
-
-
+
+
-
+
+
-
-
-
-
-
```

## 예제 입력 2
```
5
1
2
5
3
4
```
## 예제 출력 2
```
NO
```

---

## 풀이

`stack`을 사용하여 푸는 문제

1. 먼저 입력받은 수열을 vector에 저장한다.
2. 1부터 순차적으로 stack에 push하며, push('+') operation에 대한 문자열을 저장
3. 도중, stack의 top과 container에 담겨있는 수열을 비교하여 같으면 계속 pop을 하며, 2번 과정과 같이, pop('-') operation에 대한 문자열을 저장
4. 이 과정이 끝났을 때, stack이 비어있지 않으면 수열을 완료하지 못했다는 뜻이므로, `NO` 출력, stack이 비었다면 `charContainer`에 저장해 두었던 operation 꺼내어 출력.

---

## 코드

```c++
//
// Created by 최우영 on 2021/09/14.
//

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int n;
stack<int> s;

// 입력받은 수열 저장할 벡터
vector<int> container;
// push, pop 저장할 벡터
vector<char> charContainer;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;

    for (int i = 0; i < n; ++i) {
        int target = 0;
        cin >> target;
        container.push_back(target);
    }

    int containerIdx = 0;

    for (int i = 1; i <= n; ++i) {
        s.push(i);
        charContainer.push_back('+');

        while (!s.empty() && s.top() == container[containerIdx]) {
            s.pop();
            charContainer.push_back('-');
            containerIdx++;
        }
    }

    if (!s.empty()) {
        cout << "NO\n";
        return 0;
    } else {
        for (char i: charContainer) {
            cout << i << "\n";
        }

        return 0;
    }
}
```
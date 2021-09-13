# 11866 요세푸스 문제 0

## 문제
요세푸스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

---

## 입력
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)

---

## 출력
예제와 같이 요세푸스 순열을 출력한다.

---

## 예제 입력 1
```
7 3
```

## 예제 출력 1 
```
<3, 6, 2, 7, 5, 1, 4>
```

---

## 풀이

`queue`를 사용하여 푸는 문제

1. 입력받은 N 까지의 수를 모두 큐에 push한다.
2. K번째 수를 찾을 때까지 K-1번 for loop로 순회한다. 
3. K-1번의 for loop에서는 해당 큐의 front를 pop한 후, 큐의 뒤쪽으로 push한다.
4. K-1번의 for loop가 끝나면, K번째 수는 pop한다.
5. 이 과정을 큐가 empty 상태가 될 때까지 반복하면, 순열이 완성된다.

---

## 코드

```c++
//
// Created by 최우영 on 2021/09/13.
//

#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int N, K;
queue<int> numQueue;
vector<int> container;

void print() {
    cout << "<";
    for (int i = 0; i < container.size(); ++i) {
        if (i != container.size() - 1) cout << container[i] << ", ";
        else cout << container[i];
    }
    cout << ">";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> K;

    // 1.
    for (int i = 1; i <= N; ++i) {
        numQueue.push(i);
    }

    // 5.
    while (!numQueue.empty()) {
        // 2.
        for (int i = 0; i < K - 1; ++i) {
            // 3.
            int front = numQueue.front();
            numQueue.push(front);
            numQueue.pop();
        }

        // 4.
        container.push_back(numQueue.front());
        numQueue.pop();
    }

    print();
}
```
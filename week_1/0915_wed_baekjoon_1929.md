# 1929 소수 구하기

## 문제

M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

---

## 입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

---

## 출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

---

## 예제 입력 1
```
3 16
```

## 예제 출력 1 
```
3
5
7
11
13
```

---

## 풀이

오늘은 간단하게 소수를 구하는 문제를 상기도 시키고, 휴식도 할 겸 풀어보았다.
코드에서 소수를 구하는데 사용한 `isPrimeNumber()` 함수는 아래 링크를 통해 상세하게 알아볼 수 있다.

[소수 판별법에 관한 블로그 포스팅](https://wooyoung-tom.medium.com/algorithms-소수-prime-number-판별하는-간단한-방법-f01c2e8114cb)

하지만! 이 문제에서 처음에는 틀렸다고 떴는데, 해당 함수는 2부터 측정할 수 있도록 코딩하여서 1에 대한 예외처리가 되어있지 않아 틀렸다.

해당 예외처리 후 진행하니 맞았다고 뜨더라....

다음부터는 예외처리도 염두에 두고 문제를 해결해야겠다.

---

## 코드

```c++
//
// Created by 최우영 on 2021/09/15.
//

#include <iostream>
#include <cmath>

using namespace std;

int M, N;

bool isPrimeNumber(int targetNumber) {
    for (int i = 2; i <= sqrt(targetNumber); ++i) {
        if (targetNumber % i == 0) return false;
    }
    return true;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> M >> N;

    for (int i = M; i <= N; ++i) {
        if (i == 1) {
            continue;
        } else if (isPrimeNumber(i)) {
            cout << i << "\n";
        }
    }
}
```
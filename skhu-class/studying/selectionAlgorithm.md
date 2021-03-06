# 선택 알고리즘  
### 1. i번째 작은 값 찾기  
**Q. 정렬이 안된 배열에서 i번째 작은 값을 찾는 방법은?**    

아무리 효율적인 알고리즘이라도 n 개의 값을 한 번씩은 다 비교해야 하므로 Ω(n) 보다 효율적일 수는 없다.  
먼저 정렬하고 i번쨰 값을 고르면 되므로, O(nlogn) 보다 느릴 수도 없다.  
Ω(n) ~ O(nlogn) 범위 내에서, 가급적 효율적인 선택 알고리즘을 생각해 보자.  

[정렬 후 찾기 구현 코드 보러가기](https://github.com/hyerin6/algorithm/blob/master/algorithm2/src/select/Example1.java)  

### 2. 평균 선형시간 선택 알고리즘  
(1) 개요   
{31, 8, 65, 48, 11, 3, 20, 29, 73, 15}   
위 배열에서 6번째 작은 값을 찾아보자.  

**nth 번째 작은 값 찾기**   
quick sort 알고르즘의 partition을 이용하자.  
start = 0, end = 9, nth = 6  
partion(a, 0, 9, 6)  
  
<img width="671" alt="스크린샷 2019-04-09 오후 3 23 40" src="https://user-images.githubusercontent.com/33855307/55777651-8360af00-5adb-11e9-977b-bcfd7d3ccc52.png">
 
**재귀호출** (2구역에서 2번째 작은 값 찾기)     
<img width="795" alt="스크린샷 2019-04-09 오후 3 30 40" src="https://user-images.githubusercontent.com/33855307/55777985-932cc300-5adc-11e9-8263-1e7adf80362b.png">

**재귀호출**   
<img width="647" alt="스크린샷 2019-04-09 오후 3 31 11" src="https://user-images.githubusercontent.com/33855307/55777996-a344a280-5adc-11e9-9641-9d41992333b1.png">  
<br />

(2) 규칙 정리    
[평균 선형시간 선택 알고리즘 코드 보러가기](https://github.com/hyerin6/algorithm/blob/master/algorithm2/src/select/Example2.java)

(3) 평균 선형시간 선택 알고리즘 수행 시간    
quick sort와 마찬가지로 평균 선형시간 선택 알고리즘도 재귀적 호출할 때 마다 배열을 둘로 나눈다.    
배열의 크기가 1이 될 때까지 나누려면 logn 번 나누어야 한다.    

quickSort는 배열을 나눈 후, 나뉘어진 배열 모두를 따로 정렬하고 배열 전체를 병합한다.(배열 전체 검사)    
그래서 O(nlogn) 이다.    

그런데 평균 선형시간 선택 알고리즘은 나뉘어진 배열 중에서 한쪽 배열에서만 찾고, 다른 배열은 무시한다.    
배열의 크기가 1로 줄어들 때까지 모든 작업의 크기를 더하면 10n 이하이다.    
그래서 평균 선형시간 선택 알고리즘의 수행 시간은 O(n) 이다.    

(4) 평균 선형시간 선택 알고리즘 최악의 경우 수행 시간    
partition 작업에서 운이 없게도 언제나 최소값을 기준값으로 고른다면,  
나뉘어진 배열의 크기는 1구역의 크기 0, 2구역의 크기 n-1 일 것이다.  

평균 선형시간 선택 알고리즘의 최악의 경우 수행 시간은 O(n2) 이다.  

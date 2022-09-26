import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {        
        // int형 priorityQueue 선언 (우선순위가 높은 숫자 순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int result = 1;
        
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }
        
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) { // 현재 중요도가 root node일 때
                    if (i == location)  // 요청한 문서일 때 (중복 방지)
                        return (result);
                    result++;
                    pq.remove(); //root node를 제거
                }
            }
        }
        return (-1);
    }
}

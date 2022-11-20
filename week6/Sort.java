// Programmers Sort - H-Index

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        
        Arrays.sort(citations);  // 오름차순 정렬
        for (int i = len - 1; i >= 0; i--) {  // 뒤에서부터 (인용이 많은 논문부터)
            if (citations[i] >= len - i) // 인용수가 논문 개수보다 크거나 같을 때 까지
                answer++;                // 작으면 h번 이상 인용 h개 논문 성립 X
        }
        return answer;
    }
}
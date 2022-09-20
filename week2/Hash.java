// https://school.programmers.co.kr/learn/courses/30/lessons/42577
// 전화번호 목록

import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);   // 접두사 검사 전 phone_book을 정렬 
				
				// 정렬을 하였기 때문에 바로 뒤 전화번호만 비교해도 됨
        for (int i = 0; i < phone_book.length - 1; i++) {  // 마지막 전화번호는 검사할 필요 없음
            if (phone_book[i + 1].startsWith(phone_book[i]))
                answer = false;
        }
        return answer;
    }
}
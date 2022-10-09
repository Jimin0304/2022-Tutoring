// Programmers 깊이/너비 우선 탐색(DFS/BFS) - 타겟 넘버

class Solution {
    int answer = 0; // answer를 전역변수로 설정
    
    public int solution(int[] numbers, int target) { 
        TargetNumber_DFS(numbers, 0, 0, target);
        
        return answer;
    }
    
		// 깊이 우선 탐색
    public void TargetNumber_DFS(int[] numbers, int index, int total, int target) {
        if (index == numbers.length) { // numbers의 끝까지 왔을 때
            if (total == target) {     // 총 합이 target의 값과 같으면 answer += 1
                answer += 1;
            }
            return ;
        }
        TargetNumber_DFS(numbers, index + 1, total + numbers[index], target); // 더하기         
        TargetNumber_DFS(numbers, index + 1, total - numbers[index], target); // 뺴기
    }
}
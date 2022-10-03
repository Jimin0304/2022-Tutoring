import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int index = people.length - 1;
        int start = 0;
        
        if (limit < 80)
            return (index + 1);
        
        Arrays.sort(people);
        for (int i = index; i >= start; i--) {
            if (people[start] + people[i] <= limit) {
                start++;
            }
            answer++;
        }
        return answer;
    }
}

//Programmers 동적계획법 - 등굣길

class Solution {
    public int solution(int m, int n, int[][] puddles) {
				// 집이 있는 곳이 (1, 1)이라 [n + 1][m + 1]으로 선언
				// n이랑 m 자리 조심 (배열일 때는 반대라서 헷갈림)
        int[][] route = new int[n + 1][m + 1];

				// 물이 잠긴 곳은 -1로 표시
        for (int i = 0; i < puddles.length; i++) {
            route[puddles[i][1]][puddles[i][0]] = -1;
        }

				// 집이 있는 곳부터 1로 시작
        route[1][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
								// 물에 잠긴 곳일 때
                if(route[i][j] == -1)
                    continue;

								// 아래로 가는거
								// i == 1 이면 오른쪽으로 밖에 못가서 포함 안됨
								// 그 전에 물웅덩이가 있으면 그 길로 못가기 때문에 포함 안됨 (오른쪽으로만 가능)
                if(i > 1 && route[i - 1][j] != -1)
                    route[i][j] += route[i - 1][j] % 1000000007; // 숫자가 이 값을 초과할 수 있기 때문에 계산 과정에서 나머지 구하기

								// 오른쪽으로 가는 거
								// j == 1 이면 아래쪽으로 밖에 못가서 포함 안됨
								// 그 전에 물웅덩이가 있으면 그 길로 못가기 때문에 포함 안됨 (아래로만 가능)
                if(j > 1 && route[i][j - 1] != -1)
                    route[i][j] += route[i][j - 1] % 1000000007;
            }
        }
    return route[n][m] % 1000000007;
    }
}

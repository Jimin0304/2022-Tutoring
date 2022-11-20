// Programmers 그래프 - 가장 먼 노드

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
		// 이중 ArrayList 선언
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		// 노드는 1부터 n까지 이기 때문에 n+1만큼 int형 배열
        int[] distance = new int[n + 1];
        
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());
	      
		// 인접 리스트 
		// 양방향 리스트이기 때문에 [0]->[1], [1]->[0] 둘 다 해줌
		// edge[i][0]의 값을 읽은 후 해당 graph에 edge[i][1]을 추가
		// 예를 들어 노드 1은 노드 2와 연결되어 있기 때문에 Arraylist graph[1]에 2 추가
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
		// bfs에서 방문 여부 검사
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(1);
        
		// bfs큐 안에 원소가 없을 때까지
        while (bfs.size() != 0) {
			// nowNode는 방문한 노드 -> poll 해주고 해당 인접리스트 가져옴
            int nowNode = bfs.poll();
            ArrayList<Integer> node = graph.get(nowNode)
            for(int i = 0; i < node.size(); i++) {
				// 방문하지 않았고, nowNode와 인접했을 때
                if (visited[node.get(i)] == false) {
                    bfs.add(node.get(i));
                    visited[node.get(i)] = true;
                    distance[node.get(i)] = distance[nowNode] + 1; 
                }      
            }  
        }
        // max를 쉽게 찾기 위해서 오름차순 정렬
        Arrays.sort(distance);
        int max = distance[distance.length-1];
        for(int i = distance.length-1; distance[i] == max; i--)
            answer++;
        
        return answer;
    }
}

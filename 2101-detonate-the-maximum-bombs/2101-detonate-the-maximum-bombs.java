import java.util.*;

class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            long x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long x2 = bombs[j][0], y2 = bombs[j][1];
                
                long dx = x1 - x2;
                long dy = y1 - y2;
                if (dx * dx + dy * dy <= r1 * r1) {
                    graph.get(i).add(j);
                }
            }
        }
        
        int maxDetonated = 0;
        
        for (int i = 0; i < n; i++) {
            maxDetonated = Math.max(maxDetonated, bfs(i, graph, n));
        }
        
        return maxDetonated;
    }
    
    private int bfs(int start, List<List<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        queue.offer(start);
        visited[start] = true;
        int count = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            
            for (int neighbor : graph.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        
        return count;
    }
}
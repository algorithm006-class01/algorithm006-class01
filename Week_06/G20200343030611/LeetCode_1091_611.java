package datast.Axing;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode_1091_611 {

    class Solution {

        private int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};

        private int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};

        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
            if (n == 1) return 1;
            int[][] distance = new int[n][n];
            distance[0][0] = 1;
            int[][] visited = new int[n][n];
            Node start = new Node(0, 0, heuristic(n, 0, 0));
            Queue<Node> queue = new PriorityQueue<>();
            queue.offer(start);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int x = node.x;
                int y = node.y;
                for (int j = 0; j < 8; j++) {
                    int nextx = x + dx[j];
                    int nexty = y + dy[j];
                    if (nextx >= 0 && nextx < n && nexty >= 0 && nexty < n && grid[nextx][nexty] == 0) {
                        if (nextx == n - 1 && nexty == n - 1) return distance[x][y] + 1;
                        if (visited[nextx][nexty] != 2 || distance[nextx][nexty] > distance[x][y] + 1) {
                            distance[x + dx[j]][y + dy[j]] = distance[x][y] + 1;
                            visited[nextx][nexty] = 2;
                            Node next = new Node(x + dx[j], y + dy[j], heuristic(n, x + dx[j], y + dy[j]) + distance[x + dx[j]][y + dy[j]]);
                            queue.offer(next);
                        }
                    }
                }
            }
            return -1;
        }

        int heuristic(int n, int x, int y) {
            return Math.max(n - 1 - x, n - 1 - y);
        }

        class Node implements Comparable<Node> {
            Integer x;
            Integer y;
            Integer h;

            public Node(int x, int y, int h) {
                this.x = x;
                this.y = y;
                this.h = h;
            }

            @Override
            public int compareTo(Node o) {
                return this.h.compareTo(o.h);
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return x.equals(node.x) && y.equals(node.y);
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
    }
}

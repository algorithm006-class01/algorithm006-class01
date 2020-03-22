import java.util.*;
/*
 * @lc app=leetcode.cn id=773 lang=java
 *
 * [773] 滑动谜题
 */

// @date Mar 21 2020
// @solution bfs
// class Solution {
//     public int slidingPuzzle(int[][] board) {
//         List<Integer> b = new ArrayList<>(); 
//         Set<String> visited = new HashSet<>();
//         Queue<List<Integer>> queue = new LinkedList<>();
//         for (int r = 0; r < board.length; r ++) {
//             for (int c = 0; c < board[0].length; c ++) {
//                 b.add(board[r][c]);
//             }
//         }
//         int[][] moves = new int[][]{
//             {1, 3, -1}, {0, 2, 4}, {1, 5, -1},
//             {0, 4, -1}, {1, 3, 5}, {2, 4, -1}
//         };
//         queue.offer(b);
//         visited.add(b.toString());
//         int step = 0;
//         while(!queue.isEmpty()) {
//             for (int i = queue.size(); i > 0; i --) {
//                 b = queue.poll();
//                 System.out.println(b.toString());
//                 if (b.toString().equals("[1, 2, 3, 4, 5, 0]"))
//                     return step;
//                 int j = b.indexOf(0);
//                 for (int next : moves[j]) {
//                     if (next == -1) continue;
//                     List<Integer> _b = new ArrayList(b);
//                     _b.set(j, _b.get(next));
//                     _b.set(next, 0);
//                     if (!visited.contains(_b.toString()))
//                         queue.offer(_b);
//                     visited.add(_b.toString());
//                 }
                
//             }
//             step ++;
//         }
//         return -1;
//     }
// }

// @lc code=start
// @date Mar 21 2020
// @solutions a* 
class Solution {
    public int slidingPuzzle(int[][] board) {
        Box box = new Box(board);
        int[] endBoard = {1, 2, 3, 4, 5, 0};
        int[] wrongBoard = {1, 2, 3, 5, 4, 0};
        if (Arrays.equals(box.board, endBoard)) return 0;
        if (Arrays.equals(box.board, wrongBoard)) return -1;
        HashSet<Box> visited = new HashSet<>();
        PriorityQueue<Box> queue = new PriorityQueue<>();
        int[][] dir = {
            {1, 3}, {0, 2, 4}, {1, 5},
            {0, 4}, {1, 3, 5}, {2, 4}
        };
        queue.offer(box);
        visited.add(box);
        while (!queue.isEmpty()) {
            box = queue.poll();
            for (int nextZero : dir[box.zero]) {
                int[] nextBoard = Arrays.copyOf(box.board, 6);
                nextBoard[box.zero] = nextBoard[nextZero];
                nextBoard[nextZero] = 0;
                if (Arrays.equals(nextBoard, endBoard)) return box.step + 1;
                if (Arrays.equals(nextBoard, wrongBoard)) return -1;
                Box next = new Box(nextBoard, nextZero, box.step + 1);
                if (visited.contains(next)) continue;
                queue.offer(next);
                visited.add(next);
            }
        }
        return -1;
    }

    static class Box implements Comparable<Box> {
        int[] board;
        int zero;
        int step; // g(n)
        int distance; // h(n)
        int f; // f(n) = g(n) + h(n)

        public Box(int[][] board) {
            this.board = new int[6];
            for (int i = 0; i < 6; i++) {
                this.board[i] = board[i / 3][i % 3];
                if (this.board[i] == 0) this.zero = i;
            }
            this.step = 0;
            this.distance = calcDistance();
            this.f = this.step + this.distance;
        }

        public Box(int[] board, int zero, int step) {
            this.board = board;
            this.zero = zero;
            this.step = step;
            this.distance = calcDistance();
            this.f = this.step + this.distance;
        }

        private int calcDistance() {
            int distance = 0;
            for (int i = 0; i < 6; i++) {
                int v = board[i] - 1; // target idx of board;
                distance += Math.abs(v / 3 - i / 3) + Math.abs(v % 3 - i % 3);// row + col
            }
            return distance;
        }

        @Override
        public int compareTo(Box box) {
            return this.f - box.f;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Box)) return false;
            Box box = (Box) o;
            return zero == box.zero && Arrays.equals(board, box.board);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(zero);
            result = 31 * result + Arrays.hashCode(board);
            return result;
        }
    }
}

// @lc code=end


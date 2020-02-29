/*
     W
  S -|- N
     E
  according to the question, the robot faces north

  general case:
  use directions[direction] to caculate x,y

  North, direction = 0, directions[direction] = {0, 1}
  East,  direction = 1, directions[direction] = {1, 0}
  South, direction = 2, directions[direction] = {0, -1}
  West,  direction = 3, directions[direction] = {-1, 0}

  time conplexity: O(n+k), space complexity:O(k), n is commands array size, k is obstacles array size
*/
class Solution {
    public static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // north, east, south, west

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> obsMap = new HashSet<>();
        for (int[] o : obstacles) {
            long code = encode(o[0], o[1]);
            obsMap.add(code);
        }

        int x = 0;
        int y = 0;
        int direction = 0;
        int maxSquare = 0;

        for (int cmd : commands) {
            if (cmd == -2) { // turn left, then caculate the direction
                direction = (direction + 3) % 4; // (direction - 1) % 4 = -1 => so use (direction + 3)%4
            } else if (cmd == -1) { // turn right, then caculate the direction
                direction = (direction + 1) % 4;
            } else {
                for (int step = 0; step < cmd; step++) {
                    int nx = x + directions[direction][0]; // new x value, because if it has obstacles, remain old x value
                    int ny = y + directions[direction][1];

                    long code = encode(nx, ny);
                    if (!obsMap.contains(code)) { // no obstacles, caculate the max result
                        x = nx; // update new value
                        y = ny;
                        maxSquare = Math.max(maxSquare, x*x + y*y);
                    }
                }
            }
        }
        return maxSquare;
    }

    // encoding: access set fast!
    // enocde obstacles(x,y) to (((long)x + 300000) << 16) + (long)y + 30000
    private long encode(int x, int y) {
        return (((long)x + 300000) << 16) + (long)y + 30000;
    }
}
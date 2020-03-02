class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0, di = 0, res = 0;
        Set<String> obsSet = new HashSet<String>();
        for (int[] obs : obstacles) {
            obsSet.add(obs[0] + " " + obs[1]);
        }
        for (int cmd : commands) {
            if (cmd == -2) {
                di = (di + 3) % 4;
            } else if (cmd == -1) {
                di = (di + 1) % 4;
            } else {
                for (int k = 0; k < cmd; k++) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    if (!obsSet.contains(nx + " " + ny)) {
                        x = nx;
                        y = ny;
                        res = Math.max(res, x * x + y * y);
                    }
                }
            }
        }
        return res;
    }
}

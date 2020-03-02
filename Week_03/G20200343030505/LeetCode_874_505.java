
class LeetCode_874_505 {
    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands == null || obstacles == null) {
            return 0;
        }

        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        int x = 0, y = 0, di = 0;
        Set<Long> obStatus = new HashSet<Long>();
        for (int[] arr:obstacles) {
            long nx = (long)arr[0] + 30000;
            long ny = (long)arr[1] + 30000;
            obStatus.add((nx << 16) + ny);
        }

        int ans = 0;
        for (int co:commands) {
            if (co == -1) {
                di = (di + 1)%4;
            } else if (co == -2) {
                di = (di + 3)%4;
            } else {
                for (int i=0;i<co;++i) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long)nx + 30000)<<16) + ((long)ny + 30000);
                    if (!obStatus.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x*x + y*y);
                    }
                }
            }
        }

        return ans;
    }
}
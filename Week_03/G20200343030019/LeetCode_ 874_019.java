class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int direction = 0;
        Set<Long> set = new HashSet();
        for (int index = 0; index < obstacles.length; index ++) {
            set.add(((long)obstacles[index][0] << 16) + obstacles[index][1]);
        }
        int[] position = new int[2];
        int max = 0;
        for (int index = 0; index < commands.length; index ++) {
            if (commands[index] < 0) {
                direction = changeDirection(direction, commands[index]);
                continue;
            }
            int x = run(position, direction, commands[index], set);
            max = x > max? x: max;
        }
        return max;
    }

    private int run(int[] position, int direction, int step, Set<Long> obstacles) {
        for (int index = 1; index <= step; index ++) {
            oneStep(position, direction, 1);
            if (obstacles.contains(((long)position[1] << 16) + position[0])){
                oneStep(position, direction, -1);
                return position[0] * position[0] + position[1] * position[1];
            }
        }
        return position[0] * position[0] + position[1] * position[1];
    }

    private void oneStep(int[] position, int direction, int step) {
        if (direction == 0) {
            position[0] += step;
            return;
        }
        if (direction == 1) {
            position[1] += step;
            return;
        }
        if (direction == 2) {
            position[0] -= step;
            return;
        }
        if (direction == 3) {
            position[1] -= step;
            return;
        }
    }

    private int changeDirection(int cur, int action) {
        if (action == -1) {
            return (cur + 1) % 4;
        } else if (action == -2) {
            return (cur + 3) % 4;
        }
        return cur;
    }
}
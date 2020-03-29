class Solution {
    class Union {
        int[] elements;

        public Union(int capacity) {
            elements = new int[capacity];
            for (int i = 1; i < capacity; i ++) {
                elements[i] = i;
            }
        }

        public int findRoot(int i) {
            while(elements[i] != i) {
                elements[i] = elements[elements[i]];
                i = elements[i];
            }
            return i;
        }

        public void union(int i, int j) {
            i = findRoot(i);
            j = findRoot(j);
            elements[j] = i;
        }

        public int groupSum() {
            int sum = 0;
            for (int i = 0; i < elements.length; i ++) {
                if (elements[i] == i) sum ++;
            }
            return sum;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        Union union = new Union(grid.length * grid[0].length);
        int h = grid.length;
        int l = grid[0].length;
        int seaSum = 0;
        for (int i = 0; i < h; i ++) {
            for (int j = 0; j < l; j ++) {
                if(grid[i][j] == '1') {
                    for (int x = 0; x < 4; x ++) {
                        int index = findLand(grid, i, j, x);
                        if (index > -1) union.union(index, i * l + j);
                    }
                } else seaSum ++;
            }
        }
        return union.groupSum() - seaSum;
    }

    int[] xOffset = new int[]{-1, 0, 1, 0};
    int[] yOffset = new int[]{0, 1, 0, -1};
    private int findLand(char[][] grid, int i, int j, int f) {
        i = i + xOffset[f];
        j = j + yOffset[f];
        if (i >= 0 && j >= 0 && j < grid[0].length && i < grid.length && grid[i][j] == '1') {
            return i * grid[0].length + j;
        }
        return -1;
    }
}
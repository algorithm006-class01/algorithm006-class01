class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        Union person = new Union(M.length);
        for (int i = 1; i < M.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (M[i][j] == 1) {
                    person.union(i, j);
                }
            }
        }

        return person.groupSum();
    }

    class Union {
        int[] elements;

        public Union(int capacity) {
            elements = new int[capacity];
            for (int i = 1; i < capacity; i ++) {
                elements[i] = i;
            }
        }

        public int findRoot(int i) {
            while (elements[i] != i) {
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

}
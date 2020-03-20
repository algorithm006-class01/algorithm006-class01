package week6.friend_circles;

public class Solution {
    int[] disjoint;
    public int findCircleNum(int[][] M) {
        disjoint = new int[M.length];
        for (int n=0;n<M.length;n++){
            disjoint[n]=-1;
        }
        for (int y=0;y<M.length;y++){
            for (int x=0;x<M[0].length;x++){
                if (M[y][x]==1 && x!=y){
                    merge(x,y);
                }
            }
        }
        int max = 0;
        for (int n=0;n<disjoint.length;n++){
            if (disjoint[n]==-1){
                max++;
            }
        }
        return max;
    }

    public int find(int x){
        if (disjoint[x] == -1) {
            return x;
        }else{
            disjoint[x]=find(disjoint[x]);
            return disjoint[x];
        }
    }

    public void merge(int x,int y){
       int xs = find(x);
       int ys = find(y);
       if (xs != ys){
           disjoint[xs] = ys;
       }
    }

    public static void main(String[] args) {
        int aaa[][] = {
                {1, 1, 1, 0, 1, 1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0, 1, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1}
        };
        /*int aaa[][] = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };*/
        Solution s = new Solution();
        System.out.println(s.findCircleNum(aaa));
    }
}

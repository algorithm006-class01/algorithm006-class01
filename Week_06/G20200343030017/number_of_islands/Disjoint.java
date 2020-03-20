package week6.number_of_islands;

public class Disjoint {
    int[] parent;
    int[] rank;
    int count;

    public Disjoint(int n){
        this.count=n;
        parent = new int[n];
        rank = new int[n];
        for (int t=0;t<n;t++){
            parent[t]=t;
        }
        for (int t=0;t<n;t++){
            rank[t]=1;
        }
    }
    public int find(int x){
        while(x!=parent[x]){
            parent[x]=parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void merge(int x,int y){
        int xs = find(x);
        int ys = find(y);
        if (xs == ys){
            return;
        }
        if (rank[xs]>rank[ys]){
            parent[ys]=xs;
        }else if(rank[xs]<rank[ys]){
            parent[xs]=ys;
        }else{
            parent[ys]=xs;
            rank[xs]+=1;
        }
        count -= 1;
    }
}

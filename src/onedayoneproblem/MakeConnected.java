package onedayoneproblem;

import java.util.Arrays;

public class MakeConnected {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
            return -1;

        UnionFind uf=new UnionFind(n);
        for (int[] connection:connections){
            uf.union(connection[0],connection[1]);
        }


        return uf.getCount()-1;
    }

    class UnionFind{
        int count;
        int[] parent;
        int[] size;
        public UnionFind(int n){
            this.count=n;
            parent=new int[n];
            size=new int[n];
            Arrays.fill(size,1);
            for(int i=0;i<n;i++)
                parent[i]=i;
        }

        public void union(int x,int y){
            int rootX=find(x);
            int rootY=find(y);
            if (rootX==rootY)
                return;
            if (size[rootX]>size[rootY]){
                parent[rootY]=rootX;
                size[rootX]+=size[rootY];
            }else {
                parent[rootX]=rootY;
                size[rootY]+=size[rootX];
            }
            count--;

        }
        public int find(int x){
            while (x!=parent[x]){
                parent[x]=parent[parent[x]];
                x=parent[x];
            }
            return x;
        }
        public boolean connected(int x,int y){
            return find(x)==find(y);
        }

        public int getCount(){
            return count;
        }
    }
}

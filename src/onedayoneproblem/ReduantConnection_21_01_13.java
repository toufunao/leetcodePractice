package onedayoneproblem;

public class ReduantConnection_21_01_13 {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind=new UnionFind(edges.length);
        for (int[] edge:edges){
            if (unionFind.isConnected(edge[0],edge[1]))
                return edge;
            else
                unionFind.union(edge[0],edge[1]);
        }
        return new int[0];
    }

    public class UnionFind{
        int count;
        int[] size;
        int[] parent;

        public UnionFind(int n) {
            this.count = n;
            size=new int[n+1];
            parent=new int[n+1];

            for (int i=0;i<n+1;i++){
                parent[i]=i;
                size[i]=1;
            }
        }

        public void union(int p,int q){
            int rootP=find(p);
            int rootQ=find(q);
            if (rootP==rootQ)
                return;

            if (size[rootP]>size[rootQ]){
                parent[rootQ]=rootP;
                size[rootP]+=size[rootQ];
            }else {
                parent[rootP]=rootQ;
                size[rootQ]+=size[rootP];
            }
            count--;
        }

        public int find(int p) {
            while (parent[p]!=p){
                parent[p]=parent[parent[p]];
                p=parent[p];
            }
            return p;
        }

        public boolean isConnected(int p,int q){
            return find(p)==find(q);
        }

        public int getCount(){
            return count;
        }
    }
}

package onedayoneproblem;

import java.util.Arrays;

public class EnsureAbleToTraverse {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufa=new UnionFind(n);
        UnionFind ufb=new UnionFind(n);
        int ans=0;

        //节点编号从0开始
        for (int[] edge:edges){
            edge[1]--;
            edge[2]--;
        }

        //公共边
        for (int[] edge:edges){
            if (edge[0]==3){
                if (!ufa.union(edge[1],edge[2])){
                    ans++;
                }else {
                    ufb.union(edge[1],edge[2]);
                }
            }
        }

        //私有边
        for (int[] edge:edges){
            if (edge[0]==1){
                //alice独占边
                if(!ufa.union(edge[1],edge[2])){
                    ans++;
                }
            }else if(edge[0]==2){
                if (!ufb.union(edge[1],edge[2]))
                    ans++;
            }
        }

        if (ufa.getCount()!=1|| ufb.getCount()!=1)
            return -1;

        return ans;
    }

    class UnionFind{
        int count;
        int[] parent;
        int[] size;
        public UnionFind(int n){
            count=n;
            parent=new int[n];
            size=new int[n];
            Arrays.fill(size,1);
            for (int i=0;i<n;i++)
                parent[i]=i;
        }

        public boolean union(int x,int y){
            int rootX=find(x);
            int rootY=find(y);
            if (rootX==rootY)
                return false;
            if (size[rootX] > size[rootY]) {
                parent[rootY]=rootX;
                size[rootY]+=size[rootX];
            }else {
                parent[rootX]=rootY;
                size[rootX]+=size[rootY];
            }
            count--;
            return true;
        }


        public int find(int x) {
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

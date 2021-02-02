package onedayoneproblem;

import java.util.*;

public class MinEffortPath {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        List<int[]> edges=new ArrayList<>();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int id=i*n+j;
                if (i>0)
                    //i,j的下一行和i，j的差值
                    edges.add(new int[]{id-n,id,Math.abs(heights[i-1][j]-heights[i][j])});
                if(j>0)
                    //i,j的后一个与i,j的差值
                    edges.add(new int[]{id-1,id,Math.abs(heights[i][j-1]-heights[i][j])});
            }
        }
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        UnionFind unionFind=new UnionFind(m*n);
        int ans=0;
        for (int[] edge:edges){
            int x=edge[0];
            int y=edge[1];
            int v=edge[2];
            unionFind.unite(x,y);
            if (unionFind.connected(0,m*n-1)){
                return v;
            }
        }
        return 0;

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
        public boolean unite(int x,int y){
            int rootX=find(x);
            int rootY=find(y);
            if(rootX==rootY)
                return false;

            if (size[rootX]>size[rootY]){
                parent[rootY]=rootX;
                size[rootX]+=size[rootY];
            }else {
                parent[rootX]=rootY;
                size[rootY]+=size[rootX];
            }
            count--;
            return true;
        }

        private int find(int x) {
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

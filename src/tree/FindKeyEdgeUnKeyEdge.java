package tree;

import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindKeyEdgeUnKeyEdge {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int len=edges.length;
        int[][] newEdge=new int[len][4];
        for (int i=0;i<len;i++){
            for (int j=0;j<3;j++){
                newEdge[i][j]=edges[i][j];
            }
            newEdge[i][3]=i;
        }

        Arrays.sort(newEdge, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        UnionFind unionFind=new UnionFind(n);
        for (int i=0;i<len;i++){
            unionFind.union(newEdge[i][0],newEdge[i][1]);
        }
        int value=0;
        for (int[] edge:newEdge){
            if (unionFind.isConnected(edge[0],edge[1]))
                value+=edge[2];
        }

        List<List<Integer>> ans=new ArrayList<>();
        for (int i=0;i<2;i++){
            ans.add(new ArrayList<>());
        }



        for (int i=0;i<len;i++){
            UnionFind uf=new UnionFind(n);
            int v=0;
            for (int j=0;j<n;j++)
                uf.union(newEdge[j][0],newEdge[j][1]);
            for (int j=0;j<n;j++){
                if (uf.isConnected(newEdge[j][0],newEdge[j][1]))
                    v+=newEdge[j][2];
            }

            if (uf.getCount()!=1||(uf.getCount()==1&&v>value)){
                ans.get(0).add(newEdge[i][3]);
                continue;
            }


            uf=new UnionFind(n);
            uf.union(newEdge[i][0],newEdge[i][1]);
            v=edges[i][2];
            for (int j=0;j<len;j++){

                if (i!=j&&uf.isConnected(newEdge[j][0],newEdge[j][1]))
                    v+=newEdge[j][2];
            }
            if (v==value)
                ans.get(1).add(newEdge[i][3]);
        }
        return ans;
    }
    class UnionFind{
        int count;
        int[] parent;
        int[] size;

        public UnionFind(int n){
            this.count=n;
            parent=new int[n];
            size=new int[n];
            for (int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }

        public void union(int x,int y){
            int rootX=find(x);
            int rootY=find(y);
            if (size[rootX]>size[rootY]){
                parent[rootY]=rootX;
                size[rootX]+=size[rootY];
            }else {
                parent[rootX]=rootY;
                size[rootY]+=size[rootX];
            }
            count--;
        }

        public boolean isConnected(int x,int y){
            return find(x)==find(y);
        }

        private int find(int x) {
            while (x!=parent[x]){
                parent[x]=parent[parent[x]];
                x=parent[x];
            }
            return x;
        }

        public int getCount(){
            return count;
        }
    }
}

package onedayoneproblem;

import javax.xml.stream.events.EntityDeclaration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinCostLinkPoints {
    public int minCostConnectPoints(int[][] points){
        int n=points.length;
        UnionFind unionFind=new UnionFind(n);
        List<Edge> edges=new ArrayList<>();
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                edges.add(new Edge(distance(points,i,j),i,j));
            }
        }
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.len-e2.len;
            }
        });
        int total=0;
        int count=0;

        for (Edge edge:edges){
            int len=edge.len;
            int x=edge.x;
            int y=edge.y;
            if (!unionFind.isConnected(x,y)){
                unionFind.union(x,y);
                total+=len;
                count++;
                if (count==n-1)
                    break;
            }
        }
        return total;
    }

    public int distance(int[][] points,int x,int y){
        return Math.abs(points[x][0]-points[y][0])+Math.abs(points[x][1]-points[y][1]);
    }

    class Edge{
        int len,x,y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }

    class UnionFind{
        int count;
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            this.count = n;
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

        private int find(int x) {
            while (x!=parent[x]){
                parent[x]=parent[parent[x]];
                x=parent[x];
            }
            return x;
        }

        public boolean isConnected(int x,int y){
            return find(x)==find(y);
        }
    }
}

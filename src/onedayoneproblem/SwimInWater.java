package onedayoneproblem;

import java.util.Arrays;

public class SwimInWater {
    //解法同mineffortpath题
    private int N;

    public static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        this.N = grid.length;

        int len = N * N;
        // 下标：方格的高度，值：对应在方格中的坐标
        int[] index = new int[len];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                index[grid[i][j]] = getIndex(i, j);
            }
        }

        UnionFind unionFind = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            int x = index[i] / N;
            int y = index[i] % N;

            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && grid[newX][newY] <= i) {
                    unionFind.unite(index[i], getIndex(newX, newY));
                }

                if (unionFind.connected(0, len - 1)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int getIndex(int x, int y) {
        return x * N + y;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
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

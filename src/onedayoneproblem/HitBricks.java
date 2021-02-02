package onedayoneproblem;

public class HitBricks {
    private int rows;
    private int cols;
    public static final int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        this.rows=grid.length;
        this.cols=grid[0].length;

        //1.击碎grid中的全部砖块
        int[][] copy=new int[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                copy[i][j]=grid[i][j];
            }
        }

        for (int[] hit:hits){
            copy[hit[0]][hit[1]]=0;
        }


        //2.建图，把砖块和砖块的连接关系输入并查集
        int size=rows*cols;
        UnionFind unionFind=new UnionFind(size+1); //1表示屋顶
        //第一行与屋顶相连
        for (int j=0;j<cols;j++){
            if (copy[0][j]==1){
                unionFind.union(j,size);
            }
        }

        for (int i=1;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (copy[i][j]==1){
                    if (copy[i-1][j]==1){
                        unionFind.union(getIndex(i-1,j),getIndex(i,j));
                    }
                    if (j>0&&copy[i][j-1]==1){
                        unionFind.union(getIndex(i,j-1),getIndex(i,j));
                    }
                }
            }
        }

        //3. 逆序补回砖块
        int hitSize=hits.length;
        int[] res=new int[hitSize];
        for (int i = hitSize-1; i >= 0; i--) {
            int x=hits[i][0];
            int y=hits[i][1];

            if (grid[x][y]==0)
                continue;

            int origin=unionFind.getSize(size);
            //补回砖块
            if (x==0){
                unionFind.union(y,size);
            }

            for (int[] direction:directions){
                int newX=x+direction[0];
                int newY=y+direction[1];

                if (inArea(newX,newY) && copy[newX][newY]==1){
                    unionFind.union(getIndex(x,y),getIndex(newX,newY));
                }
            }


            int current=unionFind.getSize(size);

            res[i]=Math.max(0,current-origin-1);
            copy[x][y]=1;
        }

        return res;
    }

    private boolean inArea(int x, int y) {

        return x>=0&&x<rows&&y>=0&&y<cols;
    }

    //将二维坐标转换为一维
    int getIndex(int x,int y){
        return x*cols+y;
    }

    class UnionFind{
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size=new int[n];
            for (int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }

        public int find(int x){
           if (x!=parent[x])
               parent[x]=find(parent[x]);

           return parent[x];
        }

        public void union(int p,int q){
            int rootP=find(p);
            int rootQ=find(q);

            if (rootP==rootQ)
                return;
            parent[rootP]=rootQ;
            size[rootQ]+=size[rootP];
        }

        public int getSize(int x) {
            int root=find(x);
            return size[root];
        }
    }
}

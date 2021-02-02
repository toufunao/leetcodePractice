package onedayoneproblem;

import java.util.Arrays;

public class SplitRegion {
    public int regionsBySlashes(String[] grid) {
        int N=grid.length;
        int size=4*N*N;

        UnionFind unionFind=new UnionFind(size);
        for (int i=0;i<N;i++){
            char[] row=grid[i].toCharArray();
            for (int j=0;j<N;j++){
                //二维表格转换为一维表格
                int index=4*(i*N+j);

                char c=row[j];
                if (c=='/'){
                    //合并0，3，合并1，2
                    unionFind.union(index,index+3);
                    unionFind.union(index+1,index+2);
                }else if (c=='\\'){
                    //合并0，1，合并2，3
                    unionFind.union(index,index+1);
                    unionFind.union(index+2,index+3);
                }else {
                    unionFind.union(index,index+1);
                    unionFind.union(index+1,index+2);
                    unionFind.union(index+2,index+3);
                }

                //单元格间合并
                //向右合并：1（当前） 3（右一侧）
                if (j+1<N){
                    unionFind.union(index+1,4*(i*N+j+1)+3);
                }
                //向下合并：2（当前） 0（下一行
                // ）
                if (i+1<N){
                    unionFind.union(index+2,4*((i+1)*N+j));
                }
            }
        }
        return unionFind.getCount();
    }
    class UnionFind{
        int count;
        int[] parent;
        int[] size;
        public  UnionFind(int n){
            this.count=n;
            parent=new int[n];
            size=new int[n];
            Arrays.fill(size,1);
            for (int i=0;i<n;i++)
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

        public int find(int x) {
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

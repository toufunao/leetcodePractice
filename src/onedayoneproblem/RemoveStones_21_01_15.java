package onedayoneproblem;

import java.util.HashMap;
import java.util.Map;

public class RemoveStones_21_01_15 {
    public int removeStones(int[][] stones) {
        UnionFind unionFind=new UnionFind();

        for (int[] stone:stones){
            unionFind.union(stone[0]+10001,stone[1]);
        }

        return stones.length-unionFind.getCount();
    }

    public class UnionFind{
        Map<Integer,Integer> parent;

        int count;

        public UnionFind() {
            parent=new HashMap<>();
            count = 0;
        }

        public void union(int p,int q){
            int rootP=find(p);
            int rootQ=find(q);
            if (rootP==rootQ)
                return;

            parent.put(rootP,rootQ);
            count--;

        }

        private int find(int x) {
            if (!parent.containsKey(x)){
                parent.put(x,x);
                count++;
            }
            if (x!=parent.get(x)){
                parent.put(x,find(parent.get(x)));
            }

            return parent.get(x);
        }

        public boolean isConnected(int p,int q){
            return find(p)==find(q);
        }

        public int getCount(){
            return count;
        }
    }
}

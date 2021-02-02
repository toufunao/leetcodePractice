package onedayoneproblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SwitchItemInString_21_01_11 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] array=s.toCharArray();
        int length=s.length();

        //建立索引的连通分量
        UnionFind unionFind=new UnionFind(length);
        for (List<Integer> list:pairs){
           int i=list.get(0);
           int j=list.get(1);
           unionFind.union(i,j);
        }


        //建立索引及对应字符的映射关系
        Map<Integer, PriorityQueue<Character>> map=new HashMap<>();
        for (int i=0;i<length;i++){
            char t=array[i];
            int root= unionFind.findRoot(i);
            if (map.containsKey(root)){
                map.get(root).add(t);
            }else {
                PriorityQueue<Character> priorityQueue=new PriorityQueue<>();
                priorityQueue.add(t);
                map.put(root,priorityQueue);
            }
        }

        //建立串
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<length;i++){
            int root= unionFind.findRoot(i);
            stringBuilder.append(map.get(root).poll());
        }

        return stringBuilder.toString();
    }

    public class UnionFind{
        private int count;
        private int[] parent;
        private int[] size;
        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            size=new int[n];
            for (int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }

        public void union(int p,int q){
            int rootP= findRoot(p);
            int rootQ= findRoot(q);
            if (rootP==rootQ)
                return;

            if (size[rootP]<size[rootQ]){
                parent[rootP]=rootQ;
                size[rootQ]+=size[rootP];
            }else {
                parent[rootQ]=rootP;
                size[rootP]+=size[rootQ];
            }
            count--;
        }

        public int findRoot(int p) {
            while (parent[p]!=p){
                parent[p]=parent[parent[p]];
                p=parent[p];
            }
            return p;
        }

        public boolean isConnected(int p,int q){
            int rootP= findRoot(p);
            int rootQ= findRoot(q);

            return rootP==rootQ;
        }

        public int getCount(){
            return count;
        }
    }
}

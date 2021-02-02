package onedayoneproblem;

import java.util.Arrays;

public class SimilarStrings_839 {
    public int numSimilarGroups(String[] strs) {

        int n = strs.length;

        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (unionFind.connected(i, j))
                    continue;
                if (isSimilar(strs[i], strs[j]))
                    unionFind.union(i, j);
            }
        }

        return unionFind.getCount();
    }

    public boolean isSimilar(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (s1 == s2)
            return true;
        if (n1 != n2)
            return false;

        int num = 0;
        for (int i = 0; i < n1; i++) {

            if (s1.charAt(i) != s2.charAt(i)){
                num++;
                if (num > 2)
                    return false;
            }
        }
        return true;
    }

    class UnionFind {
        int count;
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY)
                return;

            if (size[rootX] > size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
            count--;
        }

        private int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        public int getCount() {
            return count;
        }
    }
}

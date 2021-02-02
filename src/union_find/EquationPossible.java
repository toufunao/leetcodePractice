package union_find;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;

public class EquationPossible {
    public boolean equationsPossible(String[] equations) {
        Union union=new Union(26);

        for (String equation:equations){
            if (equation.charAt(1)=='='){
                int x=equation.charAt(0)-'a';
                int y=equation.charAt(3)-'a';
                union.union(x,y);
            }
        }

        for (String eq:equations){
            if (eq.charAt(1)=='!'){
                int x=eq.charAt(0)-'a';
                int y=eq.charAt(3)-'a';

                if (union.connected(x,y))
                    return false;
            }
        }

        return true;
    }
    class Union{
        private int count;

        private int[] parent;

        private int[] size;

        public Union(int count) {
            this.count = count;
            parent=new int[count];
            size=new int[count];
            for (int i=0;i<count;i++){
                parent[i]=i;
                size[i]=1;
            }
        }

        public void union(int p,int q){
            int rootp=find(p);
            int rootq=find(q);

            if (rootp==rootq)
                return;

            if (size[rootp]>size[rootq]){
                parent[rootq]=rootp;
                size[rootp]+=size[rootq];
            }else {
                parent[rootp]=rootq;
                size[rootq]+=size[rootp];
            }
            count--;
        }

        public boolean connected(int p,int q){
            int rootp=find(p);
            int rootq=find(q);

            return rootp==rootq;
        }

        private int find(int x) {
            while (parent[x]!=x){
                parent[x]=parent[parent[x]];
                x=parent[x];
            }
            return x;
        }

        public int count(){
            return count;
        }
    }
}

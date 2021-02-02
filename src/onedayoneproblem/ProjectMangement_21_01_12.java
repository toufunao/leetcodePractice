package onedayoneproblem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ProjectMangement_21_01_12 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<List<Integer>> groupItem=new ArrayList<>();
        for (int i=0;i<n+m;i++)
            groupItem.add(new ArrayList<>());
        int gId=m;
        for (int i=0;i<group.length;i++){
            if (group[i]==-1){
                group[i]=gId;
                gId++;
            }
            groupItem.get(group[i]).add(i);
        }
        List<List<Integer>> graphInGroup=new ArrayList<>();
        List<List<Integer>> graphBetweenGroup=new ArrayList<>();

        for (int i=0;i<m+n;i++){
            graphBetweenGroup.add(new ArrayList<>());
            if (i>=n)
                continue;
            graphInGroup.add(new ArrayList<>());
        }

        List<Integer> groupId=new ArrayList<>();
        for (int i=0;i<n+m;i++){
            groupId.add(i);
        }

        int[] degreeInGroup=new int[n];
        int[] degreeBetweenGroup=new int[n+m];

        for (int i=0;i<beforeItems.size();i++){
            int curGroupId=group[i];                          //当前项目i所处小组的id
            List<Integer> beforeItem=beforeItems.get(i);       //该项目需要满足的前驱关系
            for (Integer item:beforeItem){
                if (group[item]==curGroupId){                  //如果在同一组
                    degreeInGroup[i]++;
                    graphInGroup.get(item).add(i);
                }else {
                    degreeBetweenGroup[curGroupId]++;
                    graphBetweenGroup.get(group[item]).add(curGroupId);
                }
            }
        }

        List<Integer> betweenGroupTopSort=topSort(degreeBetweenGroup,groupId,graphBetweenGroup);//组间拓扑排序
        if (betweenGroupTopSort.size()==0)
            return new int[0];

        int[] res=new int[n];
        int index=0;
        for (Integer gid:betweenGroupTopSort){
            List<Integer> items=groupItem.get(gid);
            if (items.size()==0)
                continue;

            List<Integer> inGroupTopSort=topSort(degreeInGroup,groupItem.get(gid),graphInGroup);
            if (inGroupTopSort.size()==0)
                return new int[0];

            for (int item:inGroupTopSort){
                res[index]=item;
                index++;
            }
        }
        return res;
    }

    private List<Integer> topSort(int[] degree, List<Integer> groupId, List<List<Integer>> graph) {
        Queue<Integer> queue=new ArrayDeque<>();
        for (Integer item:groupId){
            if (degree[item]==0)
                queue.offer(item);
        }

        List<Integer> ans=new ArrayList<>();
        while (!queue.isEmpty()){
            int t=queue.poll();
            ans.add(t);
            for (int neighbor:graph.get(t)){
                degree[neighbor]--;
                if (degree[neighbor]==0)
                    queue.offer(neighbor);
            }
        }
        if (groupId.size()==ans.size())
            return ans;
        else
            return new ArrayList<>();
    }
}

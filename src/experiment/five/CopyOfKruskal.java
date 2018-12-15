package experiment.five;

import java.util.*;

public class CopyOfKruskal {
    private Set<String> points=new HashSet<String>();
    private List<Edge> treeEdges=new ArrayList<Edge>();
    public void buildTree(){
        MapBuilder builder=new MapBuilder();
        TreeSet<Edge> edges=builder.build();
        int pointNum=builder.getPointNum();
        for(Edge edge:edges){
            if(isCircle(edge)){
                continue;
            }else{//没有出现回路,将这条边加入treeEdges集合
                treeEdges.add(edge);
                //如果边数等于定点数-1,则遍历结束
                if(treeEdges.size()==pointNum-1){
                    return;
                }
            }
        }
    }
    public void printTreeInfo(){
        int totalDistance=0;
        for(Edge edge:treeEdges){
            totalDistance+=edge.getDistance();
            System.out.println(edge.toString());
        }
        System.out.println("总路径长度:"+totalDistance);
    }
    private boolean isCircle(Edge edge){
        int size=points.size();
        if(!points.contains(edge.getStart())){
            size++;
        }
        if(!points.contains(edge.getEnd())){
            size++;
        }
        if(size==treeEdges.size()+1){
            return true;
        }else{
            points.add(edge.getStart());
            points.add(edge.getEnd());
            return false;
        }
    }

    public static void main(String[] args) {
        CopyOfKruskal test=new CopyOfKruskal();
        test.buildTree();
        test.printTreeInfo();
    }
}


class Edge implements Comparable<Edge>{
    private String start;
    private String end;
    private int distance;
    public Edge(String start,String end,int distance){
        this.start=start;
        this.end=end;
        this.distance=distance;
    }
    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    @Override
    public String toString() {
        return start + "->" + end;
    }
    @Override
    public int compareTo(Edge obj) {
        int targetDis=obj.getDistance();
        return distance>targetDis?1:(distance==targetDis?0:-1);
    }
}


class MapBuilder {
    public TreeSet<Edge> build(){
        TreeSet<Edge> edges=new TreeSet<Edge>();
        edges.add(new Edge("0","1",34));
        edges.add(new Edge("0","4",12));
        edges.add(new Edge("1","5",19));
        edges.add(new Edge("4","5",26));
        edges.add(new Edge("1","2",46));
        edges.add(new Edge("2","5",25));
        edges.add(new Edge("2","3",17));
        edges.add(new Edge("3","5",25));
        edges.add(new Edge("3","4",38));
        return edges;
    }
    public int getPointNum(){
        return 6;
    }
}



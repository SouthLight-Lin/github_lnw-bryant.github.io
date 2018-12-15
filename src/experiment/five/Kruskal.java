package experiment.five;

import com.sun.org.glassfish.gmbal.Description;
import util.MinHeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 最小生成树
 * 使用Kruskal算法
 * @author LNW
 */
public class Kruskal {

    public static void main(String[] args) {
        EdgeNode e1 = new EdgeNode(0,1,34);
        EdgeNode e2 = new EdgeNode(0,4,12);
        EdgeNode e3 = new EdgeNode(1,5,19);
        EdgeNode e4 = new EdgeNode(4,5,26);
        EdgeNode e5 = new EdgeNode(1,2,46);
        EdgeNode e6 = new EdgeNode(2,5,25);
        EdgeNode e7 = new EdgeNode(2,3,17);
        EdgeNode e8 = new EdgeNode(3,5,25);
        EdgeNode e9 = new EdgeNode(3,4,38);
        int n=6;
        int e = 9;
        ArrayList<EdgeNode> E = new ArrayList<>(e);
        E.add(e1);
        E.add(e2);
        E.add(e3);
        E.add(e4);
        E.add(e5);
        E.add(e6);
        E.add(e7);
        E.add(e8);
        E.add(e9);
//        int n=6;
//        int e = 10;
//        EdgeNode e1=new EdgeNode(1,2,6);
//        EdgeNode e2=new EdgeNode(1,3,1);
//        EdgeNode e3=new EdgeNode(1,4,5);
//        EdgeNode e4=new EdgeNode(2,3,5);
//        EdgeNode e5=new EdgeNode(3,4,5);
//        EdgeNode e6=new EdgeNode(2,5,3);
//        EdgeNode e7=new EdgeNode(3,5,6);
//        EdgeNode e8=new EdgeNode(5,6,6);
//        EdgeNode e9=new EdgeNode(3,6,4);
//        EdgeNode e10=new EdgeNode(4,6,2);
//        ArrayList<EdgeNode> E = new ArrayList<>(e);
//        E.add(e10);
//        E.add(e9);
//        E.add(e8);
//        E.add(e7);
//        E.add(e6);
//        E.add(e5);
//        E.add(e4);
//        E.add(e3);
//        E.add(e2);
//        E.add(e1);
        EdgeNode[] t = new EdgeNode[e];
        kruskal(n,e,E,t);
    }

    static class EdgeNode implements Comparable{
        float weight;
        int u,v;
        EdgeNode(int uu,int vv,float ww){
            u = uu;
            v = vv;
            weight = ww;
        }
        @Override
        public int compareTo(Object o) {
            double xw = ((EdgeNode) o).weight;
            if (weight<xw){
                return -1;
            }
            if (weight == xw){
                return 0;
            }
            return 1;
        }
    }


    public static class FastUnionFind {
        private int[] id; // 分量id（以触点作为索引）
        private int count; // 分量数量

        public FastUnionFind(int N) {
            count = N;
            id = new int[N];
            // 初始化分量id数组
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
        }

        public int count() {
            return count;
        }
        /**
         *判断两个数是否属于同一个集合
         */
        public boolean connected(int a, int b) {
            return find(a) == find(b);
        }

        /*
         * 找到某个节点中的元素
         */
        private int find(int a) {
            return id[a];
        }

        /*
         * 连接两个节点，把index较小者作为flag
         */
        private void union(int a, int b) {
            //注意：这里不仅仅要修改id[a]或者id[b]的值，而是需要修改所有该集合中的值！！
            if(find(a)!=find(b)){
                if(a<=b)
                    for(int i=0;i<id.length;i++){
                        if(id[i]==id[b])
                            id[i]=a;
                    }
                else
                    for(int i=0;i<id.length;i++){
                        if(id[i]==id[a])
                            id[i]=b;
                    }
                count--;
            }else{
                return;
            }


        }

    }

    public static boolean kruskal(int n, int e, List E, EdgeNode[] t){
        MinHeap H = new MinHeap(1);
        H.initialize(E,e);
        FastUnionFind U = new FastUnionFind(n);
        int k = 0;
        while (e>0 && k<n-1){
            EdgeNode x = (EdgeNode) H.pop();
            e--;
            int a = U.find(x.u);
            int b = U.find(x.v);
            if (a!=b){
                t[k++] = x;
                U.union(a,b);
            }
        }
        for(int i = 0; i < k; i++){
            System.out.println("顶点："+t[i].u+"； 顶点："+t[i].v+"; 长度："+t[i].weight);
        }
        return (k==n-1);
    }
}
//public class Kruskal {
//
//    /**
//     *
//     * @ClassName: FastUnionFind
//     * @Description:  由连通分支组成的集合为U，包括union（a，b）；和find（v）的基本运算
//     * @date 2017-6-1 上午9:50:11
//     *
//     */
//    public static class FastUnionFind {
//        public int[] u;  //数组用来保存顶点所属的集合，用数字表示
//        public FastUnionFind(int n){
//            u = new int[n + 1];
//            for(int i = 1; i <= n; i++){ //初始化顶点数组值
//                u[i] = i;
//            }
//        }
//        public int find(int x){ //找到顶点所属的集合
//            return u[x];
//        }
//
//        public void union(int x, int y){ //将第二个顶点归入第一个顶点集合
//            u[y] = u[x];
//        }
//    }
//
//    public static class EdgeNode implements Comparable{
//        float weight; //边权值
//        int  u, v; //边的左右顶点
//
//        /**
//         *
//         * <p>Title: </p>
//         * <p>Description:构造函数 </p>
//         * @param u
//         * @param v
//         * @param weight
//         */
//        public EdgeNode(int u, int v, float weight){
//            this.u = u;
//            this.v = v;
//            this.weight = weight;
//        }
//
//        /**
//         * 按照边的权值升序排列
//         */
//        @Override
//        public int compareTo(Object x){
//            float xw = ((EdgeNode)x).weight;
//            if(weight < xw)
//                return -1;
//            if(weight == xw)
//                return 0;
//            return 1;
//        }
//    }
//
//    /**
//     *
//     * @Title: kruskal
//     * @Description: kruskal算法
//     * @param n 所有顶点的数目
//     * @param E 边的集合（所有的边）
//     * @param t 保存逐步连通的边
//     * @return  是否生成了最小生成树
//     * @return boolean
//     * @throws
//     */
//    public static boolean kruskal(int n, LinkedList<EdgeNode> E, EdgeNode[] t){
//        FastUnionFind U = new FastUnionFind(n);
//        int k = 0;
//        while(k < n-1){  //n个顶点，n-1条边
//            EdgeNode x = E.peek();
//            int a = U.find(x.u);  //边的左顶点所属的集合
//            int b = U.find(x.v);  //边的右顶点所属集合
//            if(a != b){
//                t[k++] = x;
//                U.union(a, b);
//            }
//            E.pop();
//        }
//        for(int i = 0; i < k; i++){
//            System.out.println("顶点："+t[i].u+"； 顶点："+t[i].v+"; 长度："+t[i].weight);
//        }
//        return (k == n-1);
//    }
//    /**
//     * @Title: main
//     * @Description: TODO
//     * @param args
//     * @return void
//     * @throws
//     */
//    public static void main(String[] args) {
//        EdgeNode e1 = new EdgeNode(0,1,34);
//        EdgeNode e2 = new EdgeNode(0,4,12);
//        EdgeNode e3 = new EdgeNode(1,5,19);
//        EdgeNode e4 = new EdgeNode(4,5,26);
//        EdgeNode e5 = new EdgeNode(1,2,46);
//        EdgeNode e6 = new EdgeNode(2,5,25);
//        EdgeNode e7 = new EdgeNode(2,3,17);
//        EdgeNode e8 = new EdgeNode(3,5,25);
//        EdgeNode e9 = new EdgeNode(3,4,38);
//
//
//
//
//        int n=6;
////        EdgeNode e1=new EdgeNode(1,2,6);
////        EdgeNode e2=new EdgeNode(1,3,1);
////        EdgeNode e3=new EdgeNode(1,4,5);
////        EdgeNode e4=new EdgeNode(2,3,5);
////        EdgeNode e5=new EdgeNode(3,4,5);
////        EdgeNode e6=new EdgeNode(2,5,3);
////        EdgeNode e7=new EdgeNode(3,5,6);
////        EdgeNode e8=new EdgeNode(5,6,6);
////        EdgeNode e9=new EdgeNode(3,6,4);
////        EdgeNode e10=new EdgeNode(4,6,2);
//        LinkedList<EdgeNode> E=new LinkedList<EdgeNode>();
//        E.add(e10);
//        E.add(e9);
//        E.add(e8);
//        E.add(e7);
//        E.add(e6);
//        E.add(e5);
//        E.add(e4);
//        E.add(e3);
//        E.add(e2);
//        E.add(e1);
//        Collections.sort(E);
//        EdgeNode[] t=new EdgeNode[n];
//        kruskal(n,E,t);
//    }
//}

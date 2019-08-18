import java.util.Arrays;

/**
 * 稠密图--邻接矩阵
 */
public class DenseGraph {

    int n; // 节点个数
    int m; // 边的个数
    boolean directed; // 是否是有向图
    boolean[][] g; // 邻接矩阵

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        g = new boolean[n][n];
        Arrays.fill(g, false);
    }

    public int V() {
        return n;
    }
    public int E () {
        return m;
    }
}
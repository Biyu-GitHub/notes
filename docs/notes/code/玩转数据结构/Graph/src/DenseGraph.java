import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Vector;

/**
 * 稠密图--邻接矩阵
 */
public class DenseGraph implements Graph {

    int n; // 节点个数
    int m; // 边的个数
    boolean directed; // 是否是有向图
    boolean[][] g; // 邻接矩阵

    //  构造函数
    public DenseGraph(int n, boolean directed) {
        assert n > 0;
        this.n = n;
        this.m = 0; // 初始情况没有任何边
        this.directed = directed;

        g = new boolean[n][n];
    }

    // 返回节点个数
    @Override
    public int V() {
        return n;
    }

    // 返回边的个数
    @Override
    public int E() {
        return m;
    }

    // 向图中添加一个边
    @Override
    public void addEdge(int v, int w) {
        if (hasEdge(v, w))
            return;

        g[v][w] = true;

        // 如果是无向图，则需要添加另一个方向上的边
        if (!directed)
            g[w][v] = true;

        m++;
    }

    // 验证图中是否有从v到w的边
    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }

    // 返回图中一个顶点V的所有邻边
    @Override
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<>();
        for (int i = 0; i < n; i++) {
            if (g[v][i])
                adjV.add(i);
        }
        return adjV;
    }

    @Override
    public void show() {

        // 打印表头
        System.out.print(" \t");
        for (int j = 0; j < n; j++)
            System.out.print(j + "\t");
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print( i + "\t");
            for (int j = 0; j < n; j++) {
                if (g[i][j])
                    System.out.print(1 + "\t");
                else
                    System.out.print(0 + "\t");
            }

            System.out.println();
        }
    }
}
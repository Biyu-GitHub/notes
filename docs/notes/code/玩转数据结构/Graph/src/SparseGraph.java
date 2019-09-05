import java.util.Vector;

/**
 * 稀疏图 -- 邻接表
 */
public class SparseGraph implements Graph {
    private int n;
    private int m;
    private boolean directed;
    private Vector<Integer>[] g;

    // 构造函数
    public SparseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;

        g = new Vector[n]; // TODO

        for (int i = 0; i < n; i++) {
            g[i] = new Vector<>();
        }
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

    // 向图中添加一个边，判断平行边的开销很高，所以这里我们不去判断
    @Override
    public void addEdge(int v, int w) {

        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        g[v].add(w);

        // v = w 的时候为自环边
        if (v != w && !directed)
            g[w].add(v);

        m++;
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    @Override
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }

    @Override
    // 判断两个节点之间是否有边
    public boolean hasEdge(int v, int w) {

        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for (int i = 0; i < g[v].size(); i++)
            if (g[v].elementAt(i) == w)
                return true;
        return false;
    }

    @Override
    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.print("vertex " + i + ":\t");
            for (int j = 0; j < g[i].size(); j++) {
                System.out.print(g[i].elementAt(j) + "\t");
            }
            System.out.println();
        }
    }
}

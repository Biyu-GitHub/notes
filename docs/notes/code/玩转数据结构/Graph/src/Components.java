import java.util.Arrays;

/**
 * 求无权图的联通分量
 */
public class Components {

    Graph G;                      // 图的引用
    private boolean[] visited; // 记录dfs的过程中节点是否被访问
    private int ccount;         // 记录联通分量个数
    private int[] id;           // 每个节点所对应的联通分量标记

    // 构造函数, 求出无权图的联通分量
    public Components(Graph graph) {

        G = graph;
        visited = new boolean[G.V()];
        id = new int[G.V()];
        ccount = 0;

        Arrays.fill(visited, false);
        Arrays.fill(id, -1);

        for (int i = 0; i < G.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        id[v] = ccount;

        for (int i : G.adj(v)) {
            dfs(i);
        }
    }

    // 返回图的联通分量个数
    int count() {
        return ccount;
    }

    // 查询点v和点w是否联通
    boolean isConnected(int v, int w) {
        assert v >= 0 && v < G.V();
        assert w >= 0 && w < G.V();
        return id[v] == id[w];
    }
}

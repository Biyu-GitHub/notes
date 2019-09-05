import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException {

        String filename1 = Main.class.getResource("/testG1.txt").toURI().getPath();
        String filename2 = Main.class.getResource("/testG2.txt").toURI().getPath();

        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename1);
        System.out.println("test G1 in Sparse Graph:");
        g1.show();

        DenseGraph g2 = new DenseGraph(13, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename1);
        System.out.println("test G1 in Dense Graph:");
        g2.show();

        SparseGraph g3 = new SparseGraph(6, false);
        ReadGraph readGraph3 = new ReadGraph(g3, filename2);
        System.out.println("test G3 in Sparse Graph:");
        g3.show();

        DenseGraph g4 = new DenseGraph(6, false);
        ReadGraph readGraph4 = new ReadGraph(g4, filename2);
        System.out.println("test G4 in Dense Graph:");
        g4.show();
    }
}

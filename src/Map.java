import java.io.*;
import java.util.ArrayList;

public class Map {
    private String fileName;
    private Graph graph;

    public Map(String fileName) {
        this.fileName = fileName;
        makeGraph();
    }

    private void makeGraph() {
        File file = new File(fileName);
        String[] strings;
        int size;
        Vertex v1, v2;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            size = Integer.valueOf(reader.readLine());
            graph = new Graph(size);
            for (int i = 0; i < size; i++) {
                strings = reader.readLine().split(" ");
                v1 = graph.getVertex(i);
                for (int j = i; j < size; j++) {
                    v2 = graph.getVertex(j);
                    if (Integer.valueOf(strings[j]) == 1) {
                        v1.addToNeighbors(v2);
                        v2.addToNeighbors(v1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Vertex[] getColoredMap() {
        graph.getVertex(0).setColor(graph.getColor(0));
        graph.m_coloring(0);
        return graph.getVertices();
    }

    public int getNumberOfColors() {
        ArrayList<Integer> colors = new ArrayList<>();
        for (Vertex vertex : graph.getVertices()) {
            if (!colors.contains(vertex.getColor())) {
                colors.add(vertex.getColor());
            }
        }
        return colors.size();
    }
}
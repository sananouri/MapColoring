import java.util.ArrayList;

public class Vertex {
    private int key;
    private ArrayList<Vertex> neighbors;
    private int color;

    public Vertex(int key) {
        this.key = key;
        neighbors = new ArrayList<>();
        color = 0;
    }

    public void addToNeighbors(Vertex v) {
        neighbors.add(v);
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isNeighborOf(Vertex v) {
        return neighbors.contains(v);
    }

    public int getColor() {
        return color;
    }

    public int getKey() {
        return key;
    }
}

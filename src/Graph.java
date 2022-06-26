import java.util.ArrayList;

public class Graph {
    private int size;
    private Vertex[] vertices;
    private ArrayList<Integer> colors;

    public Graph(int size) {
        this.size = size;
        setVertices();
        initializeColors();
    }

    private void setVertices() {
        vertices = new Vertex[size];
        for (int i = 0; i < size; i++) {
            vertices[i] = new Vertex(i + 1);
        }
    }

    private void initializeColors() {
        colors = new ArrayList<>();
        colors.add(1);
    }

    public int getColor(int index) {
        return colors.get(index);
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public Vertex getVertex(int index) {
        return vertices[index];
    }

    public void m_coloring(int index) {
        if (promising(index)) {
            if (index == size - 1) {
                return;
            }
            for (int color = 1; color <= colors.size(); color++) {
                vertices[index + 1].setColor(color);
                m_coloring(index + 1);
                if (promising(size - 1)) {
                    return;
                }
            }
        } else {
            boolean colorsAreNotEnough = true;
            for (int i = 1; i < index; i++) {
                if (vertices[i].getColor() != colors.size()) {
                    colorsAreNotEnough = false;
                    break;
                }
            }
            if (colorsAreNotEnough) {
                colors.add(colors.size() + 1);
            }
        }
    }

    private boolean promising(int index) {
        Vertex v1 = vertices[index], v2;
        for (int i = 0; i < index; i++) {
            v2 = vertices[i];
            if ((v1.isNeighborOf(v2) && v1.getColor() == v2.getColor()) || v1.getColor() == 0) {
                return false;
            }
        }
        return true;
    }
}


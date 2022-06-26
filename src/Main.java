import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the address of the file containing map: ");
        String fileName = scanner.next();
        Map map = new Map(fileName);
        Vertex[] coloredMap = map.getColoredMap();
        System.out.println(map.getNumberOfColors() + " colors needed.");
        for (Vertex vertex : coloredMap) {
            System.out.println("District " + vertex.getKey() + ": C" + vertex.getColor());
        }
    }
}

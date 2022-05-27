package CHC5223.PartB;

public class Main {

    public static void main(String[] args) {
        AdjacentMatrix.LoadStations loader = new AdjacentMatrix.LoadStations();
        loader.loadFile();
        AdjacentMatrix aMatrix = new AdjacentMatrix(loader.getMatrix(),loader.getStationInfos());
        System.out.println("Station Infos:" );
        aMatrix.printStation();
        System.out.println("adjacent Matrix:");
        aMatrix.print();
        System.out.println("Dijkstra Algorithm:");
        aMatrix.Dijkstra(0);
        System.out.println("\nBroad First Search:");
        aMatrix.breadthFirstSearch(0);
        System.out.println("\n\nDepth First Search:");
        aMatrix.depthFirstSearch(0);
    }
}



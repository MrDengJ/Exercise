package CHC5223.PartB;

import java.io.*;

public class AdjacentMatrix {
    public final double NO_LINK = -1;
    public int numStations;
    public StationInfo[] infos;
    public double[][] distance;

    public AdjacentMatrix(double[][] matrix, StationInfo[] stationInfos) {//
        this.distance = matrix;
        this.infos = stationInfos;
        this.numStations = stationInfos.length;

        for (int i = 0; i < this.numStations; i++) {
            for (int j = 0; j < this.numStations; j++) {
                if (this.distance[i][j] > 0 && this.distance[i][j] != this.distance[j][i]) {
                    this.distance[j][i] = this.distance[i][j];
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < numStations; i++) {
            for (int j = 0; j < numStations; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printStation() {
        for (int i = 0; i < this.numStations; i++) {
            System.out.println(infos[i].getName() + ": " + infos[i].getxPos() + " " + infos[i].getyPos());

        }
    }

    public void Dijkstra(int index) {
        double[] weights = new double[this.numStations];
        for (int i = 0; i < this.numStations; i++) {//
            weights[i] = Integer.MAX_VALUE;
        }
        weights[index] = 0;
        QueueInt queue = new QueueInt(10);
        queue.addToBack(index);
        while (queue.size != 0) {
            int current = queue.removefromFront();
            for (int i = 0; i < this.numStations; i++) {
                if (distance[current][i] != NO_LINK && weights[i] > weights[current] + distance[current][i]) {
                    weights[i] = weights[current] + distance[current][i];
                    queue.addToBack(i);
                }
            }
        }
        System.out.println("specify the starting point as: " + infos[index].getName());
        for (int i = 0; i < this.numStations; i++) {
            if (i != index) {
                ListInt nodesInPath = new ListInt();
            System.out.println("The shortest path from " + infos[index].getName() + " to " + infos[i].getName() + " is: ");
                for (int idx = 0; idx < nodesInPath.getSize(); idx++) {
                    int j = nodesInPath.list[idx];
                    System.out.print(infos[j].getName() + " ");
                }
            }
        }

    }




    public void depthFirstSearch(int index) {
        assert index >= 0 && index < numStations;
        StackInt S = new StackInt();
        ListInt L = new ListInt();
        S.push(index);
        L.append(index);
        System.out.println(infos[index].getName());
        while (S.size != 0) {
            int current = S.pop();
            for (int i = 0; i < infos.length; i++) {
                if (!L.contains(i) && distance[current][i] != NO_LINK) {
                    S.push(i);
                    L.append(i);
                    System.out.println(infos[i].getName());
                }
            }
        }
    }


   public void breadthFirstSearch(int index) {
        assert index >= 0 && index < numStations;
       QueueInt Q = new QueueInt();
       ListInt L = new ListInt();
       Q.addToBack(index);
       L.append(index);
       System.out.println(infos[index].getName());
       while (Q.size != 0) {
           int current = Q.removefromFront();
           for (int i = 0; i < infos.length; i++) {
               if (!L.contains(i) && distance[current][i] != NO_LINK) {
                   Q.addToBack(i);
                   L.append(i);
                   System.out.println(infos[i].getName());
               }
           }
       }
    }

    static class LoadStations {

    private StationInfo[] stationInfos;//
    private double[][] matrix = null;//adjacent matrix
    private int count;//number of stations

    public LoadStations() {
        stationInfos = new StationInfo[1024];
        count = 0;
    }

    public StationInfo[] getStationInfos() {//getter
        if(stationInfos.length > count){//if there are more stations than the count
            StationInfo[] infos = new StationInfo[count];//create a new array of the size of the count
            for(int i = 0 ; i < count ; i++){//for each index in the new array
                infos[i] = stationInfos[i];//set the new array to the old array
            }
            this.stationInfos = infos;
        }
        return stationInfos;
    }

    public void setMatrix(int y, int x, double value) {//setter
        assert y >= 0 && y < count;
        if (this.matrix == null) {//if the matrix is null
            this.matrix = new double[count][count];//create a new array of the size of the count
            for (int i = 0; i < count; i++)//for each index in the matrix
                for (int j = 0; j < count; j++)//set all the values to NO_LINK
                    this.matrix[i][j] = -1;//set all values to -1
        }
        this.matrix[y][x] = value;//set the value of the matrix
    }

    public double[][] getMatrix() {
        return matrix;
    }

    private int findIndex(String name) {//find the index of the station
        for (int i = 0; i < count; i++) {//for each index in the array
            if (stationInfos[i].getName().equals(name)) {//if the name is the same
                return i;//return the index
            }
        }
        return -1;
    }

    public void loadFile() {
        try {
            File file = new File("C:\\Users\\12545\\Desktop\\coursework2 (2)\\coursework2\\Station.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            for  (int i = 0; i < 8; i++) {
                line = bufferedReader.readLine();
                String[] split = line.split("\\s+");
                StationInfo info = new StationInfo(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]));
                stationInfos[count] = info;
                count++;
            }
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("\\s+");
                int index1 = findIndex(split[1]);
                int index2 = findIndex(split[2]);
                setMatrix(index1, index2, Double.parseDouble(split[3]));
            }
            fileReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
}



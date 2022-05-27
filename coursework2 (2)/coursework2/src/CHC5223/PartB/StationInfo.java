package CHC5223.PartB;

public class StationInfo implements IStationInfo{
    private String name;
    private int x;
    private int y;  //x and y coordinates of the station

    public StationInfo(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getxPos() {
        return this.x;
    }

    @Override
    public int getyPos() {
        return this.y;
    }

}







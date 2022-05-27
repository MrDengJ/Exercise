package CHC5223.PartA;

public class Member implements IMember {
    public String name;
    public String Affiliation;


    public Member(String name,String Affiliation){
        this.name = name;
        this.Affiliation = Affiliation;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAffiliation() {
        return Affiliation;
    }

    @Override
    public String toString(){
        return String.format("%s,%s",this.name,this.Affiliation);
    }




}



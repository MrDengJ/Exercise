package CHC5223.PartB;

public class ListInt extends AbsListInt{

    public ListInt() {super(1024);}

    public ListInt(int capacity) {
        super(capacity);//  calls the super class constructor
    }

    @Override
    public void append(int n) {// adds a number to the end of the list
        if(this.size >= this.capacity){//if the list is full
            throw new IllegalStateException("List is full");//throw an exception
        }
        this.list[this.size] = n;//add the number to the list
        this.size++;//increment the size
    }

    @Override
    public boolean contains(int x) {// checks if the list contains the number
        for(int i = 0 ; i < this.size ; i++){//for each number in the list
            if(this.list[i] == x)//if the number is equal to the number
                return true;
        }
        return false;
    }

}

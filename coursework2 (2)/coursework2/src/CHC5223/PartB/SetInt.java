package CHC5223.PartB;

public class SetInt extends AbsSetInt{

    public SetInt(){
        super(1024);
    }
    public SetInt(int capacity) {
        super(capacity);
    }

    @Override
    public boolean contains(int x) {//returns true if x is in the set, false otherwise
        assert this.size <= this.capacity;
        for (int i = 0; i < this.size; i++) {//loops through the set
            if (this.set[i] == x) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void include(int n) {//adds n to the set if it is not already in the set
        assert this.size <= this.capacity;
        if (this.size >= this.capacity) {
            throw new IllegalStateException("Set is full");
        }
        if (!this.contains(n)) {
            this.set[this.size] = n;
            this.size++;
        }
    }

    @Override
    public void exclude(int n) {//removes n from the set if it is in the set
        assert this.size <= this.capacity;
        if (this.size <= 0) {
            throw new IllegalStateException("Set is empty");
        }
        for (int i = 0; i < this.size; i++) {
            if (this.set[i] == n) {
                this.set[i] = this.set[this.size - 1];
                this.size--;
                return;
            }
        }
    }

    public int getSmallest() {
        if (this.size <= 0) {
            throw new IllegalStateException("Set is empty");
        }
        int smallest = this.set[0];
        for (int i = 1; i < this.size; i++) {
            if (this.set[i] < smallest) {
                smallest = this.set[i];
            }
        }
        return smallest;
    }

    public int getMin(double[] distance) {
        if (this.size <= 0) {
            throw new IllegalStateException("Set is empty");
        }
        int min = this.set[0];
        double minDistance = distance[min];
        for (int i = 1; i < this.size; i++) {
            if (distance[this.set[i]] < minDistance) {
                min = this.set[i];
                minDistance = distance[min];
            }
        }
        return min;
    }
}



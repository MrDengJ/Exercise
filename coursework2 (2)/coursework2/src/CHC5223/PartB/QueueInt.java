package CHC5223.PartB;

public class QueueInt extends AbsQueueInt{

    public QueueInt() {
        super(1024);
    }

    public QueueInt(int capacity) {
        super(capacity);
    }

    @Override
    public void addToBack(int n) {//add to back
        if (this.size == this.capacity)
            throw new IllegalStateException("Queue is full");
        this.queue[this.size++] = n;
    }

    @Override
    public int removefromFront() {  //remove from front
        if (this.size <= 0)
            throw new IllegalStateException("Queue is empty");
        int n = this.queue[0];
        for (int i = 0; i < this.size - 1; i++) {//shift all elements to the left
            this.queue[i] = this.queue[i + 1];
        }
        this.size--;
        return n;
    }


    public boolean isEmpty() {
        return this.size == 0;
    }
}


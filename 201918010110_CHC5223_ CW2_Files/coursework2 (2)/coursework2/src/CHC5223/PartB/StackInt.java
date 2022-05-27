package CHC5223.PartB;

public class StackInt extends AbsStackInt{

    public StackInt() {
        super(1024);
    }

    public StackInt(int capacity) {
        super(capacity);
    }

    @Override
    public void push(int n) {
        if(this.size == this.capacity) {
            throw new StackOverflowError("Stack is full");
        }
        this.stack[this.size] = n;
        this.size++;
    }

    @Override
    public int pop() {
        if(this.size == 0) {
            throw new StackOverflowError("Stack is empty");
        }
        this.size--;
        return this.stack[this.size];
    }

    @Override
    public int peek() {//
        if(this.size == 0) {
            throw new StackOverflowError("Stack is empty");
        }
        return this.stack[this.size - 1];
    }

}

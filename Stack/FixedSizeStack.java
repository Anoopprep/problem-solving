package Stack;

class FixedSizeStack{
    private int[] array;
    private int size;
    private int top;

    public FixedSizeStack(int size){
        this.size = size;
        this.array = new int[this.size];
        this.top = -1;
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top == size-1;
    }

    public void peek(){
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println(this.array[top]);
    }

    public void push(int ele){
        if(isFull()){
            System.out.println("Stack is full");
            return;
        }

        this.array[++top] = ele;
        this.printArray();
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Ntg to pop");
            return -1;
        }
        else{
            int ele = this.array[top--];
            System.out.print("Popped: " + ele + ", stack: ");
            printArray();
            return ele;
        }
    }

    private void printArray(){
        for (int i=0; i<=top; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

class StackDemo{
    public static void main(String[] args){
        FixedSizeStack s = new FixedSizeStack(5);
        System.out.println(s.isEmpty());
        System.out.println(s.isFull());
        s.peek();
        s.push(1);
        s.pop();
        s.pop();
        s.push(1);
        s.push(2);
        s.push(3);
        s.peek();
        s.push(4);
        s.push(5);
        s.peek();
        s.push(6);
        s.peek();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.peek();
    }
}

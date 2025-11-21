package Stack;

import java.util.Arrays;

class DynamicSizedStack{
    private int[] array;
    private int top;

    public DynamicSizedStack(){
        this.array = new int[5];
        this.top = -1;
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top == array.length-1;
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
            resize();
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
        // Maybe if top is 1/4th of total array or half of total array, instead of wasting memory just 
        // resize
    }

     private void resize() {
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array, newCapacity);
        // No need for casting because Arrays.copyOf preserves type
        // Or create an array and manually add elemetns which is o(n)
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
        DynamicSizedStack s = new DynamicSizedStack();
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
        s.push(7);
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
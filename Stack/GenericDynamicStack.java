package Stack;

import java.util.ArrayList;

public class GenericDynamicStack<T> {
    private ArrayList<T> array;
    private int top;

    public GenericDynamicStack(){
        this.array = new ArrayList<T>(5);
        this.top = -1;
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top == array.size()-1;
    }

    public void peek(){
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println(this.array.get(top));
    }

    public void push(T ele){
        this.array.add(++top, ele);
        System.out.println(array);
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("Ntg to pop");
            return null;
        }
        else{
            T ele = this.array.get(top--);
            System.out.print("Popped: " + ele + ", stack: ");
            System.out.println(array);
            return ele;
        }
        // Maybe if top is 1/4th of total array or half of total array, instead of wasting memory just 
        // resize
    }
}

class StackDemo{
    public static void main(String[] args){
        // GENERICS ONLY WORK WITH OBJECTS NOT PRIMITIVES IN JAVA
        GenericDynamicStack<Integer> s = new GenericDynamicStack<Integer>();
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

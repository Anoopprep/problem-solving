// Time Complexity: O(n^2) in the worst and average cases, O(n) in the best case (when the array is already sorted).
// Space Complexity: O(1) as it is an in-place sorting algorithm.
// When to use bubble sort: when the array is nearly sorted, as it can finish in O(n) time in that case.
// After every iteration, elements are placed at correct positions at the end.

import java.util.Arrays;
import java.util.Comparator;

class BubbleSort {
    static class Student {
        String name;
        int marks;

        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    public static <T> T[] bubbleSort(T[] arr, Comparator<T> comparator) {
        for(int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(comparator.compare(arr[j], arr[j+1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        return arr;
    }
   public static void main(String[] args) {
    Integer[] arr = new Integer[]{2,4,2,1,4,6,8};
    System.out.println(Arrays.toString(bubbleSort(arr, (a, b) -> a - b ))); // Arrays.toString does not create a new array
    System.out.println(Arrays.toString(bubbleSort(arr, (a, b) -> b - a )));

    String[] arr2 = new String[]{"cat", "dog", "apple", "ear", "ball"};
    System.out.println(Arrays.toString(bubbleSort(arr2, (a, b) -> a.compareTo(b))));
    System.out.println(Arrays.toString(bubbleSort(arr2, (a, b) -> b.compareTo(a))));

    Student[] students = {
        new Student("Charlie", 90),
        new Student("Alice", 90),
        new Student("Bob", 85),
        new Student("David", 80)
    };

    Student[] result = bubbleSort(students, (a, b) -> a.marks - b.marks);
    for (Student s: result) {
        System.out.println(s.name + ", " + s.marks);
    }

    System.out.println();
    // sort by marks, if marks are same, sort by name
    result = bubbleSort(students, (a, b) -> {
        int res = b.marks - a.marks;
        if(res == 0) return a.name.compareTo(b.name);
        return res;
    });
    for (Student s: result) {
        System.out.println(s.name + ", " + s.marks);
    }
   } 
}

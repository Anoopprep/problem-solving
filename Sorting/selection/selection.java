// Time Complexity: O(n^2)
// Space Complexity: O(1)
// Just the brute force algorithm for sorting, which mostly is never used.
// After every iteration, elements are placed at correct positions at the beginning.

import java.util.Arrays;
import java.util.Comparator;

class SelectionSort {
    static class Student {
        String name;
        int marks;

        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    public static <T> T[] selectionSort(T[] arr, Comparator<T> comparator) {
        for(int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for(int j = i+1; j < arr.length; j++) {
                if(comparator.compare(arr[min], arr[j]) > 0) min = j;
            }
            if (min != i) {
                T temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2,4,2,1,4,6,8};
        System.out.println(Arrays.toString(selectionSort(arr, (a, b) -> a - b )));
        System.out.println(Arrays.toString(selectionSort(arr, (a, b) -> b - a )));

        String[] arr2 = new String[]{"cat", "dog", "apple", "ear", "ball"};
        System.out.println(Arrays.toString(selectionSort(arr2, (a, b) -> a.compareTo(b))));
        System.out.println(Arrays.toString(selectionSort(arr2, (a, b) -> b.compareTo(a))));

        Student[] students = {
            new Student("Charlie", 90),
            new Student("Alice", 90),
            new Student("Bob", 85),
            new Student("David", 80)
        };

        Student[] result = selectionSort(students, (a, b) -> a.marks - b.marks);
        for (Student s: result) {
            System.out.println(s.name + ", " + s.marks);
        }

        System.out.println();
        // sort by marks, if marks are same, sort by name
        result = selectionSort(students, (a, b) -> {
            int res = b.marks - a.marks;
            if(res == 0) return a.name.compareTo(b.name);
            return res;
        });
        for (Student s: result) {
            System.out.println(s.name + ", " + s.marks);
        }
    }
}
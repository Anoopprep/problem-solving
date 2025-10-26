/**
 * Comparator always tells to swap 2 elements, when its return value is > 0.
 * If its <= 0, swap won't happen
 * when we say a-b, it means, a is greater than b, which makes a-b > 0. So in case of sort ascending,
 * a-b tells to swap the elements
 */

function bubbleSort<T> (arr: Array<T>, comparator: (a: T, b: T) => number): Array<T> {
    for (let i = 0; i < arr.length - 1; i++) {
        let swapped = false;
        for (let j = 0; j < arr.length - i - 1; j++) {
            if(comparator(arr[j], arr[j+1]) > 0) {
                let temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                swapped = true;
            }
        }
        if(!swapped) break;
    }
    return arr;
}

console.log(bubbleSort<number>([5, 2, 5, 1, 6, 4], (a, b) => a - b));
console.log(bubbleSort<number>([5, 2, 5, 1, 6, 4], (a, b) => b - a));
console.log(bubbleSort<string>(['cat', 'dog', 'apple', 'ear', 'ball'], (a, b) => a.localeCompare(b)));
console.log(bubbleSort<string>(['cat', 'dog', 'apple', 'ear', 'ball'], (a, b) => b.localeCompare(a)));

const students = [
    {
        name: 'A',
        marks: 20,
    },
    {
        name: 'B',
        marks: 10,
    },
    {
        name: 'C',
        marks: 30,
    }
]

console.log(bubbleSort(students, (a, b) => a.marks - b.marks));
console.log(bubbleSort(students, (a, b) => b.marks - a.marks));
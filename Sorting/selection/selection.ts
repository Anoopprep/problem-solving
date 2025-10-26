function selectionSort<T>(arr: Array<T>, comparator: (a: T, b: T) => number) {
    for (let i = 0; i < arr.length - 1; i++) {
        let min = i;
        for (let j = i+1; j < arr.length; j++) {
            if(comparator(arr[min], arr[j]) > 0) min = j;
        }
        if (min !== i) {
            let temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    return arr;
}

console.log(selectionSort<number>([5, 2, 5, 1, 6, 4], (a, b) => a - b));
console.log(selectionSort<number>([5, 2, 5, 1, 6, 4], (a, b) => b - a));
console.log(selectionSort<string>(['cat', 'dog', 'apple', 'ear', 'ball'], (a, b) => a.localeCompare(b)));
console.log(selectionSort<string>(['cat', 'dog', 'apple', 'ear', 'ball'], (a, b) => b.localeCompare(a)));

const students1 = [
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

console.log(selectionSort(students1, (a, b) => a.marks - b.marks));
console.log(selectionSort(students1, (a, b) => b.marks - a.marks));
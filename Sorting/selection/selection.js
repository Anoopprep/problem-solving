function selectionSort(arr, comparator) {
    for (var i = 0; i < arr.length - 1; i++) {
        var min = i;
        for (var j = i + 1; j < arr.length; j++) {
            if (comparator(arr[min], arr[j]) > 0)
                min = j;
        }
        if (min !== i) {
            var temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    return arr;
}
console.log(selectionSort([5, 2, 5, 1, 6, 4], function (a, b) { return a - b; }));
console.log(selectionSort([5, 2, 5, 1, 6, 4], function (a, b) { return b - a; }));
console.log(selectionSort(['cat', 'dog', 'apple', 'ear', 'ball'], function (a, b) { return a.localeCompare(b); }));
console.log(selectionSort(['cat', 'dog', 'apple', 'ear', 'ball'], function (a, b) { return b.localeCompare(a); }));
var students1 = [
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
];
console.log(selectionSort(students1, function (a, b) { return a.marks - b.marks; }));
console.log(selectionSort(students1, function (a, b) { return b.marks - a.marks; }));

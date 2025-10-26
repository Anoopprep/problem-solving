/**
 * Comparator always tells to swap 2 elements, when its return value is > 0.
 * If its <= 0, swap won't happen
 * when we say a-b, it means, a is greater than b, which makes a-b > 0. So in case of sort ascending,
 * a-b tells to swap the elements
 */
function bubbleSort(arr, comparator) {
    for (var i = 0; i < arr.length - 1; i++) {
        var swapped = false;
        for (var j = 0; j < arr.length - i - 1; j++) {
            if (comparator(arr[j], arr[j + 1]) > 0) {
                var temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }
        if (!swapped)
            break;
    }
    return arr;
}
console.log(bubbleSort([5, 2, 5, 1, 6, 4], function (a, b) { return a - b; }));
console.log(bubbleSort([5, 2, 5, 1, 6, 4], function (a, b) { return b - a; }));
console.log(bubbleSort(['cat', 'dog', 'apple', 'ear', 'ball'], function (a, b) { return a.localeCompare(b); }));
console.log(bubbleSort(['cat', 'dog', 'apple', 'ear', 'ball'], function (a, b) { return b.localeCompare(a); }));
var students = [
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
console.log(bubbleSort(students, function (a, b) { return a.marks - b.marks; }));
console.log(bubbleSort(students, function (a, b) { return b.marks - a.marks; }));

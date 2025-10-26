// You start with the first card (element) in your hand — it’s “sorted” by itself.
// You then take the next card and insert it into the correct position relative to the cards already in your hand.
// You repeat this for all cards.
function insertionSort(arr, comparator) {
    for (var i = 1; i < arr.length; i++) {
        var key = arr[i];
        var j = i - 1;
        while (j >= 0 && comparator(arr[j], key) > 0) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
    return arr;
}
console.log(insertionSort([5, 2, 5, 1, 6, 4], function (a, b) { return a - b; }));
console.log(insertionSort([5, 2, 5, 1, 6, 4], function (a, b) { return b - a; }));
console.log(insertionSort(['cat', 'dog', 'apple', 'ear', 'ball'], function (a, b) { return a.localeCompare(b); }));
console.log(insertionSort(['cat', 'dog', 'apple', 'ear', 'ball'], function (a, b) { return b.localeCompare(a); }));

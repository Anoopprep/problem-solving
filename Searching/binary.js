function binary(arr, target) {
    var i = 0, j = arr.length - 1;
    while (i <= j) {
        var mid = Math.floor((i + j) / 2);
        if (arr[mid] === target)
            return mid;
        if (target < arr[mid])
            j = mid - 1;
        else
            i = mid + 1;
    }
    return -1;
}
console.log(binary([3, 4, 5, 6, 7, 8, 9], 9));

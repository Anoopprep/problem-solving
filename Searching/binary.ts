// Only for sorted arrays
// Given a sorted array and asked to find a target in the array, try using binary search
// or modified binary search to get the solution in O(logn)
// mid = low + (high - low) / 2; do this to avoid overflow, this will avoid overflow because it's value will always be less than the size of the array

function binary(arr: Array<number>, target: number) {
    let i = 0, j = arr.length - 1;
    while (i <= j) {
        let mid = Math.floor((i+j)/2);
        if(arr[mid] === target) return mid;
        if(target < arr[mid]) j = mid - 1;
        else i = mid + 1;
    }
    return -1
}


console.log(binary([3,4,5,6,7,8,9], 9));

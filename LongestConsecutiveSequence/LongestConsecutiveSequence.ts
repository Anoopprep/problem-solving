var longestConsecutive = function (nums: number[]) {
    if(nums.length == 0) return 0
    let s = new Set(nums)

    let max = 1

    for (let num of s) {
        if(!s.has(num-1)) {
            let nextNum = num + 1
            let currCount = 1
            while (s.has(nextNum)) {
                currCount++
                nextNum++
                max = Math.max(max, currCount)
            }
        }
    }

    return max
};
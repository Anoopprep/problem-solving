function groupAnagrams(strs: string[]): string[][] {
    let res: Record<string, Array<string>> = {};
    for(let i = 0; i < strs.length; i++) {
        let str = strs[i];
        let freq = new Array(26).fill(0);
        for(let j = 0; j < str.length; j++) {
            freq[str[j].charCodeAt(0) - 97]++;
        }
        let signature = freq.join(',');
        if(res[signature] === undefined) {
            res[signature] = [str];
        } else res[signature].push(str);
    }
    return Object.values(res);
};
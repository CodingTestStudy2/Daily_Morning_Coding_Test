/**
 * @param {number[]} nums
 * @return {number[]}
 */
var minBitwiseArray = function(nums) {
    const arr=Array(1000).fill(-1);
    const max=Math.max(...nums);

    for(let num=0;num<=max;num++){
        const afterOr=num|(num+1);
        if(arr[afterOr]===-1) arr[afterOr]=num;
    }

    const result=Array(nums.length);
    for(let i=0;i<nums.length;i++){
        result[i]=arr[nums[i]]
    }
    
    return result;
    
};
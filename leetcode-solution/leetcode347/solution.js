// Top K Frequent ElementsGiven a non-empty array of integers, return the k most frequent elements.

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

// Example 2:

// Input: nums = [1], k = 1
// Output: [1]

/**
 * param {number[]} nums
 * param {number} k
 * return {number[]}
 */

//  思路：
//  1. 用一个hash table存储数组的每个元素，因为访问hash表的时间是O（1）
//  2. 所以数组n个元素就是O（n）
//  3. 准备一个count来计算次数，选出kth most frequency的数

var topKFrequent = function(nums, k) {
    const obj = {};
    nums.forEach(i => {
        //看hash表里有没有i的值（i是nums里的每一个值），如果没有（===undefined），把i作为property的name放入
        //hash表，并为这个property赋值为1，如果有，则把这个property的值加1
        obj[i] === undefined ? obj[i] = 1 : obj[i]++;
    })
    //根据property的值来sort
    //Object.keys() 方法会返回一个由一个给定对象的自身可枚举属性组成的数组，数组中属性名的排列顺序和
    //使用 for...in 循环遍历该对象时返回的顺序一致 。
    //slice也可以用splice
    //sort() 方法用原地算法对数组的元素进行排序，并返回数组。排序算法现在是稳定的。默认排序顺序是根据字符串Unicode码点。
    return Object.keys(obj).sort((a,b) => obj[b] - obj[a]).slice(0, k);
};
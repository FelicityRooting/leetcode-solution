public class Solution {
    /**
     * @param n an integer
     * @return an integer
     * Drop Eggs
     * There is a building of n floors. If an egg drops from the k th 
     * floor or above, it will break. If it's dropped from any floor 
     * below, it will not break. You're given two eggs, Find k while 
     * minimize the number of drops for the worst case. Return the 
     * number of drops in the worst case.
     */
	// Clarification

	// For n = 10, a naive way to find k is drop egg from 1st floor, 
	// 2nd floor ... kth floor. But in this worst case (k = 10), you have 
	// to drop 10 times.
	// Notice that you have two eggs, so you can drop at 4th, 7th & 9th 
	// floor, in the worst case (for example, k = 9) you have to drop 4 
	// times.
	// Example

	// Given n = 10, return 4.
	// Given n = 100, return 14.
	// 这个题不是二分查找的，归结于二分查找的原因是我们最后的公式可以用二分查找
	// 到答案, 我们有两个鸡蛋，那么第一个鸡蛋一定是按照一定的间距来扔的，通过第
	// 一个鸡蛋找到的间距中再一个一个的试过去。 举个例子，假如当前我们要解决的问
	// 是100层楼，那么假如我们一开始按照10作为间距的话，如果n是9的话，我们就要
	// 一次第一个鸡蛋，扔9次第二个鸡蛋，也就是需要10次，但这个明显不是最坏的情况，
	// 果n是99的话，我们就需要扔10次第一个鸡蛋，扔9次第二个鸡蛋，那么需要19次。
	// 这种情况就是最坏的情况，现在再反过来想，我们一开始以10作为间距真的是最优
	// 的解吗，很明显如果我们是以等间距扔第一个鸡蛋的话我们每一个区间的最坏查询
	// 情况都是不相等的，最坏的查询情况肯定是最后一个区间的最后一个数。
	// 那么再想，如果我们能够让每一个区间的最坏查询次数都相等的话，最坏的查询就
	// 能够达到最优的方案，那么怎么才能达到这个条件呢。仔细思考，查询到第二个区
	// 间的时候已经扔了一次第一个鸡蛋了，查询到第x个区间的时候已经扔了x-1次第
	// 一个鸡蛋了，所以显然如果我们等间距的话我们每一个区间的查询都要比前面一个
	// 区间多1次，所以我们可以每过一个区间把区间长度-1，这样就能够达到最佳的方
	// 案。 那么最大的那个区间怎么进行计算呢？其实到这一步不难发现，这个最大区间
	// 就是我们要求的最坏的情况的查询数了。 n + (n-1) + (n-2)…… + 1 = N。 这
	// 样我们就可以用简单的循环来求得这个n。

    public int dropEggs(int n) {
        // Write your code here
        
    }
}


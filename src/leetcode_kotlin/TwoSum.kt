package leetcode_kotlin

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * solution
 * 1. make two pointer
 * 2. loop pointer
 * 3. if equals target and sum that two point element, return pointer index
 *
 */
fun main() {
    val twoSumInstance = TwoSum()
    println(twoSumInstance.twoSum(intArrayOf(3, 2, 4), 6))

}

class TwoSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for(index in 0..nums.lastIndex) {
            val diff = target - nums[index]

            if (map.containsKey(diff)) {
                return intArrayOf(index, map.get(diff)!!)
            }
            map.put(nums[index], index)
        }

        return intArrayOf()
    }
}

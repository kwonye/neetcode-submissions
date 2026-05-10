class Solution {
    fun hammingWeight(n: Int): Int {
        var m = n
        var count = 0
        while (m > 0) {
            if (m and 1 == 1) {
                count++
            }
            m = m shr 1
        }

        return count
    }
}

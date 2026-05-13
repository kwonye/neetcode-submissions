class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.isEmpty() && t.isEmpty()) {
            return true
        } else if (s.length != t.length) {
            return false
        }

        val sMap = HashMap<Char, Int>()
        val tMap = HashMap<Char, Int>()

        for (i in 0 until s.length) {
            sMap[s[i]] = sMap.getOrDefault(s[i], 0) + 1
            tMap[t[i]] = tMap.getOrDefault(t[i], 0) + 1
        }

        for (c in sMap.keys) {
            val current: Int? = sMap[c]
            val compare: Int? = tMap[c]

            if (compare == null || current != compare) {
                return false
            }
        }

        return true
    }
}

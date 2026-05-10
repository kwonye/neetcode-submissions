/**

(0, 0) -> (n - 1, n - 1)
8-directional (up down left right diagnols)
return length of shortest clear path

if no path, return -1

constraints:
0 or 1 in every field
length is less than 100

runtime: O(8^N*N)

edge cases:
N of 1
if (0, 0) or (n -1, n-1) is 1

pseudo-code:

check edge cases:
    if N == 1, check if 0, else -1

create visited array
path_distance = 0
A queue of depth, once we get to (n-1, n-1), every time we iterate through, we bump shortest path.
BFS through every neighbor.

**/

class Solution {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val n = grid.size
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1
        }

        val visited = Array(n) { BooleanArray(n) }
        var distance = 0
        val queue = ArrayList<List<Int>>()
        queue.add(listOf(0, 0))

        while (!queue.isEmpty()) {
            distance++
            val count = queue.size
            for (i in 0 until count) {
                val current = queue.removeAt(0)
                val r = current[0]
                val c = current[1]

                if (r == n - 1 && c == n - 1) {
                    return distance
                }

                if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] == 1 || visited[r][c]) {
                    continue
                } else {
                    visited[r][c] = true
                    // add neighbors, iterate through
                    queue.add(listOf(r - 1, c - 1))
                    queue.add(listOf(r, c - 1))
                    queue.add(listOf(r - 1, c + 1))
                    queue.add(listOf(r, c - 1))
                    queue.add(listOf(r, c + 1))
                    queue.add(listOf(r + 1, c - 1))
                    queue.add(listOf(r + 1, c))
                    queue.add(listOf(r + 1, c + 1))
                }
            }
        }

        return -1
    }
}

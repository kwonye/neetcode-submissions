/*
0 land
1 rock (no-go)
(0, 0) -> (R - 1, C - 1) only can go up and down.

Q:
Does this require backtracking? I think so.

dfs():
    if (point == solution) {
        foundPaths++
    }

    for all neighbors (up, down, left, right) that's valid (0 and in-bounds and not-visited already), iterate through
    mark current as visited
    move into neighbor recursively
    unmark current as visited

    return foundPaths

Assumptions:
* fits in memory

Runtime:
O(4^(R*C)) = O(4^(RC))

edge cases:
* empty grid
* grid of size 1x1, which at that point, return if that is simply a 0, if so return 1, otherwise return 0
* 
*/

class Solution {
    var foundPaths = 0

    fun countPaths(grid: Array<IntArray>): Int {
        foundPaths = 0
        // edge cases
        if (grid.isEmpty() || grid[0].isEmpty()) {
            return foundPaths
        }

        if (grid.size == 1 && grid[0].size == 1) {
            if (grid[0][0] == 1) {
                return 0
            } else {
                return 1
            }
        }

        if (grid[0][0] == 1 || grid[grid.size - 1][grid[0].size -1] == 1) {
            return 0
        }

        val visitedGrid = ArrayList<IntArray>()
        for (i in 0 until grid.size) {
            visitedGrid.add(IntArray(grid[0].size))
        }
        
        // DFS
        countPaths(grid, visitedGrid, 0, 0)

        return foundPaths
    }

    fun countPaths(grid: Array<IntArray>, visited: ArrayList<IntArray>, r: Int, c: Int) {
        val rowMax = grid.size - 1
        val colMax = grid[0].size - 1
        if (r < 0 || c < 0 || r > rowMax || c > colMax) {
            return
        }

        if (visited[r][c] == 1 || grid[r][c] == 1) {
            return
        }
        
        if (r == rowMax && c == colMax) {
            // reached end
            foundPaths++
            return
        }

        visited[r][c] = 1
        
        countPaths(grid, visited, r + 1, c)
        countPaths(grid, visited, r - 1, c)
        countPaths(grid, visited, r, c + 1)
        countPaths(grid, visited, r, c - 1)

        visited[r][c] = 0
    }
}

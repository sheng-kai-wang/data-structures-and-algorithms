from typing import (
    List,
)

class Solution:
    """
    @param n: An integer
    @param edges: a list of undirected edges
    @return: true if it's a valid tree, or false
    """
    def valid_tree(self, n: int, edges: List[List[int]]) -> bool:

        if not n: return True

        node_map = {i: [] for i in range(n)}
        for n1, n2 in edges:
            node_map[n1].append(n2)
            node_map[n2].append(n1)

        visited = set()
        def dfs(n: int, prev_n: int) -> bool:
            if n in visited: return False
            visited.add(n)
            for next_n in node_map[n]:
                if next_n == prev_n: continue
                if not dfs(next_n, n): return False
            return True

        return dfs(0, -1) and n == len(visited)

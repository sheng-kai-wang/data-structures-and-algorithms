from typing import (
    List,
)

class Solution:
    def count_components(self, n: int, edges: List[List[int]]) -> int:
        
        parent = [i for i in range(n)]
        rank = [1] * n

        def find(n : int) -> int:
            res = n
            while res != parent[n]:
                parent[n] = parent[parent[n]]
                res = parent[n]
            return res
        
        def union(n1: int, n2: int) -> int:
            p1, p2 = parent[n1], parent[n2]
            if p1 == p2: return 0
            if rank[p1] > rank[p2]:
                parent[p2] = p1
                rank[p1] += rank[p2]
            else:
                parent[p1] = p2
                rank[p2] += rank[p1]
            return 1

        res = n
        for n1, n2 in edges:
            res -= union(n1, n2)

        return res

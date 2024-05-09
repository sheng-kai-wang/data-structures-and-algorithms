from typing import (
    List,
)

class Solution:
    """
    @param words: a list of words
    @return: a string which is correct order
    """
    def alien_order(self, words: List[str]) -> str:
        
        adj_map = { c:set() for w in words for c in w }
        for w_i in range(len(words) - 1):
            w1, w2 = words[w_i], words[w_i + 1]
            min_len = min(len(w1), len(w2))
            if w1[:min_len] == w2[:min_len] and len(w1) < len(w2):
                return ""
            for c_i in range(min_len):
                if w1[c_i] != w2[c_i]: adj_map[w1[c_i]].add(w2[c_i])

        visited = {}
        res = []
        def dfs(c: str) -> bool:
            if c in visited: return visited[c]
            visited[c] = True
            for n in adj_map[c]:
                if dfs(n): return True
            visited[c] = False
            res.append(c)
            return False

        for c in adj_map:
            if dfs(c): return ""
        res.reverse()
        
        return "".join(res)


if __name__ == "__main__":
    s = Solution()
    r = s.alien_order(["wrt","wrf","er","ett","rftt"])
    print("a:", "wertf")
    print("r:", r)
    print()
    r = s.alien_order(["z","x"])    
    print("a:", "zx")
    print("r:", r)

from typing import (
    List,
)


class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end


class Solution:
    """
    @param intervals: an array of meeting time intervals
    @return: the minimum number of conference rooms required
    """
    def min_meeting_rooms(self, intervals: List[Interval]) -> int:
        # Write your code here

        starts = sorted([i.start for i in intervals])
        ends = sorted([i.end for i in intervals])

        max_count, cur_count = 0, 0
        start_i, end_i = 0, 0

        while start_i < len(intervals):
            if starts[start_i] < ends[end_i]:
                cur_count += 1
                start_i += 1
            else:
                cur_count -= 1
                end_i += 1
            max_count = max(max_count, cur_count)

        return max_count


if __name__ == "__main__":
    s = Solution()
    print(s.min_meeting_rooms([Interval(0,30), Interval(5,10), Interval(15,20)]))
    print(s.min_meeting_rooms([Interval(2,7)]))

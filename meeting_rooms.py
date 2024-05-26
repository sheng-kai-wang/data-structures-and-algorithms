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
    @return: if a person could attend all meetings
    """
    def can_attend_meetings(self, intervals: List[Interval]) -> bool:
        # Write your code here

        intervals.sort(key = lambda i : i.start)

        for i in range(1, len(intervals)):
            i1 = intervals[i - 1]
            i2 = intervals[i]
            if i2.start < i1.end: return False
        
        return True


if __name__ == "__main__":
    s = Solution()
    print(s.can_attend_meetings([Interval(0,30), Interval(5,10), Interval(15,20)]))
    print(s.can_attend_meetings([Interval(5,8), Interval(9,15)]))
    print(s.can_attend_meetings([Interval(5,8), Interval(8,15)]))

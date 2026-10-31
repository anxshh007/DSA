#Approach - The two-pointer approach starts at both ends of the array and greedily moves the pointer with the smaller height inward to maximize the width and height product.

def maxArea(h):
    l, r, m = 0, len(h) - 1, 0
    while l < r:
        m = max(m, min(h[l], h[r]) * (r - l))
        if h[l] < h[r]: l += 1
        else: r -= 1
    return m

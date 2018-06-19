package medium;
/*
 * https://leetcode.com/problems/rectangle-area/description/
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C-A)*(D-B) + (G-E)*(H-F);
        int left = Math.max(A, E), right = Math.min(C, G);
        int top = Math.min(D, H), bottom = Math.max(B, F);
        int overlap = 0;
        if(right > left && top > bottom) 
            overlap = (right-left) * (top-bottom);
    		return area-overlap;
    }
}

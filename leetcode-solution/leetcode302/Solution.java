public class Solution {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     * Smallest Rectangle Enclosing Black Pixels
     */
    // An image is represented by a binary matrix with 0 as a 
    // white pixel and 1 as a black pixel. The black pixels are 
    // connected, i.e., there is only one black region. Pixels 
    // are connected horizontally and vertically. Given the 
    // location (x, y) of one of the black pixels, return the 
    // area of the smallest (axis-aligned) rectangle that encloses 
    // all black pixels.
    public int minArea(char[][] image, int x, int y) {
    	// Write your code her
        //BFS 时间复杂度是O(N * M)
        //找矩阵的上边界，下边界，左边界，右边界，每个black pixels都是相连的，
        //所以四个边界只要有black pixels，就是第一个出现black pixels的行或列
        //所以实际上我们找的是第一列或者第一行有black pixels的，那些就是我们找
        //的上下左右四个边界，比如找左边界，那么我们就是在0-Y之间二分，这样的时间
        //复杂度是：
        /*
         *left: log(colSize * log(rowSize())
         *right: log(colSize * log(rowSize())
         *up: log(rowSize * log(colSize())
         *bottom: log(rowSize * log(colSize())
         * 所以总的时间复杂度是O(nlogm + mlogn),我们要用到四个二分
         */
    	if (image == null || image.length == 0 || image[0].length == 0) {
    		return 0;
    	}
    	int n = image.length;
    	int m = image[0].length;
    	int left = findLeft(image, 0, y);
    	int right = findRight(image, y, m - 1);
    	int top = findTop(image, 0, x);
    	int bottom = findBottom(image, x, n - 1);
    	int result = (right - left + 1) * (bottom - top + 1);
    	return result;
    }
        	//left
    	private int findLeft(char[][] image, int start, int end) {
    		while(start + 1 < end) {
    			int mid = start + (end - start) / 2;
    			if (isEmptyColumn(image, mid)) {
    				start = mid;
    			} else {
    				end = mid;
    			}
    		}
    		if (isEmptyColumn(image, start)) {
    			return end;
    		} else {
    			return start;
    		}
    	}

    	//right
    	private int findRight(char[][] image, int start, int end) {
    		while(start + 1 < end) {
    			int mid = start + (end - start) / 2;
    			if (isEmptyColumn(image, mid)) {
    				end = mid;
    			} else {
    				start = mid;
    			}
    		}
    		if (isEmptyColumn(image, end)) {
    			return start;
    		} else {
    			return end;
    		}
    	}

    	//top
    	private int findTop(char[][] image, int start, int end) {
    		while(start + 1 < end) {
    			int mid = start + (end - start) / 2;
    			if (isEmptyRow(image, mid)) {
    				start = mid;
    			} else {
    				end = mid;
    			}
    		}
    		if (isEmptyRow(image, start)) {
    			return end;
    		} else {
    			return start;
    		}
    	}

    	//bottom
    	private int findBottom(char[][] image, int start, int end) {
    		while(start + 1 < end) {
    			int mid = start + (end - start) / 2;
    			if (isEmptyRow(image, mid)) {
    				end = mid;
    			} else {
    				start = mid;
    			}
    		}
    		if (isEmptyRow(image, end)) {
    			return start;
    		} else {
    			return end;
    		}
    	}

    	boolean isEmptyRow(char[][] image, int row) {
    		for (int i = 0; i < image[0].length; i++) {
    			if (image[row][i] == '1') {
    				return false;
    			}
    		}
    		return true;
    	}

    	boolean isEmptyColumn(char[][] image, int column) {
    		for (int i = 0; i < image.length; i++) {
    			if (image[i][column] == '1') {
    				return false;
    			}
    		}
    		return true;
    	}
}
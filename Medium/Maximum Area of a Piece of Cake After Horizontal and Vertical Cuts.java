class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
       Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxH = horizontalCuts[0];
        for(int i=1 ; i<horizontalCuts.length ; i++){
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i-1]);
        }

        maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length-1]);

        int maxV = verticalCuts[0];
        for(int i=1 ; i<verticalCuts.length ; i++){
            maxV = Math.max(maxV, verticalCuts[i] - verticalCuts[i-1]);
        }

        maxV = Math.max(maxV, w - verticalCuts[verticalCuts.length-1]);

        return (int)((long)maxH * maxV % (Math.pow(10,9)+7));
        }
    }

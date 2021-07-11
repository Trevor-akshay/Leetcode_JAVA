class Solution {
    public int maxScore(int[] cardPoints, int k) {
    int totalPoints = Arrays.stream(cardPoints).sum();
        int kSum = 0;
        int tempSum = 0;
        int n = cardPoints.length;

        for(int i = 0; i < n-k; i++){
            tempSum += (cardPoints[i]);
        }
        kSum = totalPoints-tempSum;

        for(int i = n-k; i < n; i++){
            tempSum += cardPoints[i] - cardPoints[i-(n-k)];
            kSum = Math.max(kSum, totalPoints - tempSum);
        }
        return kSum;
    }
}
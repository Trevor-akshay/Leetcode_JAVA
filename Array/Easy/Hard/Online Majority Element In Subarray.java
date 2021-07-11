class MajorityChecker {

    int[] array;
    public MajorityChecker(int[] arr){
        array = arr;
    }
    public int query(int left, int right, int threshold) {
        int m = -1, cnt = 0;
    for (int i = left; i <= right; i++) {
      if (cnt == 0) {
        m = array[i];
        cnt++;
        continue;
      }
      if (array[i] == m) cnt++;
      else cnt--;
    }
    cnt = 0;
    for (int i = left; i <= right; i++) {
      if (array[i] == m) cnt++;
    }
    return cnt >= threshold ? m : -1;
}}
class Solution {
  public static void main(int N,int K,int arr[]) {
    int black = 0;
    int white = 0;
    int count = 0;
    for(int i=0;i<N;i++) {
      if(arr[i]==0) {
        white++;
      }
      else {
        black++;
      }
    while(black>0) {
      count++;
      black -= K;
    }
    while(white>0) {
      count++;
      white -= K;
    }
    }
return count;
  }
}

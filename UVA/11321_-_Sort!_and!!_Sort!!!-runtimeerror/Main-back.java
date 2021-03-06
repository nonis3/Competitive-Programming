import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while (true) {
      while ((line = br.readLine()).equals(""))
        line = br.readLine();
      String[] arr = line.split("[ ]+");
      int N = Integer.parseInt(arr[0]);
      final int M = Integer.parseInt(arr[1]);
      if (N == 0 && M == 0) {
        break;
      }
      Integer[] nums = new Integer[N];
      for (int i = 0; i < N; i++) {
        nums[i] = Integer.parseInt(br.readLine());
      }
      Arrays.sort(nums, new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
          int amod = Math.abs(a % M) * (a < 0 ? -1 : 1);
          int bmod = Math.abs(b % M) * (b < 0 ? -1 : 1);
          if (amod != bmod)
            return amod - bmod;
          boolean aeven = (Math.abs(a) % 2) == 0 ? true : false;
          boolean beven = (Math.abs(b) % 2) == 0 ? true : false;
          if (aeven && !beven)
            return 1;
          else if (!aeven && beven)
            return -1;
          if (aeven && beven) {
            if (a <= b) return  -1;
            if (a > b) return 1;   
          }
          else if (!aeven && !beven) {
            if (a > b) return -1;
            if (a <= b) return 1;
          }        
          return 1;
        }
      });
      System.out.println(N + " " + M);
      for (int j = 0; j < N; j++) {
        System.out.println(nums[j]);
      }
    }
    System.out.println("0 0");
  }
}

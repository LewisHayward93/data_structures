import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Time {
  public static int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; ++i)
      for (int j = i + 1; j < nums.length; ++j)
        if (nums[i] + nums[j] == target)
          return new int[] { i, j };
    return nums;
  }

  public static int[] twoSumMap(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    map.put(nums[0], 0);
    for (int i = 1; i < nums.length; i++) {
      if (map.keySet().contains(target - nums[i]))
        return new int[] { map.get(target - nums[i]), i };
      map.put(nums[i], i);
    }
    return null;
  }

  public static int[] fileReader(String filename) {

    try {
      File f = new File(filename);
      Scanner s = new Scanner(f);
      int cnt = 0;
      while (s.hasNextInt()) {
        cnt++;
        s.nextInt();
      }
      int[] nums = new int[cnt++];
      Scanner s1 = new Scanner(f);

      for (int i = 0; i < nums.length; i++)
        nums[i] = s1.nextInt();
      return nums;
    } catch (Exception e) {
      return null;

    }

  }

  public static void main(String[] args) {

    String[] files = { "./input100.txt", "input1000.txt", "./input10000.txt", "./input100000.txt" };

    long[] noMapDuration = new long[4];
    long[] MapDuration = new long[4];

    int target = 199999;

    for (int i = 0; i < 4; i++) {
      int[] input = fileReader(files[i]);
      long startTime = System.nanoTime();
      twoSum(input, target);
      long endTime = System.nanoTime();
      long duration = (endTime - startTime) / 1000000; // divide by 1000000 to get milliseconds
      noMapDuration[i] = duration;
      long startTime1 = System.nanoTime();
      twoSumMap(input, target);
      long endTime1 = System.nanoTime();
      long duration1 = (endTime1 - startTime1) / 1000000; // divide by 1000000 to get milliseconds
      MapDuration[i] = duration1;
    }

    String[] vol = { "100", "1000", "10000", "100000" };

    String leftAlignFormat = "| %-22s | %-17d | %-14d |%n";

    System.out.format("+------------------------+-------------------+----------------+%n");
    System.out.format("| Number of integers     | Without Map (ms)  | With Map (ms)  |%n");
    System.out.format("+------------------------+-------------------+----------------+%n");

    for (int i = 0; i < 4; i++) {
      System.out.format(leftAlignFormat, vol[i], noMapDuration[i], MapDuration[i]);
    }
    System.out.format("+------------------------+-------------------+----------------+%n");
  }
}

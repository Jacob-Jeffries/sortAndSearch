package utilities;

import java.util.List;

/**
 * Helper class with static methods.
 */
public class Collections{

  private static void swapArray(double[] data, int i, int j){
    double tempValue = data[i];
    data[i] = data[j];
    data[j] = tempValue;
  }

  private static void swapList(List<Double> data, int i, int j){
    double tempValue = data.get(i);
    data.set(i, data.get(j));
    data.set(j, tempValue);
  }

  private static int calcMiddle(int low, int high){
    return (high + low) / 2;
  }

  public static void bubblesort(double[] data) {
    for (int i = 0; i < data.length-1; ++i){
      for (int j = 0; j < data.length-1; ++j){
        if (data[j] > data[j+1]){
          swapArray(data, j, (j+1));
        }
      }
    }
  }

  public static void bubblesort(List<Double> data) {
    for (int i = 0; i < data.size() - 1; ++i) {
      for (int j = 0; j < data.size() - 1; ++j) {
        if (data.get(j) > data.get(j + 1)) {
          swapList(data, j, (j + 1));
        }
      }
    }
  }

  public static void selectionsort(double[] data){
    int smallestValue;
    for (int pass = 0; pass < data.length-1; ++pass){
      smallestValue = pass;
      for (int index = pass; index < data.length; ++index){
        if (data[index] < data[smallestValue]){
          smallestValue = index;
        }
      }
      swapArray(data, pass, smallestValue);
    }
  }

  public static void selectionsort(List<Double> data) {
    int smallestValue;
    for (int pass = 0; pass < data.size() - 1; ++pass) {
      smallestValue = pass;
      for (int index = pass; index < data.size(); ++index) {
        if (data.get(index) < data.get(smallestValue)) {
          smallestValue = index;
        }
      }
      swapList(data, pass, smallestValue);
    }
  }

  public static int binarySearch(double[] data, double q){
    int lI = 0;
    int hI = data.length-1;
    int mI = calcMiddle(lI, hI);

    while (lI != mI){
      if (mI == q){
        return mI;
      } else if (q < data[mI]){
        hI = mI;
        mI = calcMiddle(lI, hI);
      } else {
        lI =  mI;
        mI = calcMiddle(lI, hI);
      }
    }

    if (q == data[lI]){
      return lI;
    } else if (q == data[mI]){
      return mI;
    } else if (q == data[hI]) {
      return hI;
    } else {
      return -1;
    }
  }

  public static int binarySearch(List<Double> data, double q) {
    int lI = 0;
    int hI = data.size() - 1;
    int mI = calcMiddle(lI, hI);

    while (lI != mI) {
      if (mI == q) {
        return mI;
      } else if (q < data.get(mI)) {
        hI = mI;
        mI = calcMiddle(lI, hI);
      } else {
        lI = mI;
        mI = calcMiddle(lI, hI);
      }
    }

    if (q == data.get(lI)) {
      return lI;
    } else if (q == data.get(mI)) {
      return mI;
    } else if (q == data.get(hI)) {
      return hI;
    } else {
      return -1;
    }
  }

}
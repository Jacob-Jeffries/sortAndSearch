package utilities;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CollectionsTest {

  private double[] unsortedData = { 363.73, -742.84, 7.0, 32.42, -867.3, 567.67, 0.0, 10.56, 42.42 };
  private double[] sortedData = { -867.3, -742.84, 0.0, 7.0, 10.56, 32.42, 42.42, 363.73, 567.67 };
  private double[] arrayData;
  private List<Double> listData;

  @BeforeEach
  public void setUp() {
    arrayData = unsortedData.clone();
    listData = new ArrayList<Double>();
    for (double eachDouble : unsortedData) {
      listData.add(eachDouble);
    }
  }

  @AfterEach
  public void tearDown() {
    arrayData = null;
    listData = null;
  }

  @Test
  public void testBubblesortArray() {
    Collections.bubblesort(arrayData);
    assertEquals(sortedData.length, arrayData.length);
    for (int i = 0; i < arrayData.length; ++i) {
      assertEquals(sortedData[i], arrayData[i]);
    }
  }

  @Test
  public void testBubblesortList() {
    Collections.bubblesort(listData);
    assertEquals(sortedData.length, listData.size());
    for (int i = 0; i < sortedData.length; ++i) {
      assertEquals(sortedData[i], listData.get(i));
    }
  }

  @Test
  public void testSelectionsortArray() {
    Collections.selectionsort(arrayData);
    assertEquals(sortedData.length, arrayData.length);
    for (int i = 0; i < arrayData.length; ++i) {
      assertEquals(sortedData[i], arrayData[i]);
    }
  }

  @Test
  public void testSelectionsortList() {
    Collections.selectionsort(listData);
    assertEquals(sortedData.length, listData.size());
    for (int i = 0; i < sortedData.length; ++i) {
      assertEquals(sortedData[i], listData.get(i));
    }
  }

  @Test
  public void testBinarySearchArray() {
    // positive tests for values in the collection
    int index = Collections.binarySearch(sortedData, -867.3);
    assertEquals(0, index);
    index = Collections.binarySearch(sortedData, 567.67);
    assertEquals(8, index);
    index = Collections.binarySearch(sortedData, 7.0);
    assertEquals(3, index);
    // negative tests for values not in the collection
    index = Collections.binarySearch(sortedData, -999.9);
    assertEquals(-1, index);
    index = Collections.binarySearch(sortedData, 568.0);
    assertEquals(-1, index);
    index = Collections.binarySearch(sortedData, 68.9);
    assertEquals(-1, index);
  }

  @Test
  public void testBinarySearchList() {
    List<Double> sortedList = new ArrayList<Double>();
    for (double eachDouble : sortedData) {
      sortedList.add(eachDouble);
    }
    // positive tests for values in the collection
    int index = Collections.binarySearch(sortedList, -867.3);
    assertEquals(0, index);
    index = Collections.binarySearch(sortedList, 567.67);
    assertEquals(8, index);
    index = Collections.binarySearch(sortedList, 7.0);
    assertEquals(3, index);
    // negative tests for values not in the collection
    index = Collections.binarySearch(sortedList, -999.9);
    assertEquals(-1, index);
    index = Collections.binarySearch(sortedList, 568.0);
    assertEquals(-1, index);
    index = Collections.binarySearch(sortedList, 68.9);
    assertEquals(-1, index);
  }
}

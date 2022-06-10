package entities;

import java.util.Comparator;

public class MergeSort {

  private Film[] array;
  private int size;

  public MergeSort(Film[] array, int size) {
    this.array = array;
    this.size = size;
  }

  public void mergeSort(){
    mergeSort(array, size);
  }

  public void mergeSort(Comparator<Film> comparator){
    mergeSort(array, size, comparator);
  }

  private void mergeSort(Film[] array, int size) throws RuntimeException {

    if (size < 2)
      return;

    int mid = size / 2;

    Film[] l = new Film[mid];
    Film[] r = new Film[size - mid];

    for (int i = 0; i < size; i++) {
      if (i < mid)
        l[i] = array[i];
      else
        r[i - mid] = array[i];
    }

    mergeSort(l, mid);
    mergeSort(r, size - mid);

    merge(array, l, r, mid, size - mid);
  }

  private void mergeSort(Film[] array, int size, Comparator<Film> comparator) throws RuntimeException {

    if (size < 2)
      return;

    int mid = size / 2;

    Film[] l = new Film[mid];
    Film[] r = new Film[size - mid];

    for (int i = 0; i < size; i++) {
      if (i < mid)
        l[i] = array[i];
      else
        r[i - mid] = array[i];
    }

    mergeSort(l, mid, comparator);
    mergeSort(r, size - mid, comparator);

    merge(array, l, r, mid, size - mid, comparator);
  }

  private void merge(Film[] merged, Film[] left, Film[] right, int leftSize, int rightSize ) {

    int i = 0, j = 0, k = 0;
    // i position array left
    // j position array right
    // k is for merge

    while (i < leftSize && j < rightSize) {
      if (left[i].compareTo(right[j]) > 0) {
        merged[k] = right[j];
        j++;
      } else {
        merged[k] = left[i];
        i++;
      }
      k++;
    }

    while (i < leftSize) {
      merged[k] = left[i];
      i++;
      k++;
    }

    while (j < rightSize) {
      merged[k] = right[j];
      j++;
      k++;
    }
  }

  private void merge(Film[] merged, Film[] left, Film[] right, int leftSize, int rightSize, Comparator<Film> comparator) {

    int i = 0, j = 0, k = 0;

    while (i < leftSize && j < rightSize) {
      if (comparator.compare(left[i], right[j]) > 0) {
        merged[k] = right[j];
        j++;
      } else {
        merged[k] = left[i];
        i++;
      }
      k++;
    }

    while (i < leftSize) {
      merged[k] = left[i];
      i++;
      k++;
    }

    while (j < rightSize) {
      merged[k] = right[j];
      j++;
      k++;
    }
  }

  public Film[] getArray() {
    return array;
  }

  public void setArray(Film[] array) {
    this.array = array;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

}
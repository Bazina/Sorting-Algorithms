package Sorting.SortingStrategies;

import Sorting.Utils;

import java.util.Comparator;
import java.util.List;

//if comparison takes much time
//this is better than regular insertion sort
public class BinaryInsertionSort<T> implements SortStrategy<T>{
    public void sort(List<T> arrayList, Comparator<T> comparator) {
        for (int i = 1; i < arrayList.size(); i++) {
            int pos = binarySearch(arrayList , comparator , i , arrayList.get(i)) ;
            letShift(arrayList , pos , i);
        }
    }

    private int binarySearch(List<T> arrayList ,Comparator<T> comparator,int end ,T val){
        int low = 0 , high = end , mid = 0;
        while (high > low){
            mid = (high+low) / 2;
            int cmp = comparator.compare(val , arrayList.get(mid)) ;
            if(cmp > 0){
               low = mid + 1;
            }else{
                high = mid  ;
            }
        }
        return low ;
    }

    private void letShift(List<T> arrayList , int shift , int end){
        T temp = arrayList.get(end) ;
        for (int i = end; i > shift; i--) {
            Utils.swap(arrayList , i , i - 1);
        }
        arrayList.set(shift , temp) ;

    }
}

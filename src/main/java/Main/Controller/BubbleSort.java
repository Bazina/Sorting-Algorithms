package Main.Controller;

import java.util.List;
import java.util.Queue;

public class BubbleSort implements Runnable{
    List<Double> toSort ;
    Queue<Move> moves ;

    public BubbleSort(List<Double> toSort , Queue<Move> moves){
        this.toSort = toSort ;
        this.moves = moves ;
    }

    public void sort() {
        boolean isSorted;
        for (int i = 0; i < toSort.size(); i++) {
            isSorted = true;
            for (int j = 1; j < toSort.size() - i; j++) {
                Move buffer = new Move(j - 1 , j , toSort.get(j - 1) , toSort.get(j) , false) ;

                if (toSort.get(j) < toSort.get(j - 1)) {
                    buffer.swap = true ;
                    swap(toSort, j - 1, j);
                    isSorted = false;
                }

                moves.add(buffer) ;
            }

            if (isSorted)
                return;
        }
    }

    private void swap(List<Double> arrayList, int i, int j) {
        double temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, temp);
    }


    @Override
    public void run() {
        sort();
    }
}

package Heaps;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap<T extends Comparable<T>> {
        private List<T> items = new ArrayList<>();

        //we can use items.size() instead
        private int size = 0;

        /**
         * @param val the value to inserted
         */
        public void insert(T val) {
            //percolate down
            //by making hole in the last position in the heap and bubble it up until root or its right position
            //better than bubbling up by swapping since bubble up takes 3 assignments every bubble
            //this algorithm takes only one
            int hole = size;
            for (items.add(val); val.compareTo(items.get((hole - 1) / 2)) > 0 && hole > 0; hole = (hole - 1) / 2)
                items.set(hole, items.get((hole - 1) / 2));
            items.set(hole, val);

            size++;

//        //fix up the new node by regular bubble up
//        BubbleUp(size -1);
        }

        /**
         * @return the largest element in the entire heap
         */
        public T remove() {
            if (isEmpty())
                throw new IllegalStateException();

            T root = items.get(0);
            items.set(0, items.get(--size));
            items.remove(size);

            //using same technique as insert
            //using percolate down with a hole to reduce number of assignments
            percolateDown();

            //fix the heap from the root
//        BubbleDown(0);

            return root;
        }

        private void percolateDown() {
            //if the removed node was the last one in the heap
            if (size == 0) return;

            int child, hole = 0;
            T temp = items.get(0);

            for (; hole * 2 + 1 < size; hole = child) {
                //the next 3 line to compare between 2 children ang get the largest
                child = hole * 2 + 1;
                if (child + 1 < size && items.get(child).compareTo(items.get(child + 1)) < 0)
                    child++;

                //if largest child is lower than the temp value then stop digging down
                //as we are in the right position
                if (items.get(child).compareTo(temp) < 0)
                    break;
                else
                    items.set(hole, items.get(child));
            }
            items.set(hole, temp);
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public T Max(){
            return items.get(0) ;
        }
    }


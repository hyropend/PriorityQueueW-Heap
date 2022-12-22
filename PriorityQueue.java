import java.util.ArrayList;

public class PriorityQueue {
    private ArrayList<Integer> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        int currentIndex = heap.size() - 1;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap.get(currentIndex) < heap.get(parentIndex)) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    public int extractMin() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }
        int min = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapify(0);
        return min;
    }

    private void heapify(int index) {
        int smallestIndex = index;
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        if (leftIndex < heap.size() && heap.get(leftIndex) < heap.get(smallestIndex)) {
            smallestIndex = leftIndex;
        }
        if (rightIndex < heap.size() && heap.get(rightIndex) < heap.get(smallestIndex)) {
            smallestIndex = rightIndex;
        }
        if (smallestIndex != index) {
            swap(index, smallestIndex);
            heapify(smallestIndex);
        }
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}

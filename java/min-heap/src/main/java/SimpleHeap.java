import java.util.ArrayList;
import java.util.List;

public class SimpleHeap implements Heap {

    private List<Integer> arr;
    private int size;
    private int capacity;

    public SimpleHeap(int capacity) {
        this.capacity = capacity;
        this.arr = new ArrayList<>(capacity);
        this.size = 0;
    }

    @Override
    public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Heap is full");
            return;
        }
        arr.add(value);
        size++;
        heapifyUp(size - 1);
    }

    @Override
    public int extractMin() {
        if (size <= 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        int min = arr.get(0);
        arr.set(0, arr.get(size - 1));
        arr.remove(size - 1);
        size--;
        heapifyDown(0);
        return min;
    }

    @Override
    public int getMin() {
        if (size <= 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        return arr.get(0);
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && arr.get(parent) > arr.get(index)) {
            swap(parent, index);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && arr.get(left) < arr.get(smallest)) {
            smallest = left;
        }

        if (right < size && arr.get(right) < arr.get(smallest)) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    @Override
    public void printHeap() {
        System.out.print("Min Heap: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
}
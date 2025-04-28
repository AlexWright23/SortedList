public class SortedList {
    private String[] data;
    private int size;

    public SortedList() {
        data = new String[100];
        size = 0;
    }

    public void add(String item) {
        int insertIndex = findInsertLocation(item);
        for (int i = size; i > insertIndex; i--) {
            data[i] = data[i-1];
        }
        data[insertIndex] = item;
        size++;
    }

    public String search(String item) {
        int index = binarySearch(item);
        if (index >= 0) {
            return "Found at index " + index + ": " + data[index];
        } else {
            return "Not found. Should be inserted at index " + -(index + 1);
        }
    }

    private int findInsertLocation(String item) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid].compareTo(item) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int binarySearch(String item) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = data[mid].compareTo(item);
            if (cmp == 0) return mid;
            if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -(low + 1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(data[i]).append("\n");
        }
        return sb.toString();
    }
}


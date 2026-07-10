public class MySearch {

    public int search(int size, int target, SearchTypes searchType) {
        Array_Samples array = new Array_Samples(size);
        switch (searchType) {
            case LINEAR:
                return linearSearch(array.getArray(), target);
            case BINARY:
                return binarySearch(array.getArray(), target);
            default:
                throw new IllegalArgumentException("Invalid search type");
        }
    }

    private int linearSearch(int[] array, int target) {
        int checks = 0;
        for (int num : array) {
            if (num == target) {
                return checks;
            }
            checks++;
        }
        return -1;
    }

    private int binarySearch(int[] array, int target) {

        int checks = 0;

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return checks;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            checks++;
        }

        return -1;
    }

}
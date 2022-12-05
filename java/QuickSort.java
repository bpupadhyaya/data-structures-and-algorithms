class QuickSort {
    public void sort(int[] data) {
        int size = data.length;
        quickSort(data, 0, size -1);
    }

    private void quickSort(int[] data, int lower, int upper) {
        if (upper <= lower)
            return;
        int pivot = data[lower];
        int start = lower;
        int stop = upper;

        while (lower < upper) {
            while (data[lower] <= pivot && lower < upper) {
                lower++;
            }
            while (data[upper] > pivot && lower <= upper) {
                upper--;
            }
            if (lower < upper) {
                swap(data, upper, lower);
            }
        }
        swap(data, upper, start);
        quickSort(data, start, upper -1);
        quickSort(data, upper + 1, stop);
    }

    private void swap(int[] data, int first, int second) {
        int temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }

    public static void main(String[] args) {
        int[] myData = {8,4,9,2,6,1,2,8,10,11,11,15};
        QuickSort qs = new QuickSort();
        qs.sort(myData);
        for (int i = 0; i < myData.length; i++) {
            System.out.print(myData[i] + ",");
        }
        System.out.println();
    }
}
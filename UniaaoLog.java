import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class UniaaoLog {

    public static void main(String[] args) {
        int[] arrAscending = generateAscendingArray(10000);
        int[] arrDescending = generateDescendingArray(10000);
        int[] arrRandom1 = generateRandomArray(100000);
        int[] arrRandom2 = generateRandomArray(100000);
        int[] arrRandom3 = generateRandomArray(100000);

        System.out.println("Ordenação de array em ordem crescente:");
        testSortingAlgorithms(arrAscending);
        System.out.println();

        System.out.println("Ordenação de array em ordem decrescente:");
        testSortingAlgorithms(arrDescending);
        System.out.println();

        System.out.println("Ordenação de array aleatório 1:");
        testSortingAlgorithms(arrRandom1);
        System.out.println();

        System.out.println("Ordenação de array aleatório 2:");
        testSortingAlgorithms(arrRandom2);
        System.out.println();

        System.out.println("Ordenação de array aleatório 3:");
        testSortingAlgorithms(arrRandom3);
        System.out.println();
    }

    public static void testSortingAlgorithms(int[] arr) {
        int[] arrQuickSort = arr.clone();
        int[] arrMergeSort = arr.clone();

        Instant startQuickSort = Instant.now();
        quickSort(arrQuickSort, 0, arrQuickSort.length - 1);
        Instant endQuickSort = Instant.now();
        printTimeElapsed("Quick Sort", startQuickSort, endQuickSort);

        Instant startMergeSort = Instant.now();
        mergeSort(arrMergeSort);
        Instant endMergeSort = Instant.now();
        printTimeElapsed("Merge Sort", startMergeSort, endMergeSort);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int meio = left + (right - left) / 2;
            mergeSort(arr, left, meio);
            mergeSort(arr, meio + 1, right);
            merge(arr, left, meio, right);
        }
    }

    private static void merge(int[] arr, int left, int meio, int right) {
        int[] leftArray = Arrays.copyOfRange(arr, left, meio + 1);
        int[] rightArray = Arrays.copyOfRange(arr, meio + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }
    }

    public static int[] generateAscendingArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateDescendingArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 10);
        }
        return arr;
    }

    private static void printTimeElapsed(String sortAlgorithm, Instant start, Instant end) {
        Duration duration = Duration.between(start, end);
        System.out.println(sortAlgorithm + ": Tempo decorrido - " + duration.toMillis() + " milissegundos");
    }
}

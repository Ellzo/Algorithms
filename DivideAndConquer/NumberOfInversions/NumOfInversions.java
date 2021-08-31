import java.util.Scanner;

public class NumOfInversions {
    private static int[] array;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter Number of elements: ");
        array = new int[s.nextInt()];

        System.out.println("Enter elements: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = s.nextInt();
        }

        System.out.println();
        int inversions = numOfInvs();
        System.out.println("Inversions: " + inversions);

        System.out.println();
        System.out.println("Sorted Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private static int numOfInvs() {
        if (array != null && array.length != 0)
            return mergeSortCalcInvs(0, array.length - 1);
        return 0;
    }

    private static int mergeSortCalcInvs(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            int inv1 = mergeSortCalcInvs(start, mid);
            int inv2 = mergeSortCalcInvs(mid + 1, end);
            int inv3 = mergeCalcInvs(start, mid, end);
            return inv1 + inv2 + inv3;
        } else {
            return 0;
        }
    }

    private static int mergeCalcInvs(int start, int mid, int end) {
        if (start < end) {
            int invs = 0;
            int r = mid + 1;
            int l = start;

            int[] tempArray = new int[array.length];

            while (r <= end && l <= mid) {
                if (array[l] > array[r]) {
                    tempArray[r + l - mid - 1] = array[r];
                    invs += mid - l + 1;
                    r++;
                } else {
                    tempArray[r + l - mid - 1] = array[l];
                    l++;
                }
            }

            while (l <= mid) {
                tempArray[r + l - mid - 1] = array[l];
                l++;
            }

            while (r <= end) {
                tempArray[r + l - mid - 1] = array[r];
                r++;
            }

            if (end + 1 - start >= 0) System.arraycopy(tempArray, start, array, start, end + 1 - start);

            return invs;
        } else {
            return 0;
        }
    }
}

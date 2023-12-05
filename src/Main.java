import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Main testbed = new Main();

        // scanner function
        Scanner sr = new Scanner(System.in);

        // create a manu
        while (true) {
            System.out.println("Menu of Searching and Sorting Testbed.\n" +
                    "1. Linear Searching\n" +
                    "2. Binary Searching\n" +
                    "3. O(n^2) type of Sorting\n" +
                    "4. O(n * log(n)) type of sorting\n" +
                    "5. Sorting performance\n" +
                    "q/Q. Quit\n" +
                    "Your choice: ");
            String choice = sr. nextLine();
            // for closing the while loop
            if( choice.equalsIgnoreCase("q")) {
                break;
            }

            // create a list

            int[] list = {0, 1, 2, 3, -4, 5, 6, -7, 8, -9 };

            // added a function as like menu option

            if ( choice.equals("1")) {
                System.out.println("In this list are values " + Arrays.toString(list) + "; which value would like to search with linear search? ");

                int search = sr.nextInt();
                sr.nextLine(); // Consume the newline character

                if (testbed.linearSearch(list, search)) {
                    System.out.println("Found.");
                } else {
                    System.out.println("Not found.");
                }
            } else if ( choice.equals("2")) {

                System.out.println("In this list are values " + Arrays.toString(list) + "; which value would like to search with binary search? ");

                int search = sr.nextInt();
                sr.nextLine(); // Consume the newline character

                if (testbed.binarySearch(list, search)) {
                    System.out.println("Found.");
                } else {
                    System.out.println("Not found.");
                }

            } else if ( choice.equals("3")) {

                testbed.selectionSort(list);

                System.out.println("Sorted list is " + Arrays.toString(list));

            } else if (choice.equals("4")) {

                testbed.quickSort(list, 0, list.length - 1);

                System.out.println("Sorted list is " + Arrays.toString(list));

            } else if (choice.equals("5")) {
                System.out.println( " To measure performance , you can run a large array and measure the time before and after sorting.");

            } else {

                System.out.println("Invalid choice, please choose again.");
            }
        }

        sr.close();

    }

    // linearSearching function

    public boolean linearSearch(int[] list, int search) {

        for( int value : list) {

            if(value == search) {

                return  true;
            }
        }
        return false;
    }

    // binarySearching function

    public boolean binarySearch(int[] list, int search) {

        Arrays.sort(list);

        int left = 0;
        int right = list.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list[mid] == search) {
                return true;
            }
            if (list[mid] < search) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;

    }

    // selectionSort function

    public void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;
        }
    }

    //quickSort function

    public void quickSort(int[] list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    private int partition(int[] list, int low, int high) {
        int pivot = list[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list[j] < pivot) {
                i++;
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        int temp = list[i + 1];
        list[i + 1] = list[high];
        list[high] = temp;
        return i + 1;
    }


}
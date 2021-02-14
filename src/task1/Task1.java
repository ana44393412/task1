package task1;

import static java.lang.System.*;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 7, 6, 4};
        arr = tanos(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] tanos(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {  //счетчик массива
            sum += arr[i]; // сложение элементов массива
        }
        int arif = sum / arr.length;
        int[] arrTemp = new int[arr.length];
        int l1 = 0; // количество элементов левой части массива
        if (arr.length % 2 == 0) {
            l1 = arr.length / 2;  // количество элементов левой части массива
        } else {
            l1 = arr.length / 2 + 1;  // количество элементов левой части массива
        }

        int l2 = arr.length - l1;  // количество элементов правой части массива
        int s1 = 0; // левый индекс массива
        int s2 = arr.length - 1; // правый индекс массива

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= arif) {
                arrTemp[s1] = arr[i];
                s1++;
            } else {
                arrTemp[s2] = arr[i];
                s2--;
            }
        }
        int[] arrLeft = new int[l1];
        int[] arrRight = new int[l2];
        for (int i = 0; i < l1; i++) {
            arrLeft[i] = arrTemp[i];
        }
        int k = 0;
        for (int i = l1; i < arr.length; i++) {
            arrRight[k] = arrTemp[i];
            k++;
        }

        if (arrLeft.length != 1) {
            arrLeft = tanos(arrLeft);
        }
        if (arrRight.length != 1) {
            arrRight = tanos(arrRight);
        }
        for (int i = 0; i < l1; i++) {
            arrTemp[i] = arrLeft[i];
        }

        k = 0;
        for (int i = l1; i < arr.length; i++) {
            arrTemp[i] = arrRight[k];
            k++;
        }
        return arrTemp;
    }

}

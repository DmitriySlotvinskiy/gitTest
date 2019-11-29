//3) Написать метод который принимает массив случайных чисел.
//Метод должен вернуть массив(меньшего размера) который состоит из элементов, которые больше среднего арифметического.

package com.slotvinskiy;

import java.util.Arrays;
import java.util.Random;

public class Task3 {

    private static final int SIZE = 10;
    private static final Random RANDOM = new Random();
    private static final int RANDOM_BOUND = 5;

    public static void main(String[] args) {

        int[] array = arrayInit(SIZE);
        System.out.println(Arrays.toString(array));
        double average = getAverage(array);
        System.out.println("Average is " + average);
        int[] newArray = getArrayWithElementsMoreAverage(array, average);
        System.out.println("New array is " + Arrays.toString(newArray));

    }


    private static int[] arrayInit(int size) {

        int[] arr = new int[size];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = RANDOM.nextInt(RANDOM_BOUND);
        }
        return arr;
    }

    private static double getAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (double) sum / array.length;
    }

    private static int[] getArrayWithElementsMoreAverage(int[] array, double average) {

        int newArrayIndex = 0;
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > average) {
                newArray[newArrayIndex] = array[i];
                newArrayIndex++;
            }
        }
        return Arrays.copyOfRange(newArray, 0, newArrayIndex);
    }
}

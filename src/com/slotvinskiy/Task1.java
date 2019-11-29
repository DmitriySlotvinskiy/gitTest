//1) Электронные часы показывают время в формате от 00:00 до 23:59.
////Подсчитать сколько раз за сутки случается так, что слева от двоеточия
// показывается симметричная комбинация для той, что справа от двоеточия (например, 02:20, 11:11 или 15:51).

package com.slotvinskiy;

public class Task1 {

    private static final int HOURS = 24;
    private static final int MINUTES = 60;

    public static void main(String[] args) {

        StringBuilder sbHours = new StringBuilder("00");
        StringBuilder sbMinutes = new StringBuilder("00");
        StringBuilder sbTemp = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < HOURS; i++) {
            sbTemp.append(i);
            if (i < 10) {
                sbHours.replace(1, 2, sbTemp.toString());
            } else {
                sbHours.replace(0, 2, sbTemp.toString());
            }
            sbTemp.delete(0, sbTemp.length());

            sbHours.reverse();
            for (int j = 0; j < MINUTES; j++) {
                sbTemp.append(j);
                if (j < 10) {
                    sbMinutes.replace(1, 2, sbTemp.toString());
                } else {
                    sbMinutes.replace(0, 2, sbTemp.toString());
                }
                sbTemp.delete(0, sbTemp.length());
                if (sbHours.toString().equals(sbMinutes.toString())) {
                    counter++;
                }
            }
            sbHours.reverse();
        }
        System.out.println(counter);
    }
}
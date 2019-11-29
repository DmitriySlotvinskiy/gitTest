//4) В банк положили S денег. Какой станет сумма вклада через N лет,
// если процент 1,5% добавляется к сумме вклада ежемесячно.

package com.slotvinskiy;

public class Task4 {

    private static final double SUM = 1000;
    private static final int YEARS = 5;
    private static final double INTERESTS = 1.5;

    public static void main(String[] args) {

        int months = YEARS * 12;
        double money = getTotalSum(SUM, months, INTERESTS);
        System.out.printf("Total sum is going to be %.2f", money);

    }

    private static double getTotalSum(double sum, int months, double interests) {
        for (int i = 0; i < months; i++) {
            sum = sum + sum * interests / 100;
        }
        return sum;
    }
}

//2) Найти количество счастливых билетиков на трамвай от 000001 до 999999
// (те у которых сумма первых 3 цифр равна сумме последних 3)

package com.slotvinskiy;

public class Task2 {

    private static final int COUNT_FROM = 1;
    private static final int COUNT_TO = 999999;

    public static void main(String[] args) {

        int count = getNumberOfLuckyTickets(COUNT_FROM, COUNT_TO);
        System.out.println(count);
    }

    private static int getNumberOfLuckyTickets(int start, int end) {
        int counter = 0;
        StringBuilder sbTicket = new StringBuilder("000000");
        StringBuilder sbTemp = new StringBuilder();

        for (int i = start; i <= end; i++) {
            sbTemp.append(i);
            int insertPosition = sbTicket.toString().length() - sbTemp.toString().length();
            sbTicket.replace(insertPosition, sbTicket.length(), sbTemp.toString());
            boolean isLucky = isTicketLucky(sbTicket.toString());
            if (isLucky) {
                counter++;
            }
            sbTemp.delete(0, sbTemp.length());
        }
        return counter;
    }

    private static boolean isTicketLucky(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() / 2) {
                sum += Integer.parseInt(s.substring(i, i + 1));
            } else {
                sum -= Integer.parseInt(s.substring(i, i + 1));
            }
        }
        if (sum == 0) {
            return true;
        } else {
            return false;
        }

    }


}

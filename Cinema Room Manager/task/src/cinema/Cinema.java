package cinema;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int FirstNumbersOfRows = scanner.nextInt();
        int NumberofRows = FirstNumbersOfRows + 1;
        System.out.println("Enter the number of seats in each row:");
        int FirstNumbersofSeats = scanner.nextInt();
        int NumberofSeats = FirstNumbersofSeats + 1;


        char[][] cinemaSeats = new char[NumberofRows][NumberofSeats];
        System.out.println("");
        for (int i = 0; i < NumberofRows; i++) {
            for (int j = 0; j < NumberofSeats; j++) {
                cinemaSeats[i][j] = 'S';
            }
        }
        boolean flag = true;
        int purchasedTickets = 0;
        int currentIncome = 0;
        int totalIncome = 0;


        while (flag) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int numScanner = scanner.nextInt();
            switch (numScanner) {
                case 1: {

                    for (int i = 0; i < NumberofSeats; i++) {
                        cinemaSeats[0][i] = Integer.toString(i).charAt(0);
                    }

                    for (int i = 1; i < NumberofRows; i++) {
                        cinemaSeats[i][0] = Integer.toString(i).charAt(0);
                    }

                    System.out.println("Cinema:");
                    cinemaSeats[0][0] = ' ';
                    System.out.print("");
                    for (int i = 0; i < NumberofRows; i++) {
                        System.out.print("");
                        for (int j = 0; j < NumberofSeats; j++) {
                            System.out.print(cinemaSeats[i][j] + " ");
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                    break;
                }
                case 2: {
                    int rowNumber;
                    int seatNumber;
                    while (true) {
                        System.out.println("Enter a row number:");
                        rowNumber = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        seatNumber = scanner.nextInt();
                        if (rowNumber > FirstNumbersOfRows || rowNumber <= 0 || seatNumber > FirstNumbersofSeats || seatNumber <= 0) {
                            System.out.println("Wrong input!");
                        } else if (cinemaSeats[rowNumber][seatNumber] == 'B') {
                            System.out.println("That ticket has already been purchased!");

                        } else {
                            cinemaSeats[rowNumber][seatNumber] = 'B';
                            purchasedTickets++;
                            break;


                        }
                    }

                    int odd = 0;
                    if (FirstNumbersOfRows % 2 != 0) {
                        odd += 1;
                    }
                    System.out.println("");
                    if (FirstNumbersOfRows * FirstNumbersofSeats <= 60) {
                        System.out.println("Ticket price: $10");
                        System.out.println("");
                        currentIncome += 10;


                    } else if (rowNumber < FirstNumbersOfRows / 2 + odd && FirstNumbersOfRows * FirstNumbersofSeats > 60) {
                        System.out.println("Ticket price: $10");
                        System.out.println("");
                        currentIncome += 10;
                    } else if (rowNumber >= FirstNumbersOfRows / 2 + odd && FirstNumbersOfRows * FirstNumbersofSeats > 60) {
                        System.out.println("Ticket price: $8");
                        System.out.println("");
                        currentIncome += 8;
                    }


                    break;

                }
                case 3: {
                    System.out.println("Number of purchased tickets: " + purchasedTickets);

                    if (purchasedTickets == 0) {
                        System.out.println("Percentage: 0.00%");
                    } else {
                        int total = FirstNumbersOfRows * FirstNumbersofSeats;
                        double purchasedPercent = (double) (purchasedTickets * 100) / total;
                        DecimalFormat df = new DecimalFormat("0.00");
                        String formattedPercent = df.format(purchasedPercent);
                        System.out.println("Percentage: " + formattedPercent + "%");
                    }

                    System.out.println("Current income: $" + currentIncome);


                    if (totalIncome == 0 && FirstNumbersOfRows * FirstNumbersofSeats <= 60) {
                        totalIncome = (FirstNumbersOfRows * FirstNumbersofSeats) * 10;


                    } else if (totalIncome == 0 && FirstNumbersOfRows * FirstNumbersofSeats > 60) {

                        int odd = 0;
                        if (FirstNumbersOfRows % 2 != 0) {
                            odd += 1;
                        }

                        totalIncome = ((FirstNumbersOfRows / 2) * FirstNumbersofSeats) * 10 + ((FirstNumbersOfRows / 2 + odd) * FirstNumbersofSeats) * 8;


                    }
                    System.out.println("Total income: $" + totalIncome);
                    break;

                }
                case 0: {
                    flag = false;
                    break;
                }
            }

        }


    }


}


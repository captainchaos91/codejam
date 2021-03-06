package de.illner.codejam;


import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class StoreCredit extends Codejam
{

    static final String IN_SMALL = "A-small-practice.in";
    static final String OUT_SMALL = "A-small-practice.out";
    static final String IN_LARGE = "A-large-practice.in";
    static final String OUT_LARGE = "A-large-practice.out";


    public static void main(String[] args) throws FileNotFoundException
    {
        StoreCredit storeCredit = new StoreCredit();
        storeCredit.solve(StoreCredit.class, IN_SMALL, OUT_SMALL);
        System.out.println("Finished successfully!");
    }


    @Override
    void solveProblem(IoHelperForCodejam ioHelper)
    {
        int tests = ioHelper.getScanner().nextInt();
        for (int test = 1; test <= tests; test++)
        {
            List<Integer> solution = findCorrectItemIndices(ioHelper.getScanner());
            ioHelper.printLineWithWriter("Case #" + test + ": " + (solution.get(0) + 1) + " " + (solution.get(1) + 1));
        }
    }


    private static List<Integer> findCorrectItemIndices(Scanner scanner)
    {
        int credit = scanner.nextInt();
        int items = scanner.nextInt();
        scanner.nextLine();
        String itemLine = scanner.nextLine();
        String[] prices = itemLine.split(" ");

        for (int itemOne = 0; itemOne < items - 1; itemOne++)
        {
            for (int itemTwo = itemOne + 1; itemTwo < items; itemTwo++)
            {
                if (Integer.parseInt(prices[itemOne]) + Integer.parseInt(prices[itemTwo]) == credit)
                {
                    return Arrays.asList(itemOne, itemTwo);
                }
            }
        }
        return null;
    }
}

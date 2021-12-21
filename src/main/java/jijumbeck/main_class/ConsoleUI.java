package jijumbeck.main_class;

import java.io.IOException;
import java.util.Scanner;

/*
Класс для работы с консолью.
 */
public class ConsoleUI {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int getIntegerFromConsole(int maximumBorder) {
        int integer = maximumBorder + 1;
        String input;
        while (integer > maximumBorder) {
            try{
                input = scanner.next();
                integer = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                integer = maximumBorder + 1;
            }
        }

        return integer;
    }

    public static int getIntegerFromConsole(int minimumBorder, int maximumBorder) {
        int integer = maximumBorder + 1;
        String input;
        while (integer > maximumBorder || integer < minimumBorder) {
            try{
                input = scanner.next();
                integer = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                integer = maximumBorder + 1;
            }
        }

        return integer;
    }
}

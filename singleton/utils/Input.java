package singleton.utils;

import java.io.IOException;
import java.util.Scanner;

public final class Input {
    private static Scanner in = new Scanner(System.in);

    private Input() {

    }

    public static String input() {
        System.out.print("> ");
        return in.nextLine();
    }

    public static void clear() {
        if(System.getProperty("os.name").contains("Windows")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (InterruptedException e) {

            } catch (IOException e) {

            }
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public static void close() {
        in.close();
    }
}
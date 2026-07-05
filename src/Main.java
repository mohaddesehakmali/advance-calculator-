import java.lang.classfile.instruction.SwitchCase;
import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class Main {

    public static void main(String[] args) {
        try(MenuCalculator menu = new MenuCalculator()) {
            menu.start();
        }
    }
}
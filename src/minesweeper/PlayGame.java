package minesweeper;

import java.util.Scanner;

public class PlayGame {
    private String[][] minesField;

    private String[][] minesHidedField;
    private int numberOfMines;

    public PlayGame(String[][] minesField, String[][] minesHidedField, int numberOfMines) {
        this.minesField = minesField;
        this.minesHidedField = minesHidedField;
        this.numberOfMines = numberOfMines;
    }

    public void playGame(String[][] minesField, String[][] minesHidedField, int numberOfMines) {
        int foundMines = 0;

        while (foundMines < numberOfMines) {
            Scanner scanner = new Scanner(System.in);

            GenerateMinesField generateMinesField = new GenerateMinesField(numberOfMines);

            System.out.print("Set/unset mines marks or claim a cell as free: ");

            int x = scanner.nextInt();

            int y = scanner.nextInt();

            String mineOrFree = scanner.next();

            if (mineOrFree.equalsIgnoreCase("free")) {
                if (minesField[y-1][x-1].equalsIgnoreCase( String.valueOf(0)) || minesField[y-1][x-1].equalsIgnoreCase(String.valueOf(1))
                        || minesField[y-1][x-1].equalsIgnoreCase(String.valueOf(2)) || minesField[y-1][x-1].equalsIgnoreCase(String.valueOf(3))
                        || minesField[y-1][x-1].equalsIgnoreCase(String.valueOf(4)) || minesField[y-1][x-1].equalsIgnoreCase(String.valueOf(5))
                        || minesField[y-1][x-1].equalsIgnoreCase(String.valueOf(6)) || minesField[y-1][x-1].equalsIgnoreCase(String.valueOf(7))
                        || minesField[y-1][x-1].equalsIgnoreCase(String.valueOf(8))) {
                    System.out.println("There is a number here!");
                } else if (minesHidedField[y-1][x-1].equalsIgnoreCase("*")){
                    if (minesField[y-1][x-1].equalsIgnoreCase("/")) {
                        minesHidedField[y-1][x-1] = "/";
                    } else if (minesField[y-1][x-1].equalsIgnoreCase("X")) {
                        minesHidedField[y-1][x-1] = ".";
                    }
                } else if (minesField[y-1][x-1].equalsIgnoreCase("X")) {
                    generateMinesField.printMinesField(minesField);
                    System.out.println("You stepped on a mine and failed!");
                    break;
                } else if (minesField[y-1][x-1].equalsIgnoreCase("/")){
                    minesHidedField[y-1][x-1] = "*";
                }
            }

            if (mineOrFree.equalsIgnoreCase("mine")) {
                if (minesField[y-1][x-1].equalsIgnoreCase( String.valueOf(0)) || minesField[y-1][x-1].equalsIgnoreCase(String.valueOf(1))
                        || minesField[y-1][x-1].equalsIgnoreCase(String.valueOf(2)) || minesField[y-1][x-1].equalsIgnoreCase(String.valueOf(3))
                        || minesField[y-1][x-1].equalsIgnoreCase(String.valueOf(4)) || minesField[y-1][x-1].equalsIgnoreCase(String.valueOf(5))
                        || minesField[y-1][x-1].equalsIgnoreCase(String.valueOf(6)) || minesField[y-1][x-1].equalsIgnoreCase(String.valueOf(7))
                        || minesField[y-1][x-1].equalsIgnoreCase(String.valueOf(8))) {
                    System.out.println("There is a number here!");
                } else if (minesHidedField[y-1][x-1].equalsIgnoreCase("*")){
                    if (minesField[y-1][x-1].equalsIgnoreCase("/")) {
                        minesHidedField[y-1][x-1] = "/";
                    } else if (minesField[y-1][x-1].equalsIgnoreCase("X")) {
                        minesHidedField[y-1][x-1] = ".";
                    }
                } else if (minesField[y-1][x-1].equalsIgnoreCase("X")) {
                    minesHidedField[y-1][x-1] = "*";
                    foundMines++;
                } else if (minesField[y-1][x-1].equalsIgnoreCase("/")){
                    minesHidedField[y-1][x-1] = "*";
                }
            }

            generateMinesField.printMinesField(minesHidedField);
        }

        if (foundMines == numberOfMines) {
            System.out.println("Congratulations! You found all mines!");
        }
    }
}

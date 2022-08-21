package minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);


        System.out.print("How many mines do you want on the field? ");

        int numberOfMines = scanner.nextInt();

        GenerateMinesField generateMinesField = new GenerateMinesField(numberOfMines);

        String[][] field = generateMinesField.generateField(numberOfMines);

        String[][] fieldWithMines = generateMinesField.generateMines(numberOfMines, field);

        String[][] minesFieldWithReferences = generateMinesField.markFieldsAroundMines(field);

        String[][] fieldWithHidedMines = generateMinesField.hideMines(minesFieldWithReferences);

        generateMinesField.printMinesField(fieldWithHidedMines);

        PlayGame playGame = new PlayGame(minesFieldWithReferences, fieldWithHidedMines, numberOfMines);

        playGame.playGame(minesFieldWithReferences, fieldWithHidedMines, numberOfMines);


    }
}

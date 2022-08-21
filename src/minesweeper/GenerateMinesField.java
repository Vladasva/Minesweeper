package minesweeper;

import java.util.Random;

class GenerateMinesField {
    private int numberOfMines;

    public GenerateMinesField(int numberOfMines) {
        this.numberOfMines = numberOfMines;
    }
    String[][] generateField(int numberOfMines) {
        String [][] minesField = new String[9][9];

        for (int i = 0; i < minesField.length; i++) {
            for (int j = 0; j < minesField[i].length; j++) {
                minesField[i][j] = ".";
            }
        }

        return minesField;
    }
    String[][] generateMines(int numberOfMines, String[][] minesField) {
        Random random = new Random();

        int upperBound = 8;

        int minesCounter = 1;

        while (minesCounter <= numberOfMines) {
            for (int i = 0; i < minesField.length; i++) {
                if (minesCounter <= numberOfMines) {
                    int randomMinePlace = random.nextInt(upperBound);
                    for (int j = 0; j < minesField[i].length; j++) {
                        if (minesField[i][randomMinePlace] != "X") {
                            minesField[i][randomMinePlace] = "X";
                            minesCounter++;
                        };
                    }
                } else {
                    break;
                }
            }
        }
        return minesField;
    }

    String[][] markFieldsAroundMines(String[][] minesField) {

        for (int i = 0; i < minesField.length; i++) {

            for (int j = 0; j < minesField[i].length; j++) {
                if (minesField[i][j] != "X") {
                    int countMines = 0;
                    countMines = Integer.parseInt(String.valueOf(countMines));

                    if ((i - 1 >= 0) && (j - 1 >= 0)) {
                        if (minesField[i - 1][j - 1] != "X") {
                            minesField[i][j] = "/";
                        }
                    }
                    if ((i - 1 >= 0) && (j <= 8)) {
                        if (minesField[i - 1][j] != "X") {
                            minesField[i][j] = "/";
                        }
                    }
                    if ((i - 1 >= 0) && (j + 1 <= 8)) {
                        if (minesField[i - 1][j + 1] != "X") {
                            minesField[i][j] = "/";
                        }
                    }
                    if ((i <= 8) && (j - 1 >= 0)) {
                        if (minesField[i][j - 1] != "X") {
                            minesField[i][j] = "/";
                        }
                    }
                    if ((i <= 8) && (j + 1 <= 8)) {
                        if (minesField[i][j + 1] != "X") {
                            minesField[i][j] = "/";
                        }
                    }
                    if ((i + 1 <= 8) && (j - 1 >= 0)) {
                        if (minesField[i + 1][j - 1] != "X") {
                            minesField[i][j] = "/";
                        }
                    }
                    if ((i + 1 <= 8) && (j <= 8)) {
                        if (minesField[i + 1][j] != "X") {
                            minesField[i][j] = "/";
                        }
                    }
                    if ((i + 1 <= 8) && (j + 1 <= 8)) {
                        if (minesField[i + 1][j + 1] == "X") {
                            minesField[i][j] = "/";
                        }
                    }
                }

                if (minesField[i][j] != "X") {
                    int countMines = 0;
                    countMines = Integer.parseInt(String.valueOf(countMines));

                    if ((i - 1 >= 0) && (j - 1 >= 0)) {
                        if (minesField[i - 1][j - 1] == "X") {
                            countMines++;
                            minesField[i][j] = String.valueOf(countMines);
                        }
                    }
                    if ((i - 1 >= 0) && (j <= 8)) {
                        if (minesField[i - 1][j] == "X") {
                            countMines++;
                            minesField[i][j] = String.valueOf(countMines);
                        }
                    }
                    if ((i - 1 >= 0) && (j + 1 <= 8)) {
                        if (minesField[i - 1][j + 1] == "X") {
                            countMines++;
                            minesField[i][j] = String.valueOf(countMines);
                        }
                    }
                    if ((i <= 8) && (j - 1 >= 0)) {
                        if (minesField[i][j - 1] == "X") {
                            countMines++;
                            minesField[i][j] = String.valueOf(countMines);
                        }
                    }
                    if ((i <= 8) && (j + 1 <=  8)) {
                        if (minesField[i][j + 1] == "X") {
                            countMines++;
                            minesField[i][j] = String.valueOf(countMines);
                        }
                    }
                    if ((i + 1 <= 8) && (j - 1 >= 0)) {
                        if (minesField[i + 1][j - 1] == "X") {
                            countMines++;
                            minesField[i][j] = String.valueOf(countMines);
                        }
                    }
                    if ((i + 1 <= 8) && (j <= 8)) {
                        if (minesField[i + 1][j] == "X") {
                            countMines++;
                            minesField[i][j] = String.valueOf(countMines);
                        }
                    }
                    if ((i + 1 <= 8) && (j + 1 <= 8)) {
                        if (minesField[i + 1][j +1 ] == "X") {
                            countMines++;
                            minesField[i][j] = String.valueOf(countMines);
                        }
                    }
                }
            }
        }
        return minesField;
    }

    String [][] hideMines(String[][] minesField) {

        String [][] minesHidedField = new String[9][9];

        for (int i = 0; i < minesField.length; i++) {
            for (int j = 0; j < minesField[i].length; j++) {
                minesHidedField[i][j] = minesField[i][j];
            }
        }

        for (int i = 0; i < minesHidedField.length; i++) {
            for (int j = 0; j < minesHidedField[i].length; j++) {
                if (minesHidedField[i][j] == "X") {
                    minesHidedField[i][j] = ".";
                }
            }
        }
        return minesHidedField;
    }
    void printMinesField(String[][] minesField) {

        System.out.println(" |123456789|");
        System.out.println("-|---------|");

        int counter = 0;

        for (int i = 0; i < minesField.length; i++) {

            counter++;

            System.out.print(counter + "|");

            for (int j = 0; j < minesField[i].length; j++) {
                System.out.print(minesField[i][j]);
            }
            System.out.println("|");
        }

        System.out.println("-|---------|");
    }
}

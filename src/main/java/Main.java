public class Main {
    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] incorrectSizeArray = {
                {"1", "2"},
                {"3", "4"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"ывс", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            System.out.println(sumArray(correctArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(sumArray(incorrectSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(sumArray(invalidDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Неверный размер массива. Размер массива должен быть 4x4.");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Невалидное значение в [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }

        return sum;
    }
}

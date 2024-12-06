import java.io.*;
import java.util.*;

public class Lab1 {
    public static void main(String[] args) throws FileNotFoundException {
        int nRows;
        char[][] arr;

        String filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        // Введення розміру матриці
        System.out.print("Введіть розмір квадратної матриці: ");
        nRows = in.nextInt();
        in.nextLine();  // Зчитуємо залишок рядка

        // Перевірка на мінімальний розмір матриці
        if (nRows < 4) {
            System.out.println("Розмір матриці має бути більшим або дорівнювати 4.");
            return;
        }

        int firstLayer = nRows / 4;
        int secondLayer = firstLayer * 2;
        arr = new char[nRows][];

        // Ініціалізація масиву
        for (int i = 0; i < nRows; i++) {
            if (i < firstLayer || i > nRows - firstLayer - 1) {
                arr[i] = new char[nRows];
            } else {
                arr[i] = new char[secondLayer];
            }
        }

        // Введення заповнювача
        System.out.print("\nВведіть символ-заповнювач: ");
        filler = in.nextLine();

        // Перевірка, чи введено лише один символ
        if (filler.length() != 1) {
            System.out.println(filler.length() == 0 ? "Не введено символ заповнювач" : "Забагато символів заповнювачів");
            return;
        }

        // Заповнення матриці і виведення результатів
        char fillChar = filler.charAt(0);
        int counterForColl = nRows - secondLayer;

        for (int i = 0; i < nRows; i++) {
            boolean run = true;
            int counterForRows = 0;

            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = fillChar;

                if (i >= firstLayer && i < nRows - firstLayer && j == arr[i].length / 2 && run) {
                    // Виведення пробілів посередині
                    for (int k = 0; k < counterForColl; k++) {
                        System.out.print("  ");
                        fout.print("  ");
                    }
                    run = false;
                }

                System.out.print(arr[i][j] + " ");
                fout.print(arr[i][j] + " ");
            }

            System.out.print("\n");
            fout.print("\n");
        }

        fout.flush();
        fout.close();
    }
}

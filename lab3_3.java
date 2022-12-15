import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class lab3_3 {
    public static void main(String[] args) {
        int count = 0;
        double sum = 0;
        double[] tmpArray = new double[]{};
        double[] array = new double[]{};
        double[] copyArray = new double[]{};

        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Введите элемент в массив. Для выхода введите quit: ");
        while (!in.hasNext("quit")) {
            while (true) {
                if (in.hasNextDouble()) {
                    tmpArray = Arrays.copyOf(array, array.length + 1);
                    tmpArray[tmpArray.length - 1] = in.nextDouble();
                    array = Arrays.copyOf(tmpArray, tmpArray.length);
                    System.out.print("Введите элемент в массив: ");
                    break;
                } else if (!in.hasNext("quit")) {
                    System.out.print("Вы ввели строку. Повторите ввод: ");
                    in.next();
                } else {
                    break;
                }
            }
        }

        System.out.println("Размерность массива: " + tmpArray.length);

        System.out.print("Исходный массив: ");
        for (double x : tmpArray)
            if (x % 1 == 0) {
                System.out.print((int) x + " ");
            } else {
                System.out.print(x + " ");
            }

        double element = tmpArray[0];
        for (int i = 1; i < tmpArray.length; i++) {
            int position;
            if (element >= tmpArray[i]) {
                position = i;
                copyArray = new double[tmpArray.length - 1];
                System.arraycopy(tmpArray, 0, copyArray, 0, position);
                System.arraycopy(tmpArray, position + 1, copyArray, position, tmpArray.length - 1 - position);
                tmpArray = Arrays.copyOf(copyArray, copyArray.length);
                i--;
            } else {
                element = tmpArray[i];
            }
        }

        System.out.print("Массив после обработки: ");
        for (double x : copyArray)
            if (x % 1 == 0) {
                System.out.print((int) x + " ");
            } else {
                System.out.print(x + " ");
            }

        in.close();
    }
}
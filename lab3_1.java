import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class lab3_1 {
    public static void main(String[] args) {
        int count = 0;
        double sum = 0;
        double[] tmpArray = new double[]{};
        double[] array = new double[]{};

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

        double[] newArray = new double[tmpArray.length];
        for (int i = 0; i < tmpArray.length; i++) {
            count++;
            sum += tmpArray[i];
            newArray[i] = sum / count;
        }

        System.out.println();
        System.out.print("Массив после обработки: ");
        for (double x : newArray)
            if (x % 1 == 0) {
                System.out.print((int) x + " ");
            } else {
                System.out.print(x + " ");
            }

        in.close();
    }
}



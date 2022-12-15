import java.util.Arrays;
import java.util.Scanner;

public class lab3_2 {
    public static void main(String[] args) {
        int element, x = 0;
        int[] tmpArray = new int[]{};
        int[] array = new int[]{};

        int count = 0;

        Scanner in = new Scanner(System.in);
        System.out.print("Введите элемент в массив. Для выхода введите quit: ");
        while (!in.hasNext("quit")) {
            while (true) {
                if (in.hasNextInt()) {
                    tmpArray = Arrays.copyOf(array, array.length + 1);
                    element = Integer.parseInt(in.next());
                    tmpArray[tmpArray.length - 1] = element;
                    array = Arrays.copyOf(tmpArray, tmpArray.length);
                    System.out.print("Введите элемент в массив: ");
                    break;
                } else if (!in.hasNext("quit")) {
                    System.out.print("Вы ввели нецелое число или строку. Повторите ввод: ");
                    in.next();
                } else {
                    break;
                }
            }
        }

        System.out.println("Размерность массива: " + tmpArray.length);

        System.out.print("Число к удалению: ");
        in.next();
        if (in.hasNextInt()) {
            x = Integer.parseInt(in.next());
        } else {
            System.out.println("Ошибка, массив и число к удалению должны быть целыми");
            System.exit(0);
        }

        System.out.print("Массив: ");
        for (int i : tmpArray) {
            System.out.print(i + " ");
        }

        if (tmpArray[tmpArray.length - 1] == x) {
            tmpArray[tmpArray.length - 1] = 0;
            count++;
        }

        for (int i = 0; i < tmpArray.length; i++) {
            if (tmpArray[0] == x) {
                for (int j = 0; j < tmpArray.length - 1; j++) {
                    tmpArray[j] = tmpArray[j + 1];
                }
                count++;
            }
        }

        for (int i = 1; i < tmpArray.length; i++) {
            if (tmpArray[i] == x) {
                count++;
                for (int j = i; j < tmpArray.length - 1; j++) {
                    tmpArray[j] = tmpArray[j + 1];
                }
                i--;
            }
        }

        System.out.print("\nМассив после обработки: ");
        for (int i = 0; i < tmpArray.length - count; i++) {
            System.out.print(tmpArray[i] + " ");
        }

        in.close();
    }
}



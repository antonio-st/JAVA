import com.sun.source.util.SourcePositions;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Main {

    static String word = "javalove";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Угадай слово! ");
        int lengthWord = word.length(); // ищем длину слова javalove
        String maskWord = "-".repeat(lengthWord); // повторяем "-" по кол-ву равным длине слова lengthWord и записываем в переменную 
        System.out.println(maskWord); // выводим символы

        do {
            System.out.println("Введите букву"); // просим пользователя ввести букву
            char c = input.next().charAt(0); // проверяем первый символ, записываем в переменную c     
       

            if (word.indexOf(c) >= 0) {      // a -> 2 , если w -> -1
                System.out.println("Удача, угадал!");
                for (char elem : word.toCharArray()) { // разбираем оригинальное слово на список элементов
                    if (elem == c) { //если введенный символ совпадает с оригинальным словом
                        maskWord = replaceMaskLetter(c, maskWord); //если это так , открываем букву (см. метод)
                    }
                }
                System.out.println(maskWord); //печатаем
            } else {
                System.out.println("Промах, попробуй еще раз!");
                System.out.println(maskWord); //выводим то , что уже отгадали
            }
        } while (maskWord.contains("-")); //выполняется пока в маскированном слове есть "-"
        System.out.println("Поздравляем, ты выиграл!");
    }

    public static String replaceMaskLetter(char c, String maskWord) { //метод, на вход получает символ и маскированное слово
        StringBuilder stringBuilder = new StringBuilder(); //заводим переменную для внесения данных с маски слова
        for (int i = 0; i < word.length(); i++) { // в цикле проходим по слову 
            if (word.charAt(i) == c) { //если буква совпадает, то добавляем ее
                stringBuilder.append(c);
            } else if (maskWord.charAt(i) != '-') { //добавляем те элементы, которые уже открыты
                stringBuilder.append(maskWord.charAt(i));
            } else {
                stringBuilder.append("-"); // если это не отгаданный и не открытый символ, добавляем "-"
            }
        }
        return stringBuilder.toString(); //возвращаем значения
    }
}

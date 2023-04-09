import java.util.Objects;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        calculator();
    }

    public static String calc(String input)
    {
        return input;
    }
    static void calculator()
    {
        //массивы для проверок
        String[] arabianMassive = new String[] {"1","2","3","4","5","6","7","8","9","10"};
        String[] romanMassive = new String[] {"I","II","III","IV","V","VI","VII","VIII","IX","X"};

        Scanner scanner = new Scanner(System.in);
        int A = 0;//первое число
        int B = 0;//второе число

        //операторы
        char plus = '+';
        char minus = '-';
        char multi = '*';
        char div = '/';

        String a = scanner.next();//ввод первого числа
        char operator = scanner.next().charAt(0);//ввод оператора
        String b = scanner.next();//ввод второго числа

        //проверка арабских чисел
        //арабский ответ в консоль
        if (Arrays.asList(arabianMassive).contains(a) && Arrays.asList(arabianMassive).contains(b))
        {
            //конвертация арабских цифр(при вводе) в римские
            switch (a)
            {
                case "1" -> A = 1;
                case "2" -> A = 2;
                case "3" -> A = 3;
                case "4" -> A = 4;
                case "5" -> A = 5;
                case "6" -> A = 6;
                case "7" -> A = 7;
                case "8" -> A = 8;
                case "9" -> A = 9;
                case "10" -> A = 10;
                default -> System.out.println("Строка1 не является математической операцией");
            }
            switch (b)
            {
                case "1" -> B = 1;
                case "2" -> B = 2;
                case "3" -> B = 3;
                case "4" -> B = 4;
                case "5" -> B = 5;
                case "6" -> B = 6;
                case "7" -> B = 7;
                case "8" -> B = 8;
                case "9" -> B = 9;
                case "10" -> B = 10;
                default -> System.out.println("Строка2 не является математической операцией");
            }

            //вывод в зависимости от введенного оператора
            if(operator == plus)
            {
                System.out.print(A + B);
                //System.out.print(A + B);
            }
            if(operator == minus)
            {
                System.out.print(A - B);
                //System.out.print(A - B);
            }
            if(operator == multi)
            {
                System.out.print(A * B);
                //System.out.print(A * B);
            }
            if(operator == div)
            {
                System.out.print(A / B);
                //System.out.print(A / B);
            }
                //System.out.print(" арабские");
        }

        //проверка римских чисел
        //римский ответ в консоль
        if (Arrays.asList(romanMassive).contains(a) && Arrays.asList(romanMassive).contains(b))
        {
            //конвертация римских цифр(при вводе) в арабские
            switch (a)
            {
                case "I" -> A = 1;
                case "II" -> A = 2;
                case "III" -> A = 3;
                case "IV" -> A = 4;
                case "V" -> A = 5;
                case "VI" -> A = 6;
                case "VII" -> A = 7;
                case "VIII" -> A = 8;
                case "IX" -> A = 9;
                case "X" -> A = 10;
                default -> System.out.println("Строка1 не является математической операцией");
            }
            switch (b)
            {
                case "I" -> B = 1;
                case "II" -> B = 2;
                case "III" -> B = 3;
                case "IV" -> B = 4;
                case "V" -> B = 5;
                case "VI" -> B = 6;
                case "VII" -> B = 7;
                case "VIII" -> B = 8;
                case "IX" -> B = 9;
                case "X" -> B = 10;
                default -> System.out.println("Строка2 не является математической операцией");
            }

            //вывод в зависимости от введенного оператора
            if(operator == plus)
            {
                System.out.print(arabicToRoman(A + B));
                //System.out.print(A + B);
            }
            if(operator == minus)
            {
                System.out.print(arabicToRoman(A - B));
                //System.out.print(A - B);
            }
            if(operator == multi)
            {
                System.out.print(arabicToRoman(A * B));
                //System.out.print(A * B);
            }
            if(operator == div)
            {
                System.out.print(arabicToRoman(A / B));
                //System.out.print(A / B);
            }
                //System.out.print(" римские");
        }
    }

    //конвертер взят отсюда: https://translated.turbopages.org/proxy_u/en-ru.ru.fc0e14e6-6431a298-b17a1fcc-74722d776562/https/www.baeldung.com/java-convert-roman-arabic
    static String arabicToRoman(int number)
    {
        if ((number <= 0) || (number > 4000))
        {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size()))
        {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number)
            {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else
            {
                i++;
            }
        }
        return sb.toString();
    }
}
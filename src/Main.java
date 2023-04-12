import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //переменная ввода всех данных
        Scanner scanner = new Scanner(System.in);
        //строка содержащая все введенные данные (в дальнейшем разбивается на символы)
        String inputGlobal = scanner.nextLine();

        calc(inputGlobal);
    }

    public static String calc(String input) throws IOException
    {
        //переменные
        //массивы для проверок
        String[] arabianMassive = new String[] {"1","2","3","4","5","6","7","8","9","10"};
        String[] romanMassive = new String[] {"I","II","III","IV","V","VI","VII","VIII","IX","X"};

        //переменные для конвертации из string в int
        int A = 0;//первое число
        int B = 0;//второе число

        //операторы (для условий if)
        char plus = '+';
        char minus = '-';
        char multi = '*';
        char div = '/';

        //калькулятор
        //проверка на ввод данных в одну строку
        if (!input.matches("[a-zA-Z\\d]+\\s*[+\\-*/]\\s*[a-zA-Z\\d]+"))
        {
            throw new IOException("строка не является математической операцией");
        }

        //обработка введенных данных
        String[] inputParts = input.split("\\s+"); //разбивает строку на части
        String a = inputParts[0];//первое введенное число
        char operator = inputParts[1].charAt(0);//введенный арифметический оператор
        String b = inputParts[2];//второе введенное число

        //проверка, что используются одновременно разные системы счисления
        if ((Arrays.asList(arabianMassive).contains(a) && Arrays.asList(romanMassive).contains(b)) ||
                (Arrays.asList(romanMassive).contains(a) && Arrays.asList(arabianMassive).contains(b)))
        {
            throw new IOException("используются одновременно разные системы счисления");
        }

        //проверка введены ли символы находящиеся в массивах arabianMassive и romanMassive
        if ((!Arrays.asList(arabianMassive).contains(a) && !Arrays.asList(romanMassive).contains(b)) ||
                (!Arrays.asList(romanMassive).contains(a) && !Arrays.asList(arabianMassive).contains(b)))
        {
            throw new IOException("введено незапланированное число");
        }

        //проверка арабских чисел (что оба числа арабские)
        //арабский ответ в консоль
        if (Arrays.asList(arabianMassive).contains(a) && Arrays.asList(arabianMassive).contains(b))
        {
            //конвертация арабских цифр(при вводе) из string в int
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
                default -> throw new IOException("введено незапланированное число");
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
                default -> throw new IOException("введено незапланированное число");
            }

            //вывод в зависимости от введенного оператора
            if(operator == plus)
            {
                input = String.valueOf((A + B));
                System.out.print(A + B);
            }
            if(operator == minus)
            {
                input = String.valueOf((A - B));
                System.out.print(A - B);
            }
            if(operator == multi)
            {
                input = String.valueOf((A * B));
                System.out.print(A * B);
            }
            if(operator == div)
            {
                input = String.valueOf((A / B));
                System.out.print(A / B);
            }
        }
        //проверка римских чисел (что оба числа римские)
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
                default -> System.out.println("введено незапланированное число");
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
                default -> System.out.println("введено незапланированное число");
            }

            //вывод в зависимости от введенного оператора
            if(operator == plus)
            {
                input = (arabicToRoman(A + B));
                System.out.print(arabicToRoman(A + B));
            }
            if(operator == minus)
            {
                int result = A - B;
                if(result < 1)
                {
                    throw new IOException("в римской системе нет отрицательных чисел или нуля");
                }
                input = (arabicToRoman(A - B));
                System.out.print(arabicToRoman(A - B));
            }
            if(operator == multi)
            {
                input = (arabicToRoman(A * B));
                System.out.print(arabicToRoman(A * B));
            }
            if(operator == div)
            {
                input = (arabicToRoman(A / B));
                System.out.print(arabicToRoman(A / B));
            }
        }

        return input;
    }

    static String arabicToRoman(int number)
    {
        if ((number <= 0) || (number > 4000))
        {
            throw new IllegalArgumentException("введено не предусмотренное число");
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
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

//конвертер взят отсюда: https://translated.turbopages.org/proxy_u/en-ru.ru.fc0e14e6-6431a298-b17a1fcc-74722d776562/https/www.baeldung.com/java-convert-roman-arabic
enum RomanNumeral
{
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);

    int value;

    RomanNumeral(int value)
    {
        this.value = value;
    }

    int getValue()
    {
        return value;
    }

    static List<RomanNumeral> getReverseSortedValues()
    {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                .collect(Collectors.toList());
    }
}
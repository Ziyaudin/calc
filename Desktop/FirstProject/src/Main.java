import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static String[] strings;

    static boolean digit1;
    static boolean digit2;

    static boolean roman;

    static int n1;
    static int n2;

    static int result;

    static Map<Integer, String> map = new HashMap<>();
    static Map<String, Integer> map2 = new HashMap<>();

    public static void main(String[] args) throws IOException {

        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(11, "XI");
        map.put(12, "XII");
        map.put(13, "XIII");
        map.put(14, "XIV");
        map.put(15, "XV");
        map.put(16, "XVI");
        map.put(17, "XVII");
        map.put(18, "XVIII");
        map.put(19, "XIX");
        map.put(20, "XX");
        map.put(21, "XXI");
        map.put(22, "XXII");
        map.put(23, "XXIII");
        map.put(24, "XXIV");
        map.put(25, "XXV");
        map.put(26, "XXVI");
        map.put(27, "XXVII");
        map.put(28, "XXVIII");
        map.put(29, "XXIX");
        map.put(30, "XXX");
        map.put(31, "XXXI");
        map.put(32, "XXXII");
        map.put(33, "XXXIII");
        map.put(34, "XXXIV");
        map.put(35, "XXXV");
        map.put(36, "XXXVI");
        map.put(37, "XXXVII");
        map.put(38, "XXXVIII");
        map.put(39, "XXXIX");
        map.put(40, "XL");
        map.put(41, "XLI");
        map.put(42, "XLII");
        map.put(43, "XLIII");
        map.put(44, "XLIV");
        map.put(45, "XLV");
        map.put(46, "XLVI");
        map.put(47, "XLVII");
        map.put(48, "XLVIII");
        map.put(49, "XLIX");
        map.put(50, "L");
        map.put(51, "LI");
        map.put(52, "LII");
        map.put(53, "LIII");
        map.put(54, "LIV");
        map.put(55, "LV");
        map.put(56, "LVI");
        map.put(57, "LVII");
        map.put(58, "LVIII");
        map.put(59, "LIX");
        map.put(60, "LX");
        map.put(61, "LXI");
        map.put(62, "LXII");
        map.put(63, "LXIII");
        map.put(64, "LXIV");
        map.put(65, "LXV");
        map.put(66, "LXVI");
        map.put(67, "LXVII");
        map.put(68, "LXVIII");
        map.put(69, "LXIX");
        map.put(70, "LXX");
        map.put(71, "LXXI");
        map.put(72, "LXXII");
        map.put(73, "LXXIII");
        map.put(74, "LXXIV");
        map.put(75, "LXXV");
        map.put(76, "LXXVI");
        map.put(77, "LXXVII");
        map.put(78, "LXXVIII");
        map.put(79, "LXXIX");
        map.put(80, "LXXX");
        map.put(81, "LXXXI");
        map.put(82, "LXXXII");
        map.put(83, "LXXXIII");
        map.put(84, "LXXXIV");
        map.put(85, "LXXXV");
        map.put(86, "LXXXVI");
        map.put(87, "LXXXVII");
        map.put(88, "LXXXVIII");
        map.put(89, "LXXXIX");
        map.put(90, "LXL");
        map.put(91, "LXLI");
        map.put(92, "LXLII");
        map.put(93, "LXLIII");
        map.put(94, "LXLIV");
        map.put(95, "LXLV");
        map.put(96, "LXLVI");
        map.put(97, "LXLVII");
        map.put(98, "LXLVIII");
        map.put(99, "LXLIX");
        map.put(100, "C");

        map2.put("I", 1);
        map2.put("II", 2);
        map2.put("III", 3);
        map2.put("IV", 4);
        map2.put("V", 5);
        map2.put("VI", 6);
        map2.put("VII", 7);
        map2.put("VIII", 8);
        map2.put("IX", 9);
        map2.put("X", 10);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(calc(scanner.nextLine()));
        }
    }

    public static String calc(String input) throws IOException {

        input = input.toUpperCase();

        strings = input.split("[+\\-*/]");

        if(strings.length != 2)
            throw new IOException("Некорректный формат данных");

        digit1 = isDigit(strings[0]);
        digit2 = isDigit(strings[1]);

        if(digit1 != digit2)
            throw new IOException("Некорректный формат данных");

        if(digit1 && digit1) {
            n1 = Integer.parseInt(strings[0]);
            n2 = Integer.parseInt(strings[1]);
        } else {
            if(map2.get(strings[0]) == null || map2.get(strings[1]) == null)
                throw new IOException("Некорректный формат данных");

            roman = true;

            n1 = map2.get(strings[0]);
            n2 = map2.get(strings[1]);
        }

        if(n1 < 1 || n1 > 10 || n2 < 1 || n2 > 10)
            throw new IOException("Некорректный формат данных");

        strings = input.split("[+]");

        if(strings.length == 2) {
            result = n1+n2;
        } else {
            strings = input.split("[-]");

            if(strings.length == 2) {
                result = n1-n2;
            } else {
                strings = input.split("[*]");

                if(strings.length == 2) {
                    result = n1*n2;
                } else {
                    result = n1/n2;
                }
            }
        }

        if(roman == true) {
            if(result < 1)
                throw new IOException("Ошибка! В римской системе счисления нет отрицательных чисел!");

            roman = false;
            return map.get(result);
        } else {
            return result + "";
        }
    }

    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

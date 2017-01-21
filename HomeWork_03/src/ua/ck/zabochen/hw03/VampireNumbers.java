package ua.ck.zabochen.hw03;

/*
    Число-вампир - в математике, составное натуральное число с четным количеством цифр, которое может быть разложено в
произведение двух некоторых целых (также называемых «клыками»), удовлетворяющих специальным правилам.
    - каждое из них должно состоять из количества цифр, вдвое меньшего, чем у исходного числа.
    - если в одном из них последняя цифра ноль, то другое оканчиваться нулем не может.
    - исходное число должно в любом порядке содержать все цифры, входящие в «клыки» (т. е. для любой цифры числа
вхождений в исходное число и в клыки должны быть равными).

    21 x 60 = 1260
    15 x 93 = 1395
    35 x 41 = 1435
    30 x 51 = 1530
    21 x 87 = 1827
    27 x 81 = 2187
    80 x 86 = 6880
 */

public class VampireNumbers {

    public boolean isVampire(int number, int[] multiplyNumbers) {

        // Get 2 first digit number (long -> int)
        int number01 = number / 100;
        // Get 2 last digit number
        int number23 = number % 100;

        // Numbers separate
        int[] numberArray = new int[4];
        numberArray[0] = number01 / 10;
        numberArray[1] = number01 % 10;
        numberArray[2] = number23 / 10;
        numberArray[3] = number23 % 10;

        for (int i = 0; i < numberArray.length; i++) {
            int result = 0;
            for (int j = 0; j < numberArray.length; j++) {
                if (j == i) continue;
                for (int k = 0; k < numberArray.length; k++) {
                    if ((k == i) || (k == j)) continue;
                    for (int l = 0; l < numberArray.length; l++) {
                        if ((l == i) || (l == j) || (l == k)) continue;
                        multiplyNumbers[0] = numberArray[i] * 10 + numberArray[j];
                        multiplyNumbers[1] = numberArray[k] * 10 + numberArray[l];
                        result = multiplyNumbers[0] * multiplyNumbers[1];
                        if (result == number) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

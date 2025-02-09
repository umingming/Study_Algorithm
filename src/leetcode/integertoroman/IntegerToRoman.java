package leetcode.integertoroman;

/**
 * 7개의 서로 다른 기호와 그 값
 *
 * 기호	값
 * I	1
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1000
 * 로마 숫자는 십진수의 각 자리 값을 높은 자리부터 낮은 자리 순으로 변환한 결과를 이어붙여서 만듭니다. 십진수 자리 값을 로마 숫자로 변환하는 규칙은 다음과 같습니다:
 *
 * 4나 9로 시작하지 않는 경우:
 * 입력값에서 빼줄 수 있는 가장 큰 값을 가진 기호를 선택하여 결과에 추가하고, 그 기호의 값을 입력값에서 빼준 후 남은 값에 대해 다시 로마 숫자로 변환합니다.
 *
 * 4나 9로 시작하는 경우:
 * 해당 자리 값을 바로 표현하지 않고, 빼기 형태를 사용합니다. 예를 들어, 4는 5(V)에서 1(I)를 뺀 형태인 IV로, 9는 10(X)에서 1(I)를 뺀 형태인 IX로 표현합니다. 오직 다음의 빼기 형태만 사용됩니다:
 *
 * 4 → IV
 * 9 → IX
 * 40 → XL
 * 90 → XC
 * 400 → CD
 * 900 → CM
 * 연속 사용 규칙:
 * 10의 거듭제곱에 해당하는 기호들(I, X, C, M)은 최대 3번까지 연속해서 붙여서 10의 배수를 표현할 수 있습니다. 반면, 5(V), 50(L), 500(D)는 여러 번 붙여 사용할 수 없습니다. 만약 같은 기호를 4번 연속으로 사용해야 한다면, 빼기 형태를 사용해야 합니다.
 *
 * 정수가 주어지면, 위의 규칙에 따라 해당 정수를 로마 숫자로 변환하세요.
 */
public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman solution = new IntegerToRoman();
        System.out.println(solution.intToRoman(58));

    }

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        while(num > 0) {
            int digit = (int) Math.log10(num);
            int pow = (int) Math.pow(10, digit);
            result.append(intToRomanFromEachDigit(digit, num / pow));
            num %= pow;
        }

        return result.toString();
    }

    private String intToRomanFromEachDigit(int digit, int num) {
        StringBuilder result = new StringBuilder();

        // 천의 자리
        if (digit == 3) {
            for(int i=0; i<num; ++i) {
                result.append("M");
            }
        // 백의 자리
        } else if (digit == 2) {
            if (isStartFourOrNine(num)) {
                return num == 4 ? "CD" : "CM";
            } else {
                if (num >= 5) {
                    result.append("D");
                    num -= 5;
                }

                for(int i=0; i<num; ++i) {
                    result.append("C");
                }
            }
        // 십의 자리
        } else if (digit == 1) {
            if (isStartFourOrNine(num)) {
                return num == 4 ? "XL" : "XC";
            } else {
                if (num >= 5) {
                    result.append("L");
                    num -= 5;
                }

                for(int i=0; i<num; ++i) {
                    result.append("X");
                }
            }
        } else {
            if (isStartFourOrNine(num)) {
                return num == 4 ? "IV" : "IX";
            } else {
                if (num >= 5) {
                    result.append("V");
                    num -= 5;
                }

                for(int i=0; i<num; ++i) {
                    result.append("I");
                }
            }
        }

        return result.toString();
    }

    private boolean isStartFourOrNine(int num) {
        return num == 4 || num == 9;
    }
}

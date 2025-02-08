package leetcode.stringtointeger;

public class StringToIntegerFunctional {

    static class StringToIntegerProcessor {

        public StringToIntegerProcessor(String input) {
            this.input = input;
        }

        String input;

        boolean sign = true;

        boolean isProcess = true;

        int result;

        int index;

        private StringToIntegerProcessor trim() {
            this.input = this.input.trim();
            return this;
        }

        private StringToIntegerProcessor emptyCheck() {
            if (this.input.isEmpty()) {
                this.isProcess = false;
            }

            return this;
        }

        private StringToIntegerProcessor checkSign() {
            if (this.isProcess) {
                char firstChar = this.input.charAt(0);
                if (firstChar == '+' || firstChar == '-') {
                    sign = firstChar == '+';
                    index++;
                }
            }

            return this;
        }

        private StringToIntegerProcessor zeroCheck() {
            if (this.isProcess) {
                while(index < this.input.length() && this.input.charAt(index) == '0') {
                    index++;
                }
            }

            return this;
        }

        private StringToIntegerProcessor calculate() {
            if (this.isProcess) {
                while (index < this.input.length() && Character.isDigit(this.input.charAt(index))) {
                    int digit = this.input.charAt(index) - '0';

                    if (result > (Integer.MAX_VALUE - digit) / 10) {
                        result = sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                        break;
                    }

                    result = result * 10 + digit;
                    index++;
                }
            }
            result = sign ? result : -result;
            return this;
        }
    }

    public static void main(String[] args) {
        StringToIntegerProcessor result = new StringToIntegerProcessor(" -042");
        result.trim()
              .emptyCheck()
              .checkSign()
              .zeroCheck()
              .calculate();

        System.out.println(result.result);
    }

    public int myAtoi(String s) {
        StringToIntegerProcessor result = new StringToIntegerProcessor(s);
        return result.trim().emptyCheck()
                            .checkSign()
                            .zeroCheck()
                            .calculate()
                            .result;
    }
}

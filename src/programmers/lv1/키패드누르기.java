package programmers.lv1;

/**
 * 이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
 * 맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며,
 * 엄지손가락을 사용하는 규칙은 다음과 같습니다.
 *
 * 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
 * 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
 * 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
 * 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
 * 4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
 * 순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
 *
 * [풀이]
 * 1. 1,4,7의 경우 왼손 3,6,9의 경우 오른손 처리한다.
 *  1.1. 이때 왼손의 좌표와 오른손의 좌표를 지속적으로 추적한다.
 * 2. 만약 2,5,8,0일 경우 왼손과 오른손의 좌표값을 계산해준다.
 *  2.1. (계산식 = x축의 차이 + y축의 차이)
 */
public class 키패드누르기 {

    public String solution(int[] numbers, String hand) {
        String lHandCoordinate = "1-4";
        String rHandCoordinate = "3-4";

        StringBuilder sb = new StringBuilder();
        for(int num : numbers) {
            String checkType = checkType(num);
            if (checkType.equals("M")) {
                String mHandCoordinate = isMiddleCase(num);
                String calculate = calculate(lHandCoordinate, rHandCoordinate, mHandCoordinate);

                if (calculate.equals("L")) {
                    lHandCoordinate = mHandCoordinate;
                    sb.append(calculate);
                } else if (calculate.equals("R")){
                    rHandCoordinate = mHandCoordinate;
                    sb.append(calculate);
                } else {
                    if (hand.equals("right")) {
                        rHandCoordinate = mHandCoordinate;
                        sb.append("R");
                    } else {
                        lHandCoordinate = mHandCoordinate;
                        sb.append("L");
                    }
                }

            } else if (checkType.equals("L")) {
                sb.append(checkType);
                lHandCoordinate = isLHandCase(num);
            } else {
                sb.append(checkType);
                rHandCoordinate = isRHandCase(num);
            }
        }

        return sb.toString();
    }

    private String calculate(String lHandCoordinate, String rHandCoordinate, String mHandCoordinate) {
        String[] MString = mHandCoordinate.split("-");

        int mx = Integer.parseInt(MString[0]);
        int my = Integer.parseInt(MString[1]);

        String[] LString = lHandCoordinate.split("-");
        int lx = Integer.parseInt(LString[0]);
        int ly = Integer.parseInt(LString[1]);

        String[] RString = rHandCoordinate.split("-");
        int rx = Integer.parseInt(RString[0]);
        int ry = Integer.parseInt(RString[1]);

        int lDif = (mx >= lx ? mx-lx : lx-mx) + (my >= ly ? my-ly : ly-my);
        int rDif = (mx >= rx ? mx-rx : rx-mx) + (my >= ry ? my-ry : ry-my);

        if (lDif < rDif) {
            return "L";
        } else if (lDif > rDif) {
            return "R";
        } else {
            return "E";
        }

    }

    private String checkType(int num) {
        if (num == 1 || num == 4 || num == 7) {
            return "L";
        } else if (num == 2 || num == 5 || num == 8 || num == 0) {
            return "M";
        } else {
            return "R";
        }
    }

    private String isMiddleCase(int num) {
        String xCoordinate = "2-";
        if (num == 2) {
            return xCoordinate + 1;
        } else if (num == 5) {
            return xCoordinate + 2;
        } else if (num == 8) {
            return xCoordinate + 3;
        } else {
            return xCoordinate + 4;
        }
    }

    private String isRHandCase(int num) {
        String xCoordinate = "3-";
        return xCoordinate + (num/3);
    }

    private String isLHandCase(int num) {
        String xCoordinate = "1-";
        return xCoordinate + (1+(num/3));
    }

    public static void main(String[] args) {
        키패드누르기 solution = new 키패드누르기();

        System.out.println(solution.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }

}

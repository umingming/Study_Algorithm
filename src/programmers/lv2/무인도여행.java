package programmers.lv2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다.
 * 지도에는 바다와 무인도들에 대한 정보가 표시돼 있습니다.
 * 지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며,
 * 격자의 각 칸에는 'X' 또는 1에서 9 사이의 자연수가 적혀있습니다.
 *
 * 지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다. 이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다. 지도의 각 칸에 적힌 숫자는 식량을 나타내는데, 상, 하, 좌, 우로 연결되는 칸에 적힌 숫자를 모두 합한 값은 해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냅니다. 어떤 섬으로 놀러 갈지 못 정한 메리는 우선 각 섬에서 최대 며칠씩 머물 수 있는지 알아본 후 놀러갈 섬을 결정하려 합니다.
 *
 * 지도를 나타내는 문자열 배열 maps가 매개변수로 주어질 때, 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return 하는 solution 함수를 완성해주세요. 만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return 해주세요.
 *
 * [예시]
 * ["X591X","X1X5X","X231X", "1XXX1"]
 *
 * [
 *  [X, 5, 9, 1, X]
 *  [X, 1, X, 5, X]
 *  [X, 2, 3, 1, X]
 *  [1, X, X, X, 1]
 *  ]
 *
 * [풀이]
 * [][] 이렇게 있을 때 y와 x축 모두 순서대로 돈다고 치면 위와 좌측만 확인하면 될 듯.
 *
 * 1. 주어진 값을 이차원 배열로 만든다.
 * 2. 이차원 배열을 순회하면서 이어진 것 끼리는 무조건 하나의 map<Integer, List<String>에 묶어줄 예정이다 .이를 위해 map을 하나 만든다.
 *  * 어차피 모든 값을 순회하기 때문에 왼쪽과 위쪽만 확인하면 된다.
 * 3. key값을 점진적으로 늘려주기 위해 포인터를 선언해준다
 * 4. 값이 x가 아닐 시
 *  4.1. x, y 모두 값이 0이 아닐 시
 *      4.1.1. x-1, y-1모두 값이 있을 시
 *          4.1.1.1. value중 x-1 위치와 y-1값을 찾아 그 둘의 키값이 같은지 확인한다.
 *              4.4.1.1.1. 같다면 그 키값에 해당 위치의 index까지 넣는다.
 *              4.4.1.1.2. 다르다면 x-1 키값에 모두 합친 후 현재 위치의 index까지 value로 넣는다.
 *      4.1.2. x-1에만 값이 있을 시
 *          4.1.2.1. value중 x-1 위치를 value를 넣는다.
 *      4.1.3. y-1에만 값이 있을 시
 *          4.1.3.1. value중 y-1 위치를 value를 넣는다.
 *
 *  4.2. x값만 0일 시
 *      4.2.1. x-1 값은 확인하지 않는다.
 *      4.2.2. y-1 위치만 확인한다
 *          4.2.2.1. "X"가 아니면 해당 위치의 key값을 찾아 그 key값에 넣는다.
 *  4.3. y값만 0일 시
 *      4.2.1. y-1 값은 확인하지 않는다.
 *      4.2.2. x-1 위치만 확인한다
 *          4.2.2.1. "X"가 아니면 해당 위치의 key값을 찾아 그 key값에 넣는다.
 *  4.4. x, y값 모두 0일 시
 *      4.4.1. 그냥 map에 넣고 key는 하나 플러스
 *
 * 5. 최종적으로 만들어진 map을 가지고 key를 기준으로 value의 인덱스를 찾아 합을 누적해주는 map을 만든 후 오름차순을 소팅한다.
 *
 *
 */
public class 무인도여행 {

    public static void main(String[] args) {

    }

    public static int[] solution(String[] maps) {

        //1. 주어진 값을 이차원 배열로 만든다.
        String[][] mapsArray = new String[100][100];

        for(int i=0; i<maps.length; ++i) {
            mapsArray[i] = maps[i].split("");
        }

        //2. 이차원 배열을 순회하면서 이어진 것 끼리는 무조건 하나의 map<Integer, List<String>에 묶어줄 예정이다 .이를 위해 map을 하나 만든다.
        Map<Integer, List<String>> mapsMap = new HashMap<>();

        //3. key값을 점진적으로 늘려주기 위해 포인터를 선언해준다
        int keyPointer = 0;


        for(int y=0; y<mapsArray.length; ++y) {
            for(int x=0; x<mapsArray[y].length; ++x) {

                //4. 값이 X가 아닐 시
                if (!mapsArray[y][x].equals("X")) {

                    //4.1. x, y 모두 값이 0이 아닐 시
                    if (x > 0 && y > 0) {


                        //4.1.1. x-1, y-1모두 값이 있을 시
                        if (!mapsArray[y-1][x].equals("X") && !mapsArray[y][x-1].equals("X")) {

                            String top = mapsArray[y-1][x];
                            String left = mapsArray[y][x-1];


                            int leftKey = 0;
                            int topKey = 0;

                            //4.1.1.1. value중 x-1 위치와 y-1값을 찾아 그 둘의 키값이 같은지 확인한다.
                            for(Map.Entry<Integer, List<String>> entry : mapsMap.entrySet()) {

                                if (entry.getValue().contains(y-1+","+x)) {
                                    topKey = entry.getKey();
                                }

                                if (entry.getValue().contains(y+","+(x-1))) {
                                    leftKey = entry.getKey();
                                }

                                if (topKey>0 && leftKey>0) {
                                    break;
                                }
                            }

                            //4.4.1.1.1. 같다면 그 키값에 해당 위치의 index까지 넣는다.
                            if (leftKey == topKey) {
                                mapsMap.get(leftKey).add(y+","+x);
                            //4.4.1.1.2. 다르다면 x-1 키값에 모두 합친 후 현재 위치의 index까지 value로 넣는다.
                            } else {

                                for(String s : mapsMap.get(topKey)) {
                                    mapsMap.get(leftKey).add(s);
                                }
                                mapsMap.get(leftKey).add(y+""+x);
                                mapsMap.get(topKey).clear();

                            }






                        }


                    }


                }

            }
        }


        return null;
    }

}

package technical.english;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvGenerator {
    public static void main(String[] args) {
        String fileName = "sentences.csv";
        StringBuilder data = new StringBuilder();

        // 헤더 추가
        data.append("번호,한국어 번역,영어 문장\n");

        // 데이터 추가
        data.append("1,저는 소프트웨어 개발자입니다.,I am a software developer.\n");
        data.append("2,우리는 새로운 프로젝트를 진행하고 있습니다.,We are working on a new project.\n");
        data.append("3,코드를 최적화해야 합니다.,The code needs to be optimized.\n");
        data.append("4,제 코드를 리뷰해 주실 수 있나요?,Could you review my code?\n");
        data.append("5,시스템에서 버그를 발견했습니다.,I found a bug in the system.\n");
        data.append("6,내일 미팅을 합시다.,Let's have a meeting tomorrow.\n");
        data.append("7,애플리케이션이 원활하게 실행되고 있습니다.,The application is running smoothly.\n");
        data.append("8,새로운 프로그래밍 언어를 배워야 합니다.,I need to learn a new programming language.\n");
        data.append("9,문서를 업데이트해 주세요.,Please update the documentation.\n");
        data.append("10,서버가 다운되었습니다.,The server is down.\n");
        data.append("11,최대한 빨리 문제를 해결하겠습니다.,I will fix the issue as soon as possible.\n");
        data.append("12,제안사항이 있으신가요?,Do you have any suggestions?\n");
        data.append("13,마감일이 다가오고 있습니다.,The deadline is approaching.\n");
        data.append("14,소프트웨어를 철저히 테스트해야 합니다.,We should test the software thoroughly.\n");
        data.append("15,다음 주에 컨퍼런스에 참석합니다.,I am attending a conference next week.\n");
        data.append("16,이 작업에 협업합시다.,Let's collaborate on this task.\n");
        data.append("17,프로젝트에 대한 추가 정보가 필요합니다.,I need more information about the project.\n");
        data.append("18,고객이 몇 가지 변경을 요청했습니다.,The client requested some changes.\n");
        data.append("19,오늘은 재택 근무 중입니다.,I'm working remotely today.\n");
        data.append("20,사용자 인터페이스가 깔끔하고 현대적으로 보입니다.,The user interface looks clean and modern.\n");
        data.append("21,확장성을 고려해야 합니다.,We should consider scalability.\n");
        data.append("22,브랜치를 병합해 주세요.,Please merge the branches.\n");
        data.append("23,웹 개발 경력이 있습니다.,I have experience in web development.\n");
        data.append("24,보안이 최우선입니다.,Security is our top priority.\n");
        data.append("25,오늘 밤에 업데이트를 배포하겠습니다.,I will deploy the updates tonight.\n");
        data.append("26,요구사항을 이해하셨나요?,Do you understand the requirements?\n");
        data.append("27,코드베이스를 리팩토링합시다.,Let's refactor the codebase.\n");
        data.append("28,도와주셔서 감사합니다.,I appreciate your help.\n");
        data.append("29,소프트웨어는 사용자 친화적이어야 합니다.,The software needs to be user-friendly.\n");
        data.append("30,언제든지 편하게 연락 주세요.,Feel free to contact me anytime.\n");

        // 파일에 데이터 쓰기
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data.toString());
            System.out.println(fileName + " 파일이 성공적으로 생성되었습니다.");
        } catch (IOException e) {
            System.err.println("파일을 생성하는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}


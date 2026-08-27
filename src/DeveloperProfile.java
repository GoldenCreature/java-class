import java.util.Scanner;

public class DeveloperProfile {
    public static void main(String[] args) {
        // 콘솔 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // nextLine()으로 한 줄 전체를 받고, trim()으로 앞뒤 공백 제거
        // 사용자가 실수로 스페이스를 붙여 입력해도 안전하게 처리
        System.out.print("이름: ");
        String name = scanner.nextLine().trim();

        System.out.print("희망 직무: ");
        String role = scanner.nextLine().trim();

        System.out.print("GitHub 주소: ");
        String githubUrl = scanner.nextLine().trim();

        // 문자열로 먼저 받은 뒤 Integer.parseInt()로 숫자 변환
        // nextInt() 대신 nextLine()+parseInt()를 쓰면 nextInt/nextLine 혼용 버그를 피할 수 있음
        System.out.print("Java 학습 개월 수: ");
        String monthsText = scanner.nextLine().trim();
        int studyMonths = Integer.parseInt(monthsText);

        // 위와 같은 패턴, 한 줄로 줄여서 작성 (중간 변수 없이 바로 parseInt에 전달)
        System.out.print("프로젝트 수: ");
        int projectCount = Integer.parseInt(
                scanner.nextLine().trim());

        // Boolean.parseBoolean(): "true"(대소문자 무관)면 true, 그 외 전부 false
        System.out.print("즉시 취업 가능(true/false): ");
        boolean available = Boolean.parseBoolean(
                scanner.nextLine().trim());

        // 자기소개도 다른 항목들과 같은 패턴: nextLine()으로 한 줄 받고 trim()으로 공백 제거
        System.out.print("자기소개: ");
        String introduction = scanner.nextLine().trim();

        // ===== 출력 =====

        // "\n"으로 출력 전에 빈 줄 하나 추가 (구분선 느낌)
        System.out.println("\n개발자 프로필");

        // printf: C#의 문자열 포맷(Console.Write와 {0} 방식)과 비슷한 개념
        // %s = 문자열, %d = 정수, %b = boolean, %n = OS에 맞는 줄바꿈
        System.out.printf("이름: %s%n", name);
        System.out.printf("희망 직무: %s%n", role);
        System.out.printf("GitHub: %s%n", githubUrl);
        System.out.printf("학습 기간: %d개월%n", studyMonths);
        System.out.printf("프로젝트: %d개%n", projectCount);
        System.out.printf("즉시 가능: %b%n", available);
        System.out.printf("자기소개: %s%n", introduction);  // 이제 정상적으로 참조 가능

        // 다 쓴 Scanner 자원 반납
        scanner.close();
    }
}
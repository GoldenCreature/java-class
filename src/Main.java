import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 콘솔(System.in)로부터 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        System.out.print("나이: ");

        // nextInt(): 공백/개행 전까지의 "숫자"만 읽어서 int로 반환
        // 주의: 사용자가 엔터를 쳐서 딸려온 개행문자("\n")는 안 읽고 버퍼에 그대로 남겨둠
        int age = scanner.nextInt();

        // 바로 위 nextInt()가 남겨둔 개행문자("\n")를 여기서 그냥 읽어서 버림
        // 이 줄이 없으면 바로 다음 nextLine()이 이 찌꺼기 개행을 읽어버려서
        // name이 사용자 입력을 받지도 못하고 빈 문자열("")이 되는 버그가 발생함
        scanner.nextLine();

        System.out.print("이름: ");

        // 이제 버퍼가 깨끗하게 비워진 상태라 정상적으로 사용자 입력을 기다림
        String name = scanner.nextLine();

        // 문자열 + int를 이어 붙이면 자바가 int를 자동으로 문자열로 변환해서 이어붙임
        // (String.valueOf(age)가 내부적으로 호출되는 것과 같은 효과)
        System.out.println("반갑습니다, " + name + " " + age);

        // 다 쓴 Scanner 자원 반납
        scanner.close();
    }
}
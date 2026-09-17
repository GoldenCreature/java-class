import java.util.Scanner;

class StudentEntry {
    String studentId;
    String name;
}

public class FinalEventCheckIn_student {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentEntry[] entries = new StudentEntry[5];

        while (true) {
            System.out.println("\n[취업 특강 접수]");
            System.out.println("1 신청  2 명단  3 취소  4 현황  0 종료");
            System.out.print("선택: ");
            String menu = scanner.nextLine().trim();

            if (menu.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (menu) {
                case "1":
                    System.out.print("학번: ");
                    String studentId = scanner.nextLine().trim();
                    System.out.print("이름: ");
                    String name = scanner.nextLine().trim();

                    // TODO 1. 빈 학번이나 빈 이름은 거절하세요.
                    if(studentId.isEmpty() || name.isEmpty()){
                        System.out.println("학번과 이름, 모두 빈곳 없이 입력해주세요.");
                        break;
                    }
                    // TODO 2. 같은 학번이 이미 있는지 배열 전체를 확인하세요.
                    for(int i = 0; i < entries.length; i++)
                    {
                        if(entries[i] != null && entries[i].studentId.equals(studentId))
                        {
                            System.out.println("이미 등록된 학번입니다.");
                            break;
                        }

                        // TODO 3. null인 첫 칸을 찾고 StudentEntry 객체를 저장하세요.
                        if(entries[i] == null){
                            entries[i] = new StudentEntry();
                            entries[i].studentId = studentId;
                            entries[i].name = name;
                            break;
                        }
                    }
                    // TODO 4. 다섯 칸이 모두 찼다면 정원 마감을 출력하세요.
                    for(int i = 0; i < entries.length; i++)
                    {
                        boolean check = false;
                        if(entries[i] != null) check = true;
                        if(!check) System.out.println("정원이 마감되었습니다.");
                    }
                    //System.out.println("신청 기능을 완성해 보세요.");
                    break;

                case "2":
                    // TODO 5. null을 건너뛰며 위치, 학번, 이름을 출력하세요.
                    boolean check = false;
                    for(int i = 0; i < entries.length; i++)
                    {
                        if(entries[i] != null && entries[i].studentId != null)
                        {
                            System.out.println("위치 : " + (i + 1) + " 번째 자리입니다.");
                            System.out.println("학번 : " + entries[i].studentId);
                            System.out.println("이름 : " + entries[i].name);
                            check = true;
                        }
                    }
                    // 아무도 없으면 "등록된 신청자가 없습니다."를 출력하세요.
                    if(!check) System.out.println("등록된 신청자가 없습니다.");
                    break;

                case "3":
                    System.out.print("취소할 학번: ");
                    String cancelId = scanner.nextLine().trim();
                    boolean samecheck = false;
                    // TODO 6. 학번을 찾아 해당 칸에 null을 넣으세요.
                    for(int i = 0; i < entries.length; i++)
                    {
                        if(entries[i] != null && entries[i].studentId.equals(cancelId))
                        {
                            samecheck = true;
                            System.out.println(entries[i].name + "님의 신청이 취소되었습니다.");
                            entries[i] = null;
                            break;
                        }
                        samecheck = false;
                    }
                    // 없는 학번이라면 그 사실을 알려 주세요.
                    if(!samecheck)System.out.println("해당하는 학번이 없습니다.");
                    break;

                case "4":
                    // TODO 7. null이 아닌 칸을 세어 현재 인원과 남은 자리를 출력하세요.
                    int count = 0;
                    for(int i = 0; i < entries.length; i++)
                    {
                        if(entries[i] != null)
                        {
                            System.out.println(entries[i].name + "학생 등록 중");
                            count++;
                        }
                    }
                    System.out.println("총 " + count +"명이 등록중이며 남은자리는 " +
                            (entries.length - count) + "자리 입니다.");
                    break;

                default:
                    System.out.println("0부터 4까지 선택하세요.");
            }
        }
    }
}

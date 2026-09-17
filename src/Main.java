import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        String[] participants = new String[3];
        System.out.println(participants.length);
        System.out.println(participants[0]);
        participants[0] = "김서윤";
        participants[1] = "한종수";
        System.out.println(participants[0].length());

        String[] names = {"김서윤", null};
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null) {
                System.out.println("빈 자리");
                continue;
            }
            System.out.println(names[i]);
        }

        String searchName = "한종수";
        boolean found = false;
        for (String participant : participants) {
            if (participant != null && participant.equals(searchName)) {
                found = true;
                break;
            }
        }
        System.out.println(found);
    }
}
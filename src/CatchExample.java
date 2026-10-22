public class CatchExample {
    public static void main(String[] args) {
        try {
            int quantity = Integer.parseInt("열개 ");
            System.out.println(quantity);
        } catch (NumberFormatException e) {
            System.out.println("숫자로 입력하세요");
        } finally {
            System.out.println("검사 종료");
        }

    }
}


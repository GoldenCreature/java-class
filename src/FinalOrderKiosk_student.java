import java.util.Scanner;

/*
 * [최종 실습 4] 학과 행사 간식 주문 키오스크
 *
 * 메뉴와 가격
 * 1. 커피 2,500원
 * 2. 샌드위치 4,500원
 * 3. 생수 1,000원
 * 4. 결제
 * 0. 주문 취소
 *
 * 주문 규칙
 * - 상품 수량은 1개 이상이어야 한다.
 * - 결제 전에 선택한 상품이 없으면 메뉴로 돌아간다.
 * - 주문 금액이 50,000원 이상이면 10% 할인한다.
 * - 주문 금액이 30,000원 이상 50,000원 미만이면 5% 할인한다.
 * - 그 외에는 할인하지 않는다.
 * - 결제가 끝나면 영수증을 출력하고 프로그램을 끝낸다.
 * - 0을 입력하면 결제하지 않고 주문을 취소한다.
 *
 * 확인할 상황
 * 1. 상품 없이 4 입력 -> "먼저 상품을 선택하세요."
 * 2. 수량에 0 입력 -> 다시 수량 입력
 * 3. 0~4 이외의 번호 입력 -> 메뉴 번호 안내
 * 4. 30,000원과 50,000원 경계에서 할인율 확인
 *
 * 주의
 * 현재 파일은 컴파일되지만 TODO의 빈 문자열, 0, false는 임시값이다.
 * 한 TODO를 해결할 때마다 직접 실행해서 주문 금액이 맞는지 확인한다.
 */
public class FinalOrderKiosk_student {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int coffeeCount = 0;
        int sandwichCount = 0;
        int waterCount = 0;
        int orderAmount = 0;
        boolean paid = false;

        orderLoop:
        while (true) {
            System.out.println("\n===== 학과 행사 간식 주문 =====");
            System.out.println("1. 커피 2,500원");
            System.out.println("2. 샌드위치 4,500원");
            System.out.println("3. 생수 1,000원");
            System.out.println("4. 결제");
            System.out.println("0. 주문 취소");
            System.out.print("메뉴를 선택하세요: ");

            int menu = scanner.nextInt();

            // TODO 1: 상품을 선택한 경우에만 이 영역으로 들어가도록 조건을 작성한다.
            if (menu > 0 && menu <= 3) {
                // TODO 2: 메뉴 번호에 맞는 상품명을 switch 식으로 완성한다.
                String productName = switch (menu) {
                    case 1 -> "커피";
                    case 2 -> "샌드위치";
                    default -> "생수";
                };

                // TODO 3: 메뉴 번호에 맞는 가격을 switch 식으로 완성한다.
                int price = switch (menu) {
                    case 1 -> 2_500;
                    case 2 -> 4_500;
                    default -> 1_000;
                };

                int quantity;

                do {
                    System.out.print(productName + " 수량을 입력하세요: ");
                    quantity = scanner.nextInt();

                    // TODO 4: 사용할 수 없는 수량을 판별한다.
                    if (quantity <= 0) {
                        System.out.println("수량은 1개 이상이어야 합니다.");
                    }

                // TODO 5: 올바른 수량이 들어올 때까지 반복하는 조건을 작성한다.
                } while (quantity <= 0);

                // TODO 6: 선택한 상품의 개수를 알맞은 변수에 누적한다.
                if (productName.equals("커피")) {
                    coffeeCount += quantity;
                } else if (productName.equals("샌드위치")) {
                    sandwichCount += quantity;
                } else {
                    waterCount += quantity;
                }

                // TODO 7: 이번에 선택한 상품의 금액을 전체 주문 금액에 반영한다.
                orderAmount += price * quantity;
                System.out.println(productName + " " + quantity + "개를 담았습니다.");
                System.out.println("현재 주문 금액: " + orderAmount + "원");
                continue;
            }

            // TODO 8: 결제 메뉴를 선택한 경우의 조건을 작성한다.
            if (menu == 4) {
                // TODO 9: 담은 상품이 하나도 없는 경우를 판별한다.
                if (orderAmount == 0) {
                    System.out.println("먼저 상품을 선택하세요.");
                    continue;
                }

                int discountRate;

                // TODO 10: 주문 금액에 맞는 할인율을 결정한다.
                if (orderAmount >= 50_000) {
                    discountRate = 10;
                } else if (orderAmount >= 30_000 && orderAmount <= 50_000) {
                    discountRate = 5;
                } else {
                    discountRate = 0;
                }

                // TODO 11: 할인 금액과 최종 결제 금액을 계산한다.
                int discountAmount = (orderAmount * discountRate) / 100;
                int paymentAmount = orderAmount - discountAmount;

                // TODO 12: for문의 초기식, 조건식, 증감식을 직접 작성한다.
                for (int i = 1; i < orderAmount; i += 1) {
                    System.out.print("=");
                }
                System.out.println();
                System.out.println("커피: " + coffeeCount + "개");
                System.out.println("샌드위치: " + sandwichCount + "개");
                System.out.println("생수: " + waterCount + "개");
                System.out.println("주문 금액: " + orderAmount + "원");
                System.out.println("할인율: " + discountRate + "%");
                System.out.println("할인 금액: " + discountAmount + "원");
                System.out.println("결제 금액: " + paymentAmount + "원");

                // TODO 13: 결제 완료 상태를 기록한다.
                paid = true;
                break orderLoop;
            }

            // TODO 14: 주문 취소 메뉴를 선택한 경우의 조건을 작성한다.
            if (menu == 0) {
                break orderLoop;
            }

            System.out.println("0부터 4까지의 메뉴 번호를 입력하세요.");
        }

        if (paid) {
            System.out.println("결제가 완료되었습니다.");
        } else {
            System.out.println("주문을 취소했습니다.");
        }

        scanner.close();
    }
}

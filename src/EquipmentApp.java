public class EquipmentApp {
    public static void main(String[] args) {
        // TODO 9. 이름만 받는 생성자로 노트북, 이름·요금(2000)으로 카메라를 만드세요.
        Equipment laptop = new Equipment("노트북");
        Equipment camera = new Equipment("카메라", 2_000);
        // 완성 전에도 실행되도록 null 상태에서는 중단합니다.
        if (laptop == null || camera == null) {
            System.out.println("TODO 9의 객체 생성부터 완성하세요.");
            return;
        }
        System.out.println("전체 장비 수: " + Equipment.getEquipmentCount());
        // TODO 10. 첫 대여 결과와 두 객체의 실제 상태를 출력하도록 바꾸세요.
        System.out.println("노트북 3일 대여 성공: " + laptop.rent(3));
        System.out.println("노트북 대여 중: " + laptop.isRented());
        System.out.println("카메라 대여 중: " + camera.isRented());
        // TODO 11. 중복·0일·15일·14일 요청과 기존 기간을 실제 호출로 확인하세요.
        System.out.println("노트북 중복 대여 성공: " + laptop.rent(3));
        System.out.println("노트북 기존 대여 기간: " + laptop.getRentalDays());
        System.out.println("카메라 0일 대여 성공: " + camera.rent(0));
        System.out.println("카메라 15일 대여 성공: " + camera.rent(15));
        System.out.println("카메라 14일 대여 성공: " + camera.rent(14));
        // TODO 12. 반납·기본 대여·음수 요금 보정을 실행하고 상태를 조회하세요.
        laptop.returnEquipment();
        System.out.println("노트북 반납 뒤 상태: " + laptop.isRented() + "/" + laptop.getRentalDays());
        laptop.rent();
        System.out.println("노트북 기본 대여: " + laptop.isRented() + "/" + laptop.getRentalDays());
        laptop.setDailyFee(-1000);
        System.out.println("음수 요금 보정: " + laptop.getDailyFee());
    }
}

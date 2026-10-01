public class Equipment {
    // TODO 1. 최대 대여 기간을 14로 바꾸세요.
    public static final int MAX_RENTAL_DAYS = 14;
    // TODO 2. 모든 객체가 공유하는 개수인지 선언을 확인하세요.
    private static int equipmentCount;
    // TODO 3. 이름 고정과 개별 상태의 접근 범위를 확인하세요.
    private final String name;
    private boolean rented;
    private int rentalDays;
    private int dailyFee;

    public Equipment(String name) {
        this(name, 1000);
    }
    public Equipment(String name, int dailyFee) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("장비 이름이 필요합니다.");
        }
        this.name = name;
        setDailyFee(dailyFee);
        // TODO 4. 이름 저장(this.name) 확인 후 생성 개수를 증가시키세요.
        equipmentCount++;
    }
    public boolean rent() {
        return rent(1);
    }
    public boolean rent(int days) {
        // TODO 5. 이미 대여 중이거나 1~최대 기간 밖이면 false를 반환하세요.
        if(this.rented || (days < 1 || days > MAX_RENTAL_DAYS))
        {
            return false;
        }
        // TODO 6. 대여 상태와 기간을 저장하고 true를 반환하세요.
        this.rented = true;
        rentalDays = days;
        return true;
    }
    public void returnEquipment() {
        // TODO 7. 대여 상태와 기간을 함께 초기화하세요.
        this.rented = false;
        this.rentalDays = 0;
    }
    public String getName() { return this.name; }
    public boolean isRented() {
        // TODO 8. 현재 대여 상태를 반환하세요.
        return this.rented;
    }
    public int getRentalDays() { return rentalDays; }
    public int getDailyFee() { return dailyFee; }
    public void setDailyFee(int dailyFee) {
        if (dailyFee < 0) {
            this.dailyFee = 0;
            return;
        }
        this.dailyFee = dailyFee;
    }
    public static int getEquipmentCount() {
        return equipmentCount;
    }
}

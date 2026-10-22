public class ThrowExample {
    public static void main(String[] args){
        int quantity =-1;
        if(quantity < 0){
            throw new IllegalArgumentException("수량은 0 이상입니다.");
        }
        System.out.println("등록 완료");
    }
}

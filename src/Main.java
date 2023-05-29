public class Main {
    public static void main(String[] args) {

        Kiosk kiosk = new Kiosk();
        while (true) {
            // 메인화면에서 숫자 선택 1,2,3,4(메뉴),5,6(장바구니,장바구니 취소)
            int selectMainMenu = kiosk.selectMainMenu();

            switch (selectMainMenu) {
                case 1,2,3,4 -> {
                    // 선택한 입력값을 전달하여 카테고리 메뉴 출력
                    kiosk.setMenuInfo(selectMainMenu);
                    // 장바구니 추가 여부 묻기
                    int checkBasket = kiosk.checkBasket();
                    // 선택한 입력값을 전달하여 장바구니 저장 메세지 출력
                    kiosk.addBasket(checkBasket);
                }
                case 5 -> {
                    // 주문 완료 화면
                    kiosk.selectOrderSuccess(selectMainMenu);
                    //1. 주문 2. 메뉴판 출력
                    int selectCheckOrder = kiosk.checkOrder();
                    // 1. 주문 2. 메뉴판 선택
                    kiosk.orderOk(selectCheckOrder);
                }
                case  6 -> {
                    // 진행하던 주문을 취소하시겠습니까?
                    // 1. 확인   2. 취소 선택
                    int checkCancel = kiosk.checkCancel();
                    // 1. 확인   2. 취소 선택
                    kiosk.printCancel(checkCancel);
                    // 주문이 완료되었습니다
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }
}




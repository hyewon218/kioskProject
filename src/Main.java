public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        CategoryMenu categoryMenu = new CategoryMenu();
        // 반복을 어떻게 해야할까??
        //for (int i = 0; i < 10; i++) {
            int selectMainMenu = kiosk.selectMainMenu();
            // 선택한 입력값을 전달하여 카테고리 메뉴 출력
            kiosk.setMenuInfo(selectMainMenu);
            // 장바구니 추가 여부 묻기
            int checkBasket = kiosk.checkBasket();
            // 선택한 입력값을 전달하여 장바구니 저장 메세지 출력
            kiosk.addBasket(checkBasket);
            // selectMainMenu 값이 새롭게 들어가야 하는데 위에서 들어간 값으로 들어감...
            // 새로운 변수 생성
            int selectOrderMenu = kiosk.selectMainMenu();
            // 주문을 또 시킬 수 있음
            // 메인메뉴가 다시 출려되어 장바구니에 또 담을 수 있음.
            // 주문 완료 화면 vs 주문 취소 화면 선택
            kiosk.selectOrderOrCancel(selectOrderMenu);
            //1. 주문 2. 메뉴판 출력
            int selectCheckOrder = kiosk.checkOrder();
            //1. 주문 2. 메뉴판 선택
            kiosk.orderOk(selectCheckOrder);
        //}
        /////////////////윗부분 반복해야..////////////////////
    }
}




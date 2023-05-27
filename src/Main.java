import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        CategoryMenu categoryMenu = new CategoryMenu();
        ArrayList<String> orderList = new ArrayList<String>();
        // 메인 메뉴 출력
        int selectMainMenu = kiosk.selectMainMenu();
        // 카테고리 메뉴 출력
            if (selectMainMenu == 1) {
                int selectBurgersMenu = kiosk.selectBurgersMenu();//또실행됨...->변수처리하여 해결!
                categoryMenu.setBurgerInfo(selectBurgersMenu);// categoryMenu.toString()에 정보를 주기 위해 카테고리에서 선택한 번호 전달
            } else if (selectMainMenu == 2) {
                int selectForzenMenu = kiosk.selectForzenMenu();
                categoryMenu.setFrozenInfo(selectForzenMenu);
            } else if (selectMainMenu == 3) {
                int selectDrinksMenu = kiosk.selectDrinksMenu();
                categoryMenu.setDrinkInfo(selectDrinksMenu);
            } else if (selectMainMenu == 4) {
                int selectBeerMenu = kiosk.selectBeerMenu();
                categoryMenu.setBeerInfo(selectBeerMenu);
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        // "Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거" 출력
        System.out.println(categoryMenu.toString());
        int checkBasket = kiosk.checkBasket();
        if (checkBasket == 1) {
            System.out.println(categoryMenu.getCategoryMenuName() + "가 장바구니에 추가되었습니다.");
            //실제로 장바구니에 추가하기
            orderList.add(categoryMenu.toString());
            System.out.println();
            //메인메뉴로 다시 출력됩니다.
        } else if (checkBasket == 2) {
            System.out.println("전단계로 돌아가기?");
        } else{
            System.out.println("움");
        }
        //5.Order 입력시 장바구니 목록을 출력해줍니다.
        //메인 메뉴 출력 후 선택
       if(kiosk.selectMainMenu() == 5) {
           System.out.println("아래와 같이 주문 하시겠습니까?");
           System.out.println();
           System.out.println("[ Orders ]");
           //}
           for (int i = 0; i < orderList.size(); i++) {
               System.out.println(orderList.get(i));
           }
       }
        int checkOrder = kiosk.checkOrder();
            // 5강 듣고 추가하기!!!!!!!!!!!!!!!!!!!!!
            int waitingNUMB =0;
            int thread=0;
            if (checkOrder==1) {
                System.out.println("주문이 완료되었습니다!");
                System.out.println();
                System.out.println("대기번호는 [ "+waitingNUMB+"] 번 입니다.");
                System.out.println(thread+"초후 메뉴판으로 돌아갑니다.");
            }else if(checkOrder==2) {
                kiosk.selectMainMenu();
            } else {
                System.out.println("잘못된 입력입니다.");
            }
            //3초후메인화면다시
            //주문취소할때
        if (kiosk.selectMainMenu()==6) {
            int checkCancel = kiosk.checkCancel();
            if(checkCancel==1) {
                //장바구니 초기화
                System.out.println("진행하던 주문이 취소되었습니다.");
                System.out.println();
                kiosk.selectMainMenu();
            }
        }
    }
}


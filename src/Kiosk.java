import java.util.ArrayList;
import java.util.Scanner;

//사용자의 동작에 대해서 만든 클래스
public class Kiosk extends CategoryMenu {
    public Scanner sc = new Scanner(System.in);

    //메인 메뉴 선택
    public int selectMainMenu() {
        //선택지 보여주기
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("1. Burgers         | 앵거스 비프 통살을 다져만든 버거");
        System.out.println("2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림");
        System.out.println("3. Drinks          | 매장에서 직접 만드는 음료");
        System.out.println("4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주");

        System.out.println("[ ORDER MENU ]");
        System.out.println("5. Order       | 장바구니를 확인 후 주문합니다.");
        System.out.println("6. Cancel      | 진행중인 주문을 취소합니다.");

        String result = sc.nextLine();
        return Integer.parseInt(result);
    }
    //카테고리 메뉴 선택
    public int selectBurgersMenu() {
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ Burgers MENU ]");
        System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        System.out.println("3. Shroom Burger | W 9.4 | 몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거");
        System.out.println("4. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        System.out.println("5. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
        String result = sc.nextLine();
        return Integer.parseInt(result);
    }
    public int selectForzenMenu() {
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ Forzen Custard ]");
        System.out.println("1. Shack                | W 5.9 | 바닐라, 초콜렛, 솔티드 카라멜, 블랙&화이트, 스트로베리, 피넛버터, 커피");
        System.out.println("2. Shack of the Week    | W 6.5 | 특별한 커스터드 클레이버");
        System.out.println("3. Red Bean Shake       | W 6.5 | 신선한 커스터드와 함께 우유와 레드빈이 블랜딩 된 시즈널 쉐이크");
        System.out.println("4. Floats               | W 5.9 | 루트 비어, 퍼플 카우, 크림시클");
        String result = sc.nextLine();
        return Integer.parseInt(result);
    }
    public int selectDrinksMenu() {
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ Drinks ]");
        System.out.println("1. Shack-made Lemonade      | W 3.9 | 매장에서 직접 만드는 상큼한 레몬에이드");
        System.out.println("2. Fresh Brewed Iced Tea    | W 3.4 | 직접 유기농 홍차를 우려낸 아이스티");
        System.out.println("3. Fifty/Fifty              | W 3.5 | 레몬에이드와 아이스티의 만남");
        String result = sc.nextLine();
        return Integer.parseInt(result);
    }
    public int selectBeerMenu() {
        System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println();
        System.out.println("[ Beer ]");
        System.out.println("1. ShackMeister Ale   | W 9.8 | 쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주");
        System.out.println("2. Magpie Brewing Co. | W 6.8 | 맥파이 페일에일은 맥파이에서 출시한 첫 맥주이자 가장 인기 있는 맥주");
        String result = sc.nextLine();
        return Integer.parseInt(result);
    }
    //상품 선택시 해당 상품을 장바구니에 추가할지 확인하는 문구가 출력됩니다.
    @Override
    public String toString() {
        return super.toString();
    }

    //장바구니 추가 여부 묻기
    //1.확인 입력시 장바구니에 추가되었다는 안내문구와 함께 메인메뉴로 다시 출력됩니다.
    public int checkBasket() {
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인               2.취소");
        String result = sc.nextLine();
        return Integer.parseInt(result);
    }
    public void addBasket() {

        // 장바구니 저장 메서드!!!!!
        System.out.println();
        //메인메뉴로 다시 출력됩니다.
        selectMainMenu();
    }
    //장바구니에서는 추가된 메뉴들과 총 가격의 합을 출력해줍니다.
    public String printTotalPrice() {
        System.out.println("[ Total ]");
        System.out.println("w " + (totalPrice() * 0.01));
        return null;
    }
    public int checkOrder() {
        System.out.println("1. 주문     2. 메뉴판");

        String result = sc.nextLine();
        return Integer.parseInt(result);
    }
    //1.주문 입력시 주문완료 화면으로 넘어가고, 2.메뉴판 입력시 다시 메인메뉴로 돌아옵니다.
    public void orderOk() {
        if (checkOrder() == 1) {
            printOrderOk();
        } else if (checkOrder() == 2) {
            selectMainMenu();
        }
    }
    //주문 완료 화면
    //1.주문 입력시 대기번호를 발급해줍니다.(쓰레드?)
    //장바구니는 초기화되고 3초후에 메인 메뉴판으로 돌아갑니다.(sleep?)
    public void printOrderOk() {
        int waitingNum = 0;
        System.out.println("주문이 완료되었습니다!");
        System.out.println();
        System.out.println("대기번호는 [ " + waitingNum + " ] 번입니다.");
        //장바구니 초기화
        //order
        System.out.println("초 후에 메뉴판으로 돌아갑니다.");
        //3초후에 메인 메뉴판으로 돌아갑니다.(sleep?)
        selectMainMenu();
    }

    //메뉴판에서 6.Cancel 입력시 주문을 취소할지 확인을 요청하는 문구가 출력됩니다.
    public int checkCancel() {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1.  확인     2. 취소");

        String result = sc.nextLine();
        return Integer.parseInt(result);
    }

    //1.확인 을 입력하면 장바구니는 초기화되고 취소 완료 문구와 함께 메뉴판이 출력됩니다.
    public void printCancle() {
        System.out.println("진행하던 주문이 취소되었습니다.");
        selectMainMenu();
    }

    @Override
    public int getCategoryMenuNum() {
        return super.getCategoryMenuNum();
    }
}


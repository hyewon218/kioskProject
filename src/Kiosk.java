import java.util.*;

//사용자의 동작에 대해서 만든 클래스
public class Kiosk {
    // 장바구니 주문 리스트
    ArrayList<String> orderList = new ArrayList<String>();
    //총 주문목록 저장 (장바구니 리스트는 초기화됨)
    ArrayList<String> totalOrderList = new ArrayList<String>();
    ArrayList<String> totalSellingList = new ArrayList<String>();
    // 장바구니 가격 리스트
    ArrayList<Integer> priceList = new ArrayList<Integer>();
    // 총 판매 금액 리스트 (주문 완료될 때마다 쌓이는)
    ArrayList<Integer> totalPriceList = new ArrayList<Integer>();
    CategoryMenu categoryMenu = new CategoryMenu();
    Screen screen = new Screen();
    public Scanner sc = new Scanner(System.in);
    int waitingNum = 0;

    public void setup() {
        while (true) {
            // 메인화면에서 숫자 선택 1,2,3,4(메뉴),5,6(장바구니,장바구니 취소)
            int selectMainMenu = screen.selectMainMenu();
            switch (selectMainMenu) {
                case 1,2,3,4 -> {
                    // 선택한 입력값을 전달하여 카테고리 메뉴 출력
                    setMenuInfo(selectMainMenu);
                    // 장바구니 추가 여부 묻기
                    int checkBasket = checkBasket();
                    // 선택한 입력값을 전달하여 장바구니 저장 메세지 출력
                    addBasket(checkBasket);
                }
                case 5 -> {
                    // 주문 완료 화면
                    orderSuccess();
                    //1. 주문 2. 메뉴판 출력
                    int selectCheckOrder = checkOrder();
                    // 1. 주문 2. 메뉴판 선택
                    orderOk(selectCheckOrder);
                }
                case  6 -> {
                    // 진행하던 주문을 취소하시겠습니까?
                    // 1. 확인   2. 취소 선택
                    int checkCancel = checkCancel();
                    // 1. 확인   2. 취소 선택
                    printCancel(checkCancel);
                }
                // 선택 요구사항
                case 0 -> {
                    // 선택 요구사항 : 총 판매 금액 조회 기능 추가
                    printTotalSellingList();
                    System.out.println();
                    // 선택 요구사항 : 총 판매 상품 목록 조회 기능 추가
                    printTotalSellingPrice();
                    int back = back();
                    backMenu(back);
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }
    //selectMainMenu 결과값 받아서 카테고리 메뉴 정보 세팅
    public void setMenuInfo(int selectMainMenu) {
        if (selectMainMenu == 1) {
            int selectBurgersMenu = screen.selectBurgersMenu();
            categoryMenu.setBurgerInfo(selectBurgersMenu);
        } else if (selectMainMenu == 2) {
            int selectForzenMenu = screen.selectForzenMenu();
            categoryMenu.setFrozenInfo(selectForzenMenu);
        } else if (selectMainMenu == 3) {
            int selectDrinksMenu = screen.selectDrinksMenu();
            categoryMenu.setDrinkInfo(selectDrinksMenu);
        } else if (selectMainMenu == 4) {
            int selectBeerMenu = screen.selectBeerMenu();
            categoryMenu.setBeerInfo(selectBeerMenu);
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
    // 장바구니 추가 여부 묻기
    //1.확인 입력시 장바구니에 추가되었다는 안내문구와 함께 메인메뉴로 다시 출력됩니다.
    public int checkBasket() {
        System.out.println(categoryMenu.menuInfo());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인               2.취소");
        String result = sc.nextLine();
        return Integer.parseInt(result);
    }
    // 장바구니 추가 메서드
    public void addBasket(int checkBasket) {
        if (checkBasket == 1) {
            System.out.println(categoryMenu.getMainMenuName() + "가 장바구니에 추가되었습니다.");
            // 실제로 장바구니에 추가하기
            // [ order ] 목록 출력하기 위해 리스트에 메뉴 정보 저장
            orderList.add(orderInfo());
            // 주문 취소할 때 삭제???????????????????
            totalOrderList.add(totalOrderInfo());
            // 가격 [ total ] 구하기 위해 리스트에 가격 저장
            priceList.add(categoryMenu.getMenuPrice());
            System.out.println();
        } else if (checkBasket == 2) {
            //다시 메뉴 선택
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
    //장바구니 목록 출력 시 필요//////////////////////////////////
    // 5.Order 입력시 장바구니 목록 출력
    public void orderSuccess() {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");
        // 기존 장바구니 목록 (개수 포함 X)
        // printBasketList();
        // 개수 포함한 장바구니 목록
        menuNum();
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println(totalPriceInfo());
        System.out.println();
    }
    // 선택 요구사항 추가
    // 개수까지 포함한 출력 형식을 리스트로 담아서 보여준다.(중복 확인)
    // 장바구니에 똑같은 상품이 담기면 주문 화면에서 상품 개수가 출력되도록 한다.
    public void menuNum() {
        String info = "";
        // ArrayList 원소와 중복 횟수를 저장할 HashMap 객체를 준비
        Map<String, Integer> map = new HashMap<String, Integer>();
        // ArrayList를 순회하면서 ArrayList의 원소가 HashMap 객체에 key로 들어있는지 확인하고,
        // 만약 없으면 value(중복 횟수)를 1로 세팅하고 HashMap에 추가
        // 만약 있으면 중복되는 데이터 이므로 value(중복 횟수)를 1 증가시켜서 HashMap에 추가한다.
        // HashMap은 key의 중복을 허용하지 않으므로 같은 key 값이 추가되면 값을 덮어쓴다.
        for (String str : orderList) {
            Integer count = map.get(str);
            if (count == null) {
                map.put(str, 1);
            } else {
                map.put(str, count + 1);
            }
        }
        for (String menuName : map.keySet()) {
            info = menuName+" | "+map.get(menuName)+" 개";
            //System.out.println(info);
            String[] sp = info.split("\\|");
            String manuName = sp[0];
            String menuPrice = sp[1];
            String menuDescription = sp[2];
            String menuNum = sp[3];
            System.out.println(manuName+"|"+menuPrice+"|"+menuNum+" | "+menuDescription);
        }
    }
    // 장바구니에서는 추가된 메뉴들과 총 가격의 합을 출력해줍니다.
    public int totalPrice() {
        int total = 0;
            for (Integer price : priceList) {
            total += price;
            }
        return total;
    }
    // 선택 요구사항 : 총 판매금액 조회 기능 추가
    public int totalSellingPrice() {
        int totalSellingPrice = 0;
        for (Integer totalPrice : totalPriceList) {
            totalSellingPrice += totalPrice;
        }
        return totalSellingPrice;
    }

    /////////////////////////////////////////////////
    // 장바구니에서 1.주문 입력시 주문완료 화면으로 넘어가고, 2.메뉴판 입력시 다시 메인메뉴로 돌아옵니다.
    public int checkOrder() {
        System.out.println("1. 주문     2. 메뉴판");

        String result = sc.nextLine();
        return Integer.parseInt(result);
    }
    public void orderOk(int checkOrder) {
        if (checkOrder == 1) {
            printOrderOk();
        } else if (checkOrder == 2) {
            // 다시 메인화면으로.....
        }else {
            System.out.println("잘못된 입력입니다.");
        }
    }
    // 주문(구매) 완료 화면
    // 대기번호를 발급해줍니다.
    // 장바구니는 초기화되고 3초후에 메인 메뉴판으로 돌아갑니다.
    public void printOrderOk() {
        // 주문 완료 시 대기번호 1씩 증가
        waitingNum += 1;
        System.out.println("주문이 완료되었습니다!");
        // 선택 요구사항
        // 3. 구매가 완료될때마다 판매 상품, 가격 목록 저장
        // 장바구니 목록을 전체 목록에 추가
        totalSellingList.add(totalOrderList.toString());
        // 장바구니 초기화
        orderList.clear();
        System.out.println("구매완료 후 목록 쌓이는지 확인!!!!!!!!!!"+totalOrderList);
        // 장바구니 total 값을 totalPriceList에 추가추가
        totalPriceList.add(totalPrice());
        // 가격 초기화 (순서 주의!!!!!!!!!!!!)
        priceList.clear();
        System.out.println("주문 완료 될 때마다 총 판매 금액 누적 확인!!!!!!!"+totalPriceList);
        //menuNum();
        System.out.println();
        System.out.println("대기번호는 [ " + waitingNum + " ] 번입니다.");
        System.out.println("(3초 후에 메뉴판으로 돌아갑니다.)");
        // 3초 멈추기
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //메뉴판에서 6.Cancel 입력시 주문을 취소할지 확인을 요청하는 문구가 출력됩니다.
    public int checkCancel() {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1.  확인     2. 취소");

        String result = sc.nextLine();
        return Integer.parseInt(result);
    }
    // 6.Cancel 소 화면에서 1.확인 을 입력하면 장바구니는 초기화되고 취소 완료 문구와 함께 메뉴판이 출력됩니다.
    public void printCancel(int checkCancel) {
        if (checkCancel==1) {
            System.out.println("진행하던 주문이 취소되었습니다.");
            // 장바구니 초기화
            orderList.clear();
            // 가격 초기화
            priceList.clear();
            // 장바구니 목록 초기화
            totalOrderList.clear();
        } else if (checkCancel==2) {
            // 다시 메인화면으로...
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
    // 선택 요구사항 추가
    // 4. 총 판매상품 목록 조회 기능 추가
    // 기존 장바구니는 주문이 완료되거나 취소될 때 초기화가 된다.(새로운 리스트)
    public void printTotalSellingList() {
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 목록은 아래와 같습니다.");
        // - ShackBurger    | W 6.9
        // - Float          | W 2.9
        for (String list : totalSellingList) {
            System.out.println(list);
        }
    }
    public void printTotalSellingPrice() {
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은 [ "+totalSellingPriceInfo()+" ] 입니다.");
        System.out.println();
    }
    public int back() {
        System.out.println("1. 돌아가기");

        String result = sc.nextLine();
        return Integer.parseInt(result);
    }
    public void backMenu(int back) {
        if (back == 1) {

        }else {
            System.out.println("잘못된 입력입니다.");
        }
    }
    //////////////////출력형식/////////////////
    public String orderInfo() {
        double price = categoryMenu.getMenuPrice() * (0.001);
        return categoryMenu.getMainMenuName() + "     | w " + price + " | " + categoryMenu.getDescription();
    }
    // 구매가 완료될때마다 판매 상품 목록을 저장해줍니다.
    public String totalOrderInfo() {
        double price = categoryMenu.getMenuPrice() * (0.001);
        return " - " + categoryMenu.getMainMenuName() + "     | w " + price;
    }
    // priceList에 쌓인 것
    public String totalPriceInfo() {
        double price = totalPrice() * (0.001);
        return "w " + price;
    }
    // 구매가 완료될때마다 총 판매 금액을 누적해줍니다.
    // 주문완료 or 취소하면 장바구니 리스트 초기화되어 리스트 추가
    // totalPriceList 쌓인 것 합
    public String totalSellingPriceInfo() {
        double price = totalSellingPrice() * (0.001);
        return "w " + price;
    }
}
import java.util.*;

//사용자의 동작에 대해서 만든 클래스
public class Kiosk extends CategoryMenu {
    Screen screen = new Screen();
    Order order = new Order();
    public Scanner sc = new Scanner(System.in);
    int waitingNum = 0;

    //ArrayList<String> orderList = new ArrayList<String>();
    // 주문 갯수 리스트
    ArrayList<String> orderNumList = new ArrayList<String>();
    // 갯수만 따로 저장!!!!!!!!!!!!!!!!!!!!!!
    ArrayList<Integer> orderNum = new ArrayList<Integer>();
    ArrayList<Integer> priceList = new ArrayList<Integer>();
    // 총 판매 금액 리스트에 담기
    ArrayList<Integer> totalPriceList = new ArrayList<Integer>();

    //중복값 확인하기 위해 이름만 리스트에 담아주기
    ArrayList<String> orderNameList = new ArrayList<String>();
    //총 주문목록 저장
    ArrayList<String> totalOrderInfoList = new ArrayList<String>();

    public void setup() {
        while (true) {
        //while (true) {
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
                    selectOrderSuccess(selectMainMenu);
                    //1. 주문 2. 메뉴판 출력
                    int selectCheckOrder = screen.checkOrder();
                    // 1. 주문 2. 메뉴판 선택
                    orderOk(selectCheckOrder);
                }
                case  6 -> {
                    // 진행하던 주문을 취소하시겠습니까?
                    // 1. 확인   2. 취소 선택
                    int checkCancel = screen.checkCancel();
                    // 1. 확인   2. 취소 선택
                    printCancel(checkCancel);
                }
                // 선택 요구사항
                case 0 -> {
                    printTotalSellingPrice();
                    //1. 돌아가기 누르면 다시 메뉴판으로
                    System.out.println();
                    printTotalSellingList();
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }
    //selectMainMenu 결과값 받아서 카테고리 메뉴 정보 세팅
    public void setMenuInfo(int selectMainMenu) {
        if (selectMainMenu == 1) {
            int selectBurgersMenu = screen.selectBurgersMenu();//또 실행됨...->변수처리하여 해결!
            super.setBurgerInfo(selectBurgersMenu);// categoryMenu.toString()에 정보를 주기 위해 카테고리에서 선택한 번호 전달

        } else if (selectMainMenu == 2) {
            int selectForzenMenu = screen.selectForzenMenu();
            super.setFrozenInfo(selectForzenMenu);
        } else if (selectMainMenu == 3) {
            int selectDrinksMenu = screen.selectDrinksMenu();
            super.setDrinkInfo(selectDrinksMenu);
        } else if (selectMainMenu == 4) {
            int selectBeerMenu = screen.selectBeerMenu();
            super.setBeerInfo(selectBeerMenu);
        } else {
            System.out.println("올바르지 않은 입력입니다.");
        }
    }
    // 장바구니 추가 여부 묻기
    //1.확인 입력시 장바구니에 추가되었다는 안내문구와 함께 메인메뉴로 다시 출력됩니다.
    public int checkBasket() {
        System.out.println(super.toString());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인               2.취소");
        String result = sc.nextLine();
        return Integer.parseInt(result);
    }
    // 장바구니 추가 메서드
    public void addBasket(int checkBasket) {
        if (checkBasket == 1) {
            System.out.println(super.getCategoryMenuName() + "가 장바구니에 추가되었습니다.");
            // 실제로 장바구니에 추가하기
            //orderList.add(orderInfo());
            // 선택 요구사항////////////////////////////////////
            // 1. 주문 개수 기능 추가 (중복 확인)
            // 이름만 따로 리스트에 저장
            // 이름으로 중복 찾기 (장바구니에 담긴 orderInfo로 중복 확인하면 사이에 갯수 넣어주기가 곤란..)
            orderNameList.add(super.getCategoryMenuName());
            System.out.println("이름 중복 확인::::::::::::::::"+orderNameList);
            ///////////////////////////////////////
            // 장바구니에 똑같은 상품이 담기면 주문 화면에서 상품 개수가 출력되도록 한다.
            //menuNum();
            // 4. 총 판매상품 목록 조회 기능 추가
            // 기존 장바구니는 주문이 완료되거나 취소될 때 초기화가 된다.
            // 장바구니에 추가된 목록 저장
            // 총 판매상품 리스트 추가
            // 상품 가격 int 형으로 먼저 저장
            priceList.add(getMenuPrice());
            System.out.println();
        } else if (checkBasket == 2) {
            ///////////////////////////////////////
            System.out.println("전단계로 돌아가기?");
        } else {
            System.out.println("움");
        }
    }
//    // 장바구니 목록 출력하기
//    public void printBasketList() {
//        for (String basket : orderList) {
//            System.out.println(basket);
//        }
//    }
    public void printTotalSellingList() {
        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 목록은 아래와 같습니다.");
        System.out.println();
        // - ShackBurger    | W 6.9
        // - Float          | W 2.9
        // 이런 형식으로 출력하기!!!!!!!!!!
        for (String list : totalOrderInfoList) {
            System.out.println(list);
        }
        System.out.println("1. 돌아가기");
    }
    // 메뉴판에서 5.Order 입력시 완료 화면
    public void selectOrderSuccess(int selectOrderMenu) {
        System.out.println("아래와 같이 주문 하시겠습니이까?");
        System.out.println();
        System.out.println("[ Orders ]");
        // 기존 장바구니 목록 (개수 포함 X)
        // printBasketList();
        // 선택 요구사항 추가 ///////////////////////////////////
        // 장바구니에 똑같은 상품이 담기면 주문 화면에서 상품 개수가 출력되도록 합니다.
        // 개수까지 포함한 출력 형식을 리스트로 담아서 보여준다
        // 장바구니 확인할 때마다 추가로 들어간다ㅠㅠㅠㅠㅠㅠㅠㅠㅠ
        // orderNumList에 목록 추가!!!!!!!
        menuNum();
        //printBasketNumList();
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println(totalPriceInfo());
        System.out.println();
    }
    // 선택 요구사항 추가
    // 주문 개수 출력 (중복 확인)
    public void menuNum() {
        // ArrayList 원소와 중복 횟수를 저장할 HashMap 객체를 준비
        // 이름, 갯수
        Map<String, Integer> map = new HashMap<String, Integer>();
        double price = super.getMenuPrice() * (0.001);
        // ArrayList를 순회하면서 ArrayList의 원소가 HashMap 객체에 key로 들어있는지 확인하고,
        // 만약 없으면 value(중복 횟수)를 1로 세팅하고 HashMap에 추가
        // 만약 있으면 중복되는 데이터 이므로 value(중복 횟수)를 1 증가시켜서 HashMap에 추가한다.
        // HashMap은 key의 중복을 허용하지 않으므로 같은 key 값이 추가되면 값을 덮어쓴다.
        for (String str : orderNameList) {
            Integer count = map.get(str);
            if (count == null) {
                map.put(str, 1);
            } else {
                map.put(str, count + 1);
            }
        }
        for (String menuName : map.keySet()) {
            System.out.println(menuName+ " | w "+ price +  " | " + map.get(menuName)+" 개 |"+super.getCategoryDescription());
        }
    }

    public void printBasketNumList() {
        // orderNumList 출력
        for(String list : orderNumList) {
            System.out.println(list);
        }
    }
    //1.주문 입력시 주문완료 화면으로 넘어가고, 2.메뉴판 입력시 다시 메인메뉴로 돌아옵니다.
    public void orderOk(int checkOrder) {
        if (checkOrder == 1) {
            printOrderOk();
        } else if (checkOrder == 2) {
            // 다시 메인화면으로.....
        }else {
            System.out.println("잘못된 입력입니다.");
        }
    }
    // 주문 완료 화면
    // 1.주문 입력시 대기번호를 발급해줍니다.
    // 장바구니는 초기화되고 3초후에 메인 메뉴판으로 돌아갑니다.
    public void printOrderOk() {
        // 주문 완료 시 대기번호 1씩 증가
        waitingNum += 1;
        System.out.println("주문이 완료되었습니다!");
        // 장바구니 초기화
        //orderList.clear();
        // 가격 초기화
        priceList.clear();
        // 장바구니 초기화
        orderNumList.clear();
        orderNameList.clear();
        //선택 요구사항////////////////////////////
        // 구매가 완료될때마다 판매 상품 목록을 저장해줍니다.
        // 0번 눌렀을 때 확인 가능
        totalOrderInfoList.add(totalOrderInfo());
        totalPriceList.add(getMenuPrice());
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
    public void printTotalSellingPrice() {
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은 [ "+totalSellingPriceInfo()+" ] 입니다.");
        System.out.println();
        System.out.println("1. 돌아가기");
    }
    // 장바구니에서는 추가된 메뉴들과 총 가격의 합을 출력해줍니다.
    public int totalPrice() {
        int total = 0;
        for (Integer price : priceList) {
            total += price;
        }
        return total;
    }
    // 주문완료 or 취소하면 장바구니 리스트 초기화됨....
    public String totalPriceInfo() {
        double price = totalPrice() * (0.001);
        return "w " + price;
    }
    // 선택 요구사항 추가/////////////////////////
    // 3. 총 판매금액 조회 기능 추가
    // 구매가 완료될때마다 총 판매 금액을 누적해준다.
    public int totalSellingPrice() {
        int totalSellingPrice = 0;
        for (Integer totalPrice : totalPriceList) {
            totalSellingPrice += totalPrice;
        }
        return totalSellingPrice;
    }
    //주문 취소 화면
    // 1.확인 을 입력하면 장바구니는 초기화되고 취소 완료 문구와 함께 메뉴판이 출력됩니다.
    public void printCancel(int checkCancel) {
        System.out.println("진행하던 주문이 취소되었습니다.");
        // 장바구니 초기화
        //orderList.clear();
        // 가격 초기화
        priceList.clear();
        // 총판매목록 초기화????????
        //totalOrderInfoList.clear();
        // 총판매금액 초기화/??????
        //totalPriceList.clear();
        // 갯수 추가한 주문 목록 리스트 초기화
        orderNumList.clear();
        orderNameList.clear();
    }

    // 구매가 완료될때마다 총 판매 금액을 누적해줍니다.
    // 누적합
    public String totalSellingPriceInfo() {
        double price = totalSellingPrice() * (0.001);
        return "w " + price;
    }
    //////////////////출력형식//////////////////////////////////////////////
    // 주문 정보
    // 리스트에 차곡차곡 담기 위해 한줄 출력
    // 선택 요구사항 - 주문 개수 기능 추가
    // 장바구니에 똑같은 상품이 담기면 주문 화면에서 상품 개수가 출력되도록 합니다.
    public String orderInfo() {
        double price = getMenuPrice() * (0.001);
        return getCategoryMenuName() + "     | w " + price + " | " + getCategoryDescription();
    }

    public String orderNumInfo() {
        double price = getMenuPrice() * (0.001);
        return getCategoryMenuName() + "     | w " + price + " | " + getCategoryDescription();
    }


    // 구매가 완료될때마다 판매 상품 목록을 저장해줍니다.
    // arrayList
    public String totalOrderInfo() {
        double price = getMenuPrice() * (0.001);
        return " - " + getCategoryMenuName() + "     | w " + price;
    }
    /////////////
}
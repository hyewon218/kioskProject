public class CategoryMenu extends MainMenu {
    // 메뉴 번호
    private int categoryMenuNum;
    // 메뉴 이름
    private String categoryMenuName;
    // 메뉴 가격(카테고리에만)
    // 일단 int -> 합 구해야 하니까.
    private int menuPrice;
    // 메뉴 설명
    private String categoryDescription;

    public CategoryMenu() {

    }
    public CategoryMenu(int categoryMenuNum) {
        this.categoryMenuNum = categoryMenuNum;
    }

    // private 변수 외부랑 통신하기 위해 get 메소드 필요!
    public int getCategoryMenuNum() {
        return categoryMenuNum;
    }
    // 값 얻어오기
    public void setCategoryMenuNum(int categoryMenuNum) {
        this.categoryMenuNum = categoryMenuNum;
    }
    public String getCategoryMenuName() {
        return categoryMenuName;
    }
    public int getMenuPrice() {
        return menuPrice;
    }
    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setBurgerInfo(int categoryMenuNum) {
        if (categoryMenuNum == 1) {
            this.categoryMenuName = "ShackBurger";
            this.menuPrice = 6900;
            this.categoryDescription = "토마토, 양상추, 쉑소스가 토핑된 치즈버거";
        } else if (categoryMenuNum == 2) {
            this.categoryMenuName = "SmokeShack";
            this.menuPrice = 8900;
            this.categoryDescription = "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거";
        } else if (categoryMenuNum == 3) {
            this.categoryMenuName = "Shroom Burger";
            this.menuPrice = 9400;
            this.categoryDescription = "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거";
        } else if (categoryMenuNum == 4) {
            this.categoryMenuName = "Cheeseburger";
            this.menuPrice = 6900;
            this.categoryDescription = "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거";
        } else if (categoryMenuNum == 5) {
            this.categoryMenuName = "Hamburger";
            this.menuPrice = 5400;
            this.categoryDescription = "비프패티를 기반으로 야채가 들어간 기본버거";
        } else {
            System.out.println("잘못된 주문 번호입니다. 다시 입력해주세요.");
        }
    }
    public void setFrozenInfo(int categoryMenuNum) {
        switch (categoryMenuNum) {
            case 1 -> {
                this.categoryMenuName = "Shack";
                this.menuPrice = 5900;
                this.categoryDescription = "바닐라, 초콜렛, 솔티드 카라멜, 블랙&화이트, 스트로베리, 피넛버터, 커피";
                break;
            }
            case 2 -> {
                this.categoryMenuName = "Shack of the Week";
                this.menuPrice = 6500;
                this.categoryDescription = "특별한 커스터드 클레이버";
                break;
            }
            case 3 -> {
                this.categoryMenuName = "Red Bean Shake";
                this.menuPrice = 6500;
                this.categoryDescription = "신선한 커스터드와 함께 우유와 레드빈이 블랜딩 된 시즈널 쉐이크";
                break;
            }
            case 4 -> {
                this.categoryMenuName = "Floats";
                this.menuPrice = 5900;
                this.categoryDescription = "루트 비어, 퍼플 카우, 크림시클";
            }
            default -> System.out.println("잘못된 주문 번호입니다. 다시 입력해주세요.");
        }
    }
    public void setDrinkInfo(int categoryMenuNum) {
        switch (categoryMenuNum) {
            case 1 -> {
                this.categoryMenuName = "Shack";
                this.menuPrice = 5900;
                this.categoryDescription = "바닐라, 초콜렛, 솔티드 카라멜, 블랙&화이트, 스트로베리, 피넛버터, 커피";
                break;
            }
            case 2 -> {
                this.categoryMenuName = "Shack of the Week";
                this.menuPrice = 6500;
                this.categoryDescription = "특별한 커스터드 클레이버";
                break;
            }
            case 3 -> {
                this.categoryMenuName = "Red Bean Shake";
                this.menuPrice = 6500;
                this.categoryDescription = "신선한 커스터드와 함께 우유와 레드빈이 블랜딩 된 시즈널 쉐이크";
                break;
            }
            default -> System.out.println("잘못된 주문 번호입니다. 다시 입력해주세요.");
        }
    }
    public void setBeerInfo(int categoryMenuNum) {
        switch (categoryMenuNum) {
            case 1 -> {
                this.categoryMenuName = "ShackMeister Ale";
                this.menuPrice = 9800;
                this.categoryDescription = "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주";
                break;
            }
            case 2 -> {
                this.categoryMenuName = "Magpie Brewing Co.";
                this.menuPrice = 6800;
                this.categoryDescription = "맥파이 페일에일은 맥파이에서 출시한 첫 맥주이자 가장 인기 있는 맥주";
                break;
            }
            default -> System.out.println("잘못된 주문 번호입니다. 다시 입력해주세요.");
        }
    }
    //구매 상품 한줄 출력
    public String toString() {
        double price = getMenuPrice() * (0.001);
        //따움표 추가!!!!!!!!!!!!!!!!!!!!!!!!!!!
        return getCategoryMenuName() + "     | w " + price + " |  " + getCategoryDescription();
    }
    //주문 가격 누적
    public double totalPrice() {
        int total = 0;
        total += getMenuPrice();
        return (double) total;
    }

}



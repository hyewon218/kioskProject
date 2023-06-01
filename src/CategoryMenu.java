import java.util.Map;

public class CategoryMenu extends MainMenu {
    private int menuPrice;

    public CategoryMenu() {

    }
    public int getMenuPrice() {
        return menuPrice; }

    public void setBurgerInfo(int categoryMenuNum) {
        switch (categoryMenuNum) {
            case 1 -> {
                super.mainMenuName = "ShackBurger";
                this.menuPrice = 6900;
                super.description = "토마토, 양상추, 쉑소스가 토핑된 치즈버거";
            }
            case 2 -> {
                super.mainMenuName = "SmokeShack";
                this.menuPrice = 8900;
                super.description = "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거";
            }
            case 3 -> {
                super.mainMenuName = "Shroom Burger";
                this.menuPrice = 9400;
                super.description = "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거";
            }
            case 4 -> {
                super.mainMenuName = "Cheeseburger";
                this.menuPrice = 6900;
                super.description = "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거";
            }
            case 5 -> {
                super.mainMenuName = "Hamburger";
                this.menuPrice = 5400;
                super.description = "비프패티를 기반으로 야채가 들어간 기본버거";
            }
            default -> System.out.println("잘못된 주문 번호입니다. 다시 입력해주세요.");
        }
    }
    public void setFrozenInfo(int categoryMenuNum) {
        switch (categoryMenuNum) {
            case 1 -> {
                super.mainMenuName = "Shack";
                this.menuPrice = 5900;
                super.description = "바닐라, 초콜렛, 솔티드 카라멜, 블랙&화이트, 스트로베리, 피넛버터, 커피";
            }
            case 2 -> {
                super.mainMenuName = "Shack of the Week";
                this.menuPrice = 6500;
                super.description = "특별한 커스터드 클레이버";
            }
            case 3 -> {
                super.mainMenuName = "Red Bean Shake";
                this.menuPrice = 6500;
                super.description = "신선한 커스터드와 함께 우유와 레드빈이 블랜딩 된 시즈널 쉐이크";
            }
            case 4 -> {
                super.mainMenuName = "Floats";
                this.menuPrice = 5900;
                super.description = "루트 비어, 퍼플 카우, 크림시클";
            }
            default -> System.out.println("잘못된 주문 번호입니다. 다시 입력해주세요.");
        }
    }
    public void setDrinkInfo(int categoryMenuNum) {
        switch (categoryMenuNum) {
            case 1 -> {
                super.mainMenuName = "Shack-made Lemonade";
                this.menuPrice = 3900;
                super.description = "매장에서 직접 만드는 상큼한 레몬에이드";
                break;
            }
            case 2 -> {
                super.mainMenuName = "Fresh Brewed Iced Tea";
                this.menuPrice = 3400;
                super.description = "직접 유기농 홍차를 우려낸 아이스티";
                break;
            }
            case 3 -> {
                super.mainMenuName = "Fifty/Fifty";
                this.menuPrice = 3500;
                super.description = "레몬에이드와 아이스티의 만남";
                break;
            }
            default -> System.out.println("잘못된 주문 번호입니다. 다시 입력해주세요.");
        }
    }
    public void setBeerInfo(int categoryMenuNum) {
        switch (categoryMenuNum) {
            case 1 -> {
                super.mainMenuName = "ShackMeister Ale";
                this.menuPrice = 9800;
                super.description = "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주";
                break;
            }
            case 2 -> {
                super.mainMenuName = "Magpie Brewing Co.";
                this.menuPrice = 6800;
                super.description = "맥파이 페일에일은 맥파이에서 출시한 첫 맥주이자 가장 인기 있는 맥주";
                break;
            }
            default -> System.out.println("잘못된 주문 번호입니다. 다시 입력해주세요.");
        }
    }
    //구매 상품 한줄 출력
    public String menuInfo() {
        double price = getMenuPrice() * (0.001);
        return  "\""+ getMainMenuName() + "     | w " + price + " |  " + getDescription()+ "\"";
    }

}



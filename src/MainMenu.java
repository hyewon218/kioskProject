
public class MainMenu {
    // 메뉴 번호
    private int menuNum;
    // 메뉴 이름
    private String mainMenuName;
    // 메뉴 설명
    private String description;

    public MainMenu() {

    }
    public MainMenu(int menuNum, String description) {
        this.menuNum=menuNum;
        this.description=description;
    }
    // private 변수 외부랑 통신하기 위해 get 메소드 필요!
    public int getMenuNum() {
        return menuNum;
    }
    // 값 얻어오기
    public void setMenuNum(int menuNum) {
        this.menuNum=menuNum;
    }
    public String getMainMenuName () {
        return mainMenuName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {

        this.description=description;
    }
    public void setMainMenuName(int menuNum) {
        switch (menuNum) {
            case 1 -> this.mainMenuName = "Burgers";
            case 2 -> this.mainMenuName = "Forzen Custard";
            case 3 -> this.mainMenuName = "Drinks";
            case 4 -> this.mainMenuName = "Beer";
            default -> System.out.println("잘못된 주문 번호입니다. 다시 입력해주세요.");
        }
    }
}















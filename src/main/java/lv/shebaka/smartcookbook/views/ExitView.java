package lv.shebaka.smartcookbook.views;

public class ExitView implements View{

    @Override
    public void execute() {
        System.out.println("Thank you ! C ya !");
        System.exit(0);
    }
}

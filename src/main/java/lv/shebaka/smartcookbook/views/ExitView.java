package lv.shebaka.smartcookbook.views;

public class ExitView implements View{

    @Override
    public void execute() {
        System.out.println("Спасибо, до встречи !");
        System.exit(0);
    }
}

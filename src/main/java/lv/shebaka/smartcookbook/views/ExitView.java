package lv.shebaka.smartcookbook.views;

import org.springframework.stereotype.Component;

@Component
public class ExitView implements View {

    @Override
    public void execute() {
        System.out.println("Спасибо, до встречи !");
        System.exit(0);
    }
}

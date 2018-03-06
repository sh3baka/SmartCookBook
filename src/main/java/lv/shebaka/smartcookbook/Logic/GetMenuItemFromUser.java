package lv.shebaka.smartcookbook.Logic;

import java.util.Scanner;

class GetMenuItemFromUser {
    int getMenuItem() {
        Scanner scan = new Scanner(System.in);
        return Integer.parseInt(scan.nextLine());
    }
}

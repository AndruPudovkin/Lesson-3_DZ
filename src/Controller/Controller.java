package Controller;

import Model.User;
import Service.UserServise;
import View.UserWrite;

import java.util.Scanner;

public class Controller {

    private final UserWrite userWrite = new UserWrite();
    private final UserServise userServise = new UserServise();

    private User createUser (){
        Scanner scanner = new Scanner(System.in);
        String stringUser = scanner.nextLine();
       return userServise.getUserIsString(stringUser);
    }

    public void saveUser(){
       User user = createUser();
       userServise.userControl(user);
       userWrite.userFileWriter(user);
    }
}

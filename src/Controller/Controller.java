package Controller;

import Model.UserDataBase;

public class Controller implements Menu{
    public void display(){
        int count=3;
        UserDataBase dataBase=setter(count);
        dataBase= menu(dataBase,count);
    }
}

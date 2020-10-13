package Model;

import java.util.HashMap;
import java.util.LinkedList;

public class UserDataBase extends User {
    private HashMap<Integer,User> dataBase;

    public HashMap<Integer,User> getDataBase() {
        return dataBase;
    }

    public void setDataBase(HashMap<Integer,User> dataBase) {
        this.dataBase = dataBase;
    }
}

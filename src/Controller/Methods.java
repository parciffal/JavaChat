package Controller;

import Model.User;
import Model.UserDataBase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public interface Methods  {
    Scanner in=new Scanner(System.in);
    default UserDataBase setter(int count){

        UserDataBase dataBase=new UserDataBase();
        HashMap<Integer,User> data=new HashMap<>();
        for (int i=0;i<count;i++){
            User user=new User();
            System.out.println("Enter name");
            String name=in.next();
            System.out.println("Enter password");
            int password=in.nextInt();
            user.setSurname(name);
            user.setPassword(password);
            user.setId(i);
            data.put(i,user);
            System.out.println(data.get(i).getSurname());
        }
         dataBase.setDataBase(data);
        return dataBase;
    }
    default UserDataBase login(UserDataBase dataBase,User user){
        System.out.println("Enter password");
        int password=in.nextInt();
        if (user.isOnline()){
            System.out.println("User is online");
        }else{
        if (user.getPassword()==password){
            user.setOnline(true);
        }else{
            System.out.println("Wrong password");
            System.out.println("Want to retry");
            boolean answer=in.nextBoolean();
            if (answer==true) {
                login(dataBase,user);
            }
        }
        }
        dataBase.getDataBase().put(user.getId(),user);
        return dataBase;
    }
    default UserDataBase sendFriendRequest(UserDataBase dataBase,User a,User b){
        System.out.println("&"+b.getSurname());
        System.out.println(a.getSurname()+"Send you request ");
        boolean answear=in.nextBoolean();
        if (answear==true){
            a.getFriends().add(b);
            b.getFriends().add(a);
        }
        dataBase.getDataBase().put(a.getId(),a);
        dataBase.getDataBase().put(b.getId(),b);
        return dataBase;
    }
    default UserDataBase privateChat(UserDataBase dataBase,User a,User b){
        System.out.println("Start chat");
        LinkedList<User> chat=new LinkedList<>();
        chat.add(a);
        chat.add(b);
        boolean answear=in.nextBoolean();
        LinkedList<String> history=new LinkedList<>();
        if (answear==true){
            for (int i=0;i<10000;i++){
                for (User h:chat) {
                    System.out.println("&" + h.getSurname());
                    String massage = in.next();
                    history.add(i, massage);
                }
                System.out.println("want to leave");
                boolean an=in.nextBoolean();
                if (an==true){
                    break;
                }
            }
        }
        for (User f:chat) {
        f.getLastHistory().add(history);
        dataBase.getDataBase().put(f.getId(),f);
        }
        return  dataBase;
    }
    default UserDataBase groupChat(UserDataBase dataBase,int[] chatMemId){
        System.out.println("Start chat");
        LinkedList<User> chat=new LinkedList<>();
        for (int i=0;i<chatMemId.length;i++){
            chat.add(dataBase.getDataBase().get(chatMemId[i]));
        }
        boolean answear=in.nextBoolean();
        LinkedList<String> history=new LinkedList<>();
        if (answear==true){
            for (int i=0;i<10000;i++){
                for (User h:chat) {
                    System.out.println("&" + h.getSurname());
                    String massage = in.next();
                    history.add(i, massage);
                    System.out.println("want to leave");
                    boolean an=in.nextBoolean();
                    if (an==true){
                        chat.remove(h);
                    }
                    if (chat.size()==1){
                        break;
                    }
                }

            }
        }
        for (User f:chat) {
            f.getLastHistory().add(history);
            dataBase.getDataBase().put(f.getId(),f);
        }

return dataBase;
    }
    default UserDataBase logOut(UserDataBase dataBase,User user){
        System.out.println("Want to log out");
        boolean answear=in.nextBoolean();
        if (answear==true){
            user.setOnline(false);
        }
        dataBase.getDataBase().put(user.getId(),user);
        return dataBase;
    }
    default UserDataBase chatRequest(UserDataBase dataBase,User user){
        System.out.println("Want allow chat");
        boolean answear=in.nextBoolean();
        if (answear==true){
            user.setRequest(true);
        }
        dataBase.getDataBase().put(user.getId(),user);
        return dataBase;
    }
}

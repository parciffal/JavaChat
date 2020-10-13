package Controller;

import Model.User;
import Model.UserDataBase;

import java.util.*;

public interface Menu extends Methods {
Scanner in=new Scanner(System.in);
    default UserDataBase menu(UserDataBase dataBase,int chatMemCount){

            for (int i=0;i<15;i++) {
                System.out.println("Choose user");
                int id=in.nextInt();
                System.out.println(dataBase.getDataBase().get(id).getSurname());
                if (dataBase.getDataBase().get(id).getReqFri() != 0) {
                    System.out.println("you have friend request");
                    dataBase = sendFriendRequest(dataBase, dataBase.getDataBase().get(id), dataBase.getDataBase().get(dataBase.getDataBase().get(id).getReqFri()));
                }
                if (dataBase.getDataBase().get(id).isOnline()) {
                    System.out.println("Choose");
                    System.out.println("1)Send friend request");
                    System.out.println("2)Start Chat");
                    System.out.println("3)Logout");
                    int an = in.nextInt();
                    if (an == 1) {
                        System.out.println("Witch one enter id");
                        int usId = in.nextInt();
                        dataBase.getDataBase().get(usId).setReqFri(id);
                    } else {
                        if (an == 2) {
                            System.out.println("With hoom");
                            int idnew=in.nextInt();
                            dataBase=privateChat(dataBase,dataBase.getDataBase().get(id),dataBase.getDataBase().get(idnew));
                        }else{
                            if (an==3){
                                dataBase.getDataBase().get(id).setOnline(false);
                                System.out.println(dataBase.getDataBase().get(id).getSurname()+"loged out");
                            }

                        }
                    }
                } else {
                    System.out.println("Want to login");
                    boolean answear = in.nextBoolean();
                    if (answear == true) {
                        dataBase = login(dataBase, dataBase.getDataBase().get(id));
                    }
                }
            }
            return dataBase;
        }


}

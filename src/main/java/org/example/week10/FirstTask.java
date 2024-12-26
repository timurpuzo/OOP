package org.example.week10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CanSendMessage{}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface RequiresPermission{
    int requiredLevel();
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface UserPermission{
    int userPermissionLevel();
}



public class FirstTask {
    public static void main(String[] args) {
        RegularUser korisnik1 = new RegularUser("Timur",1);
        AdminUser korisnik2 = new AdminUser("Becir");
        RegularUser korisnik3 = new RegularUser("Haris",3);

        korisnik1.sendMessage();
        korisnik2.sendMessage();
        korisnik3.sendMessage();

        for(Method m : korisnik2.getClass().getDeclaredMethods()){
            if(m.isAnnotationPresent(CanSendMessage.class)){
                System.out.println("Can Send Message is present");
            }
        }
    }
}

abstract class User{
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    abstract void sendMessage();
}


@UserPermission(userPermissionLevel = 2)
class RegularUser extends User{
    int userLevel;

    public RegularUser(String username, int userLevel){
        super(username);
        this.userLevel = userLevel;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    @CanSendMessage
    public void sendMessage(){
        if(this.userLevel >= 2){
            System.out.println(this.userLevel+" "+ "Ovaj user moze: "+getUsername());
        }else{
            System.out.println(this.userLevel+" " + "Ovaj user ne moze: " + getUsername());
        }
    }
}

@UserPermission(userPermissionLevel = 3)
class AdminUser extends User{

    public AdminUser(String username) {
        super(username);
    }

    @CanSendMessage
    public void sendMessage(){
        System.out.println(getUsername() + " Adminu je uvijek dozvoljeno");
    }


}





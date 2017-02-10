package ua.ck.zabochen.hw11;

import ua.ck.zabochen.hw11.annotation.ClassAnnotation;
import ua.ck.zabochen.hw11.annotation.MethodAnnotation;

import java.util.ArrayList;

@ClassAnnotation(generateUserList = true)
public class User {

    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @MethodAnnotation
    public ArrayList<User> getPublicUserList(int userQuantity) {
        ArrayList<User> userList = new ArrayList<>();
        for (int i = 0; i < userQuantity; i++) {
            userList.add(new User(i, "PublicUser_" + i));
        }
        return userList;
    }

    @MethodAnnotation
    private ArrayList<User> getPrivateUserList(int userQuantity) {
        ArrayList<User> userList = new ArrayList<>();
        for (int i = 0; i < userQuantity; i++) {
            userList.add(new User(i, "PrivateUser_" + i));
        }
        return userList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

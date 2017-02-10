package ua.ck.zabochen.hw11;

import ua.ck.zabochen.hw11.annotation.ClassAnnotation;
import ua.ck.zabochen.hw11.annotation.MethodAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;

public class HomeWork11 {

    public static void main(String[] args) {

        // Get Class For Name
        Class<?> userClass = null;
        try {
            userClass = Class.forName("ua.ck.zabochen.hw11.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Get Class Info
        if (userClass != null) {
            System.out.println("Class Name: " + userClass.getName() + "\n");

            System.out.println("Class Declared Fields:");
            Field[] fields = userClass.getDeclaredFields();
            for (Field f : fields) {
                System.out.println("private = " + Modifier.isPrivate(f.getModifiers()) +
                        ", " + f.getName() + ", ");
            }

            System.out.println("\nClass Declared Constructors: ");
            Constructor[] constructors = userClass.getDeclaredConstructors();
            for (Constructor c : constructors) {
                System.out.println("public = " + Modifier.isPublic(c.getModifiers()) + ", " + Arrays.toString(c.getParameters()) + ", ");
            }

            System.out.println("\nClass Declared Methods: ");
            Method[] methods = userClass.getDeclaredMethods();
            for (Method m : methods) {
                if (Modifier.isPrivate(m.getModifiers())) {
                    System.out.println("private = " + Modifier.isPrivate(m.getModifiers()) + ", "
                            + m.getName() + ", " +
                            "parameters -> " + Arrays.toString(m.getParameters()));
                } else {
                    System.out.println("public = " + Modifier.isPublic(m.getModifiers()) + ", " +
                            m.getName() + ", " +
                            "parameters -> " + Arrays.toString(m.getParameters()));
                }
            }

            System.out.println("\nClass Declared Annotations: ");
            Annotation[] classAnnotation = userClass.getDeclaredAnnotations();
            for (Annotation a : classAnnotation) {
                System.out.println(a.annotationType() + ", ");
            }

            System.out.println("\nMethod Annotation: ");
            try {
                Method getUserListMethod = userClass.getMethod("getPublicUserList", int.class);
                if (getUserListMethod != null) {
                    Annotation[] methodAnnotation = getUserListMethod.getDeclaredAnnotations();
                    for (Annotation a : methodAnnotation) {
                        System.out.println(a.annotationType() + ", ");
                    }
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            System.out.println("\nGet Public Method: ");
            if (userClass.isAnnotationPresent(ClassAnnotation.class)) {
                ClassAnnotation publicUserClassAnnotation = userClass.getAnnotation(ClassAnnotation.class);
                if (publicUserClassAnnotation.generateUserList()) {
                    try {
                        Method getPublicUserListMethod = userClass.getMethod("getPublicUserList", int.class);
                        MethodAnnotation getPublicUserListAnnotation = getPublicUserListMethod.getAnnotation(MethodAnnotation.class);
                        User user = (User) userClass.newInstance();
                        ArrayList<User> publicUserList = user.getPublicUserList(getPublicUserListAnnotation.userQuantity());
                        for (User u : publicUserList) {
                            System.out.println(u);
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("\nGet Private Method: ");
                if (userClass.isAnnotationPresent(ClassAnnotation.class)) {
                    ClassAnnotation privateUserClassAnnotation = userClass.getAnnotation(ClassAnnotation.class);
                    if (privateUserClassAnnotation.generateUserList()) {
                        try {
                            Method getPrivateUserList = userClass.getDeclaredMethod("getPrivateUserList", int.class);
                            getPrivateUserList.setAccessible(true);
                            if (getPrivateUserList.isAnnotationPresent(MethodAnnotation.class)) {
                                MethodAnnotation privateMethodAnnotation = getPrivateUserList.getAnnotation(MethodAnnotation.class);
                                try {
                                    ArrayList<User> privateUserList = (ArrayList<User>) getPrivateUserList
                                            .invoke(userClass.newInstance(), privateMethodAnnotation.userQuantity());
                                    for (User u : privateUserList) {
                                        System.out.println(u);
                                    }
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                } catch (InstantiationException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }

        }
    }
}

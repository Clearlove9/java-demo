package com.aeron.icoder.seria;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class SeriaDemo {
    public SeriaDemo() {
    }


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {


        Class<?> aClass = Class.forName("com.aeron.icoder.seria.User");
        Constructor<?> constructor = aClass.getConstructor(String.class, String.class, String.class, String.class);
        User o = (User)constructor.newInstance("a","b","c","d");


        User user = new User("Aaa");
        user.setUsername("aeronfu");
        user.setPassword("ttt");

        System.out.println("start to serial.");

        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream("/tmp/user.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(os);
        }

        System.out.println("start to de serial");

        ObjectInputStream is = null;
        try {
            is = new ObjectInputStream(new FileInputStream("/tmp/user.txt"));
            User u = (User) is.readObject();
            System.out.println("Object: name -> " + u.getUsername() + " , password -> " + u.getPassword() + " , id -> " + u.getId());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
        }
    }
}

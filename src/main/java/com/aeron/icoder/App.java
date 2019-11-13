package com.aeron.icoder;

import com.aeron.icoder.effective.Facts;
import com.aeron.icoder.enim.WeatherEnum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Facts facts = new Facts.Builder(1, 1).build();

        WeatherEnum weather = WeatherEnum.AUTUMN;

        switch (weather) {
            case AUTUMN:
                System.out.println("Autumn");
                break;
            case SPRING:
                System.out.println("Spring");
                break;
            case SUMMER:
                System.out.println("Summer");
                break;
            case WINTER:
                System.out.println("Winter");
                break;
            default:
                System.out.println("no");
        }
    }
}

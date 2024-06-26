package org.jingyes.designpattern.Behavioral.observer;

/**
 * @author jingyes
 * @date 2024/1/10
 */
public class App {
    public static void main(String[] args) {
        Weather weather=new Weather();
        weather.addObserver(new Temperature());
        weather.addObserver(new Chart());
        weather.change();
        weather.change();
        weather.change();
    }
}

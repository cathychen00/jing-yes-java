package org.jingyes.designpattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

/**
 * @author 陈敬
 * @date 2024/1/10
 */
public class Weather {
    private WeatherType currentWeatherType;
    private List<Observer> observers;

    public Weather() {
        this.currentWeatherType = WeatherType.SUNNY;
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void change() {
        this.currentWeatherType = WeatherType.values()[(this.currentWeatherType.ordinal() + 1) % WeatherType.values().length];
        this.notifyObservers();
    }

    private void notifyObservers() {
        this.observers.forEach(x -> x.update(this.currentWeatherType));
    }
}

package org.jingyes.designpattern.Behavioral.observer;

/**
 * @author jingyes
 * @date 2024/1/10
 */
public enum WeatherType {
    SUNNY(28),
    RAINY(23),
    SNOWY(1),
    CLOUDY(20);
    private int temperature;

    WeatherType(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}

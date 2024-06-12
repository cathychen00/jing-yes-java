package org.jingyes.designpattern.Behavioral.observer;

/**
 * @author jingyes
 * @date 2024/1/10
 */
public class Chart implements Observer{
    @Override
    public void update(WeatherType weatherType) {
        System.out.println("温度图表显示"+weatherType.name()+" 温度"+weatherType.getTemperature());
    }
}

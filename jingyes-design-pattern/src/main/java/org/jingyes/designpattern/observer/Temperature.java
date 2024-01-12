package org.jingyes.designpattern.observer;

/**
 * @author 陈敬
 * @date 2024/1/10
 */
public class Temperature implements Observer {
    @Override
    public void update(WeatherType weatherType) {
        System.out.println("温度计显示" + weatherType.getTemperature() + "度");
    }
}

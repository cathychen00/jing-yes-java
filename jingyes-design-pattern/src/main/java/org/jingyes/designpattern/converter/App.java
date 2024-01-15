package org.jingyes.designpattern.converter;

import java.util.Date;

/**
 * @author 陈敬
 * @date 2024/1/15
 */
public class App {
    public static void main(String[] args) {
        Data data=new Data();
        data.setId(1);
        data.setTitle("测试data");
        data.setDelayTime(new Date());

        DataConverter converter=new DataConverter();
        DataDTO dto = converter.convertFromEntity(data);

        System.out.println(dto.toString());
    }
}

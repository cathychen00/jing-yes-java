package org.jingyes.designpattern.Architectural.databus;

import java.util.function.Consumer;

/**
 * @author 陈敬
 * @date 2024/1/9
 */
public interface MsgConsumer extends Consumer<DataType> {
    void accept(DataType dataType);
}

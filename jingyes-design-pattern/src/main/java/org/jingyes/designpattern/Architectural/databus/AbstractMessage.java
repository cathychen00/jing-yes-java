package org.jingyes.designpattern.Architectural.databus;

/**
 * @author jingyes
 * @date 2024/1/9
 */
public class AbstractMessage implements DataType {
    private DataBus dataBus;

    @Override
    public DataBus getDataBus() {
        return dataBus;
    }

    @Override
    public void setDataBus(DataBus dataBus) {
        this.dataBus = dataBus;
    }
}

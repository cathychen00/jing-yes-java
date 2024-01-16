package org.jingyes.designpattern.Creational.converter;

import java.util.Date;

/**
 *
 * @author 陈敬
 * @date 2024/1/15
 */
public class DataConverter extends Converter<DataDTO, Data> {
    public DataConverter() {
        super(DataConverter::convertToEntity, DataConverter::convertToDTO);
    }

    private static DataDTO convertToDTO(Data entity) {
        DataDTO dto=new DataDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDelayTime(entity.getDelayTime());
        dto.setDelay(entity.getDelayTime().before(new Date()));
        return dto;
    }

    private static Data convertToEntity(DataDTO dto) {
        Data data = new Data();
        data.setId(dto.getId());
        data.setTitle(dto.getTitle());
        data.setDelayTime(dto.getDelayTime());
        return data;
    }
}

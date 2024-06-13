package com.jingyes.webflux.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

/**
 * @author chenjing
 * @date 2021/3/22
 */
//标识为mongodb文档
@Document
@Data
public class User {
    @Id
    private Long id;
    private EnumSex sex;
    @Field("user_name")
    private String userName;
    private String note;
}

package com.jingyes.webflux.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @author chenjing
 * @date 2021/3/22
 */
@Data
@ToString
public class UserVo {
    private Long id;
    private String userName;
    private String note;
    private int sexCode;
    private String sexName;
}

package com.self.cloud.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 表名：t_user
 */
@Data
@Table(name = "t_user")
public class User {
    @Id
    private Integer id;

    private String name;

    private String password;

    private String phone;

    private String source;

    @Column(name = "wx_id")
    private String wxId;

}
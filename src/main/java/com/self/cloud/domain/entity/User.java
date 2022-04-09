package com.self.cloud.domain.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表名：t_user
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
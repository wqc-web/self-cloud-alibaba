package com.self.content.domain.entity;

import javax.persistence.*;

import com.self.content.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表名：t_content
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_content")
public class Content {
    @Id
    private Integer id;

    private String title;

    private String content;

    private String comment;

    @Column(name = "user_id")
    private Integer userId;

    private UserDto userDto;
}
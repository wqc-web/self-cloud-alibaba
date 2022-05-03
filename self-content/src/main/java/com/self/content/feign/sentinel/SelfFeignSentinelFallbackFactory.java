package com.self.content.feign.sentinel;

import com.self.content.domain.dto.UserDto;
import com.self.content.feign.UserFeignClient;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SelfFeignSentinelFallbackFactory implements FallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {
            @Override
            public UserDto exposeGetId(Integer id) {
                UserDto userDto = new UserDto();
                userDto.setSource(cause.getMessage());
                return userDto;
            }

            @Override
            public List<UserDto> exposeQueryUser(UserDto user) {
                user.setSource(cause.getMessage());
                List<UserDto> list = new ArrayList<>();
                list.add(user);
                return list;
            }

            @Override
            public UserDto login() {
                UserDto dto = new UserDto();
                return dto;
            }
        };
    }
}

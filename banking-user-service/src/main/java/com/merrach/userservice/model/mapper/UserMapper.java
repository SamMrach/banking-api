package com.merrach.userservice.model.mapper;
import com.merrach.userservice.model.entity.UserEntity;
import com.merrach.userservice.model.dto.User;
import org.springframework.beans.BeanUtils;
public class UserMapper extends BaseMapper<UserEntity, User>{
    @Override
    public UserEntity convertToEntity(User dto, Object... args) {
        UserEntity userEntity = new UserEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, userEntity);
        }
        return userEntity;
    }

    @Override
    public User convertToDto(UserEntity entity, Object... args) {
        User user = new User();
        if (entity != null) {
            BeanUtils.copyProperties(entity, user);
        }
        return user;
    }
}

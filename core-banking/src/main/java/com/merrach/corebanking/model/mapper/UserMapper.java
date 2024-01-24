package com.merrach.corebanking.model.mapper;

import com.merrach.corebanking.model.dto.User;
import com.merrach.corebanking.model.entity.UserEntity;
import org.springframework.beans.BeanUtils;

public class UserMapper extends BaseMapper<UserEntity, User> {
    @Override
    public UserEntity convertToEntity(User dto, Object... ars) {
        UserEntity entity=new UserEntity();
        if(dto != null){
            BeanUtils.copyProperties(dto,entity,"accounts");
           // entity.setAccounts(bankAccountMapper.convertToEntityList(dto.getBankAccounts()));
        }
        return entity;
    }

    @Override
    public User convertToDto(UserEntity entity, Object... args) {
        User dto=new User();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto, "accounts");
            //dto.setBankAccounts(bankAccountMapper.convertToDtoList(entity.getAccounts()));
        }
        return dto;
    }
}

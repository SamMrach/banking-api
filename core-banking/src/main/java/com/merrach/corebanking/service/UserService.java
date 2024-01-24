package com.merrach.corebanking.service;

import com.merrach.corebanking.model.dto.User;
import com.merrach.corebanking.model.entity.UserEntity;
import com.merrach.corebanking.model.mapper.UserMapper;
import com.merrach.corebanking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private  UserMapper userMapper = new UserMapper();

    public User readUser(String identification){
        UserEntity userEntity = userRepository.findByIdentificationNumber(identification).orElseThrow();
        return userMapper.convertToDto(userEntity);
    }

    public List<User> readUsers(Pageable pageable) {
        return userMapper.convertToDtoList(userRepository.findAll(pageable).getContent());
    }

}

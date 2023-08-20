package com.ahmetakkoyun.service;

import com.ahmetakkoyun.dto.request.UserSaveRequestDto;
import com.ahmetakkoyun.mapper.IUserMapper;
import com.ahmetakkoyun.repository.IUserRepository;
import com.ahmetakkoyun.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long userId){
        return userRepository.findById(userId);
    }

    public User save(UserSaveRequestDto dto) {
        User user = IUserMapper.INSTANCE.toUser(dto);
        return userRepository.save(user);
    }
    @Transactional
    public User updateById(Optional<User> oldUser){
        User newUser = IUserMapper.INSTANCE.updateToUser(oldUser);
        return userRepository.save(newUser);
    }

    public void deleteById(Long userId){
        userRepository.deleteById(userId);
    }

}

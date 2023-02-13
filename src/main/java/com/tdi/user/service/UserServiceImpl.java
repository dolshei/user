package com.tdi.user.service;

import com.tdi.user.dto.UserDetailDTO;
import com.tdi.user.dto.UserSaveDTO;
import com.tdi.user.entity.UserEntity;
import com.tdi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    // Repository 생성자 주입
    private final UserRepository userRepository;


    @Override
    public Long save(UserSaveDTO userSaveDTO) {
        // JPARepository 는 무조건 Entity 타입만 받기 때문에 Entity 타입으로 바꿔줘야 함.
        UserEntity userEntity = UserEntity.saveUser(userSaveDTO);

        Long userId = userRepository.save(userEntity).getId();

        return userId;
    }

    @Override
    public List<UserDetailDTO> findAll() {
        // findAll 이라는 메서드 호출 및 Entity 타입의 List 에 호출 결과 저장
        List<UserEntity> userEntityList = userRepository.findAll();

        // Entity 타입의 List 를 DTO 타입의 List 로 변환
        List<UserDetailDTO> userDetailDTOList = UserDetailDTO.change(userEntityList);

        return userDetailDTOList;
    }

    @Override
    public UserDetailDTO findById(Long userId) {
        return UserDetailDTO.toUserDetailDTO(userRepository.findById(userId).get());
    }

}

package com.tdi.user.service;

import com.tdi.user.dto.UserDetailDTO;
import com.tdi.user.dto.UserSaveDTO;

import java.util.List;

public interface UserService {
    Long save(UserSaveDTO userSaveDTO);

    List<UserDetailDTO> findAll();

    UserDetailDTO findById(Long userId);

}

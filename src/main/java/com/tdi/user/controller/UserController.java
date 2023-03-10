package com.tdi.user.controller;

import com.tdi.user.dto.UserSaveDTO;
import com.tdi.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "User API", description = "Not Login User API")

    // 사용자 정보 저장
    @PostMapping("/save")
    public Long save(@ModelAttribute UserSaveDTO userSaveDTO) {
        Long userId = userService.save(userSaveDTO);
        return userId;
    }
}

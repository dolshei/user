package com.tdi.user.api;

import com.tdi.user.dto.UserSaveDTO;
import com.tdi.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserApiController {

    private final Logger LOGGER = LoggerFactory.getLogger(UserApiController.class);
    private final UserService userService;

    @Autowired
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "User API", description = "Not Login User API")

    // 사용자 정보 저장
    @PostMapping("/users")
    public SaveUserResponse save(@RequestBody @Valid UserSaveDTO userSaveDTO) {
        Long userId = userService.save(userSaveDTO);

        return new SaveUserResponse(userId);
    }

    @Data
    static class SaveUserResponse {
        private Long userId;

        public SaveUserResponse(Long userId) {
            this.userId = userId;
        }
    }

}

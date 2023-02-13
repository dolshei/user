package com.tdi.user.dto;

import com.tdi.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor          // 기본 생성자
@AllArgsConstructor         // 모든 필드를 매개변수로 하는 생성자
// 생성자는 쓰이는 일이 없더라도 만들어 놓아도 문제 없음.
public class UserDetailDTO {
    private Long id;
    private Long appId;
    private String tdiToken;
    private String pushToken;
    private Integer os;
    private String adId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // UserEntity -> UserDetailDTO
    // return type : UserDetailDTO
    // parameter type : UserEntity

    public static UserDetailDTO toUserDetailDTO(UserEntity userEntity) {
        UserDetailDTO userDetailDTO = new UserDetailDTO();

        userDetailDTO.setId(userEntity.getId());
        userDetailDTO.setAppId(userEntity.getAppId());
        userDetailDTO.setTdiToken(userEntity.getTdiToken());
        userDetailDTO.setPushToken(userEntity.getPushToken());
        userDetailDTO.setOs(userEntity.getOs());
        userDetailDTO.setAdId(userEntity.getAdId());
        userDetailDTO.setCreatedAt(userEntity.getCreatedAt());
        userDetailDTO.setUpdatedAt(userEntity.getUpdatedAt());

        return userDetailDTO;
    }

    // Entity 타입의 List 를 DTO 타입의 List 로 변환하는 메서드
    // 위에 있는 Entity 를 DTO 로 변환해 주는 메서드를 사용해 더 간단하게 구현
    public static List<UserDetailDTO> change(List<UserEntity> userEntityList) {
        List<UserDetailDTO> userDetailDTOList = new ArrayList<>();

        for (UserEntity u : userEntityList) {
            userDetailDTOList.add(toUserDetailDTO(u));
        }

        return userDetailDTOList;
    }

}

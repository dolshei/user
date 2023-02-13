package com.tdi.user.entity;

import com.tdi.user.dto.UserSaveDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private Long appId;

    @Column(nullable = false)
    private String tdiToken;

    @Column(nullable = false, unique = true)
    private String pushToken;

    @Column(nullable = false)
    private Integer os;

    @Column()
    private String adId;

    // UserSaveDTO -> UserEntity 객체로 변환하기 위한 메서드
    public static UserEntity saveUser(UserSaveDTO userSaveDTO) {
        // UserEntity 타입의 객체를 보내기 위해 userEntity 라는 객체 선언
        UserEntity userEntity = new UserEntity();

        // userEntity 객체에 userSaveDTO 객체 안에 담긴 각 요소를 담아줌.
        userEntity.setAppId(userSaveDTO.getAppId());
        userEntity.setTdiToken(userSaveDTO.getTdiToken());
        userEntity.setPushToken(userSaveDTO.getPushToken());
        userEntity.setOs(userSaveDTO.getOs());
        userEntity.setAdId(userSaveDTO.getAdId());


        // 변환이 완료된 userEntity 객체를 넘겨줌
        return userEntity;
    }

}

package com.tdi.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveDTO {


    private Long appId;

    private String tdiToken;

    private String pushToken;
    private Integer os;

    private String adId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

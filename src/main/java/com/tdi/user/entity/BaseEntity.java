package com.tdi.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass       // 테이블로 생성되지 않도록 해주는 annotation
@EntityListeners(AuditingEntityListener.class)      // JPA 내부에서 Entity 객체가 생성/변경 되는 것을 감지하는 역할
@Getter
public class BaseEntity {

    @CreatedDate
    @Column(name = "create_at", updatable = false)      // 객체를 DB 에 반영할 때 create_at 컬럼값은 변경되지 않는다.
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

}

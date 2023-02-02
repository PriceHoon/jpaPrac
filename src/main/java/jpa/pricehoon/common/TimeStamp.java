package jpa.pricehoon.common;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jpa.pricehoon.user.User;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@MappedSuperclass // 엔티티에 매핑하기 위해서
@EntityListeners(AuditingEntityListener.class)
public class TimeStamp {

    //CreatedDate, LastModifiedDate는 구현체가 없어도 되지만 , CreatedBy,LastModifiedBy는 구현체가 필요함!
    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    @ManyToOne
    private User createdBy;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @LastModifiedBy
    @ManyToOne
    private User modifiedBy;

    public void updateCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    public void updateModifiedAt() {
        this.modifiedAt = LocalDateTime.now();
    }
    public void updateCreatedBy(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            this.createdBy = null;
        }
            this.createdBy = (User) authentication.getPrincipal();

    }

    public void updateModifiedBy(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            this.modifiedBy = null;
        }
        this.modifiedBy = (User) authentication.getPrincipal();

    }
}

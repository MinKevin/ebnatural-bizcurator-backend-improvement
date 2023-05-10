package ebnatural.bizcurator.apiserver.domain.constant;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class TimeEntity {
    @CreatedDate
    private String createdAt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd"));

    @LastModifiedDate
    private String modifiedAt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd"));

    @PrePersist
    //엔티티 저장 이전에 실행
    public void onPrePersist() {
        this.createdAt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        this.modifiedAt = this.createdAt;
    }

    @PreUpdate
    //엔티티 업데이트 이전에 실행
    public void onPreUpdate() {
        this.modifiedAt = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }
}

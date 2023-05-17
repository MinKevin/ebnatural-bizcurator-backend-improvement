package ebnatural.bizcurator.apiserver.domain;

import ebnatural.bizcurator.apiserver.domain.constant.BoardType;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Article extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @JoinColumn(name = "memberId")
    @ManyToOne(optional = false, fetch= FetchType.LAZY)
    private Member member;

    @Setter
    @Column(nullable = false)
    private String title;

    @Setter
    @Column(nullable = false, length = 1000)
    private String content;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BoardType boardType;

    @Setter
    @Column(nullable = false)
    private Boolean isFixed;

    private Article(Member member, String title, String content, BoardType boardType, Boolean isFixed) {
        this.member = member;
        this.title = title;
        this.content = content;
        this.boardType = boardType;
        this.isFixed = isFixed;
    }

    public static Article of(Member member, String title, String content, BoardType boardType, Boolean isFixed) {
        return new Article(member, title, content, boardType, isFixed);
    }

    public static Article of(Member member, String title, String content, BoardType boardType) {
        return new Article(member, title, content, boardType, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Article)) {
            return false;
        }
        Article that = (Article) o;
        return this.getId() != null && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
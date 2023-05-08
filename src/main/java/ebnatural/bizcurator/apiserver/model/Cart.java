package ebnatural.bizcurator.apiserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name = "cart")
@Entity
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    protected Cart() {

    }
    //TODO : product테이블이랑 join
}

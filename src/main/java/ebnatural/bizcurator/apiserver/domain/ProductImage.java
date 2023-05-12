package ebnatural.bizcurator.apiserver.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product_image")
@Getter
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "imgName")
    private String imgName;
    @Setter
    @Column(name = "oriImgName")
    private String oriImgName;
    @Setter
    @Column(name = "imgUrl")
    private String imgUrl;
    @Setter
    @Column(name = "repimgYn")
    private String repimgYn;
    @Setter
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public void updateItemImg(String oriImgName, String imgName, String imgUrl) {
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }
}

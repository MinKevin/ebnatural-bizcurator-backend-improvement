package ebnatural.bizcurator.apiserver.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSearchRequest {
    private String keyWord;
    private String sort;
}

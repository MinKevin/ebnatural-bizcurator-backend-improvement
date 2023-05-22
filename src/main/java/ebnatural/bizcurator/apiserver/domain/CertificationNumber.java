package ebnatural.bizcurator.apiserver.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@NoArgsConstructor
public class CertificationNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Email(message = "이메일 형식에 맞지 않습니다.")
    @Length(max = 320, message = "이메일은 320자리를 넘을 수 없습니다.")
    String username;
    @NotBlank
    String certificationNumber;

    public CertificationNumber(String username, String certificationNumber) {
        this.username = username;
        this.certificationNumber = certificationNumber;
    }

    public static CertificationNumber of(String username, String certificationNumber, BCryptPasswordEncoder passwordEncoder){
        return new CertificationNumber(username, passwordEncoder.encode(certificationNumber));
    }
}

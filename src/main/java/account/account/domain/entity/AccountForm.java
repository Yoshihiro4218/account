package account.account.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
//@Builder(access = AccessLevel.PUBLIC)
public class AccountForm implements Serializable {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}

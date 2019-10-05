package account.account.domain.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class AccountForm implements Serializable {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}

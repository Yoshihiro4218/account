package account.account.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "accounts")
@Data
public class Account implements Serializable {
    @Id
    @SequenceGenerator(name = "accounts_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String email;

    @Column(nullable=false, length=20)
    private String password;

    // TODO:DB側はNULLがOKになってる。がNotNull入れると死ぬ、要解決。
    @Column(nullable=false, updatable=false)
    private Date created_at;

    @Column(nullable=false)
    private Date updated_at;
}

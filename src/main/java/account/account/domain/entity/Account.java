package account.account.domain.entity;

import lombok.Data;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "accounts")
@Data
public class Account implements UserDetails {
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

    /* (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /* (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
     */
    @Override
    public String getUsername() {
        return this.email;
    }

    /* (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /* (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package account.account.domain.service;

import account.account.domain.entity.Account;
import account.account.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Account create(Account account, String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        account.setPassword(encodedPassword);
        return accountRepository.save(account);
    }
}

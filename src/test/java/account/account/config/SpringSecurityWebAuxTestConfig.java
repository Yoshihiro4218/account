//package account.account.config;
//
//import account.account.domain.entity.Account;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import java.util.Arrays;
//
//@TestConfiguration
//public class SpringSecurityWebAuxTestConfig {
//
//    @Bean
//    @Primary
//    public UserDetailsService userDetailsService() {
//        Account basicUser = Account.builder()
//                                   .id(1)
//                                   .email("test@test.com")
//                                   .password("testPassword")
//                                   .build();
//
//        UserActive basicActiveUser = new UserActive(basicUser, Arrays.asList(
//                new SimpleGrantedAuthority("ROLE_USER"),
//                new SimpleGrantedAuthority("PERM_FOO_READ")
//                                                                            ));
//
//        return new InMemoryUserDetailsManager(Arrays.asList(
//                basicActiveUser
//                                                           ));
//    }
//}

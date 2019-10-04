//package account.account.config;
//
//import lombok.*;
//import org.springframework.security.authentication.*;
//import org.springframework.security.core.*;
//import org.springframework.stereotype.*;
//
//@Component
//@AllArgsConstructor
//public class CustomAuthProvider implements AuthenticationProvider {
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//        // 認証するときの処理を。
//
//        List<GrantedAuthority> grantList = new ArrayList<>();
//        GrantedAuthority authority = new SimpleGrantedAuthority("USER");
//        grantList.add(authority);
//
//        return new UsernamePasswordAuthenticationToken(userName, hashedPassword, grantList);
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}

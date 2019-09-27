package account.account.config;

import account.account.domain.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.authentication.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 下記のようなディレクトリやファイルについては、ログインをしていようがしていまいがアクセスできるようにします。
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/favicon.ico", "/css/**", "/js/**", "/images/**", "/fonts/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // 認証が必要となるURLを設定します
            .antMatchers("/login", "/login/form").permitAll() // /loginFormは認証不要
            .antMatchers("/account/**").permitAll() // /account以下のURLも認証不要
            .anyRequest().authenticated() // それ以外はすべて認証された状態じゃなきゃダメだよ〜
        .and()
            .formLogin() // ログインページに飛ばすよ
            .loginProcessingUrl("/login") // ログイン処理をするURL
            .loginPage("/login/form") // ログインページのURL
            .failureUrl("/login/form/?error") // ログイン処理失敗時の遷移先
            .defaultSuccessUrl("/") // 認証成功時の遷移先
            .usernameParameter("email").passwordParameter("password"); // ユーザ名(今回はメールアドレスだけど)とパラメータ

//        http.formLogin()
//                .loginProcessingUrl("/login") // 認証処理を起動させるパス
//                .loginPage("/login/form") // ログインフォームのパス
//                .failureUrl("/login/form/?error") // ログイン処理失敗時の遷移先
//                .defaultSuccessUrl("/") // 認証成功時の遷移先
//                .usernameParameter("email").passwordParameter("password"); // ユーザ名(今回はメールアドレスだけど)とパラメータ

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout**")) // ログアウト処理を起動させるパス
                .logoutSuccessUrl("/"); // ログアウト完了時のパス
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    protected static class AuthenticationConfiguration
            extends GlobalAuthenticationConfigurerAdapter {
        @Autowired
        JpaUserDetailsServiceImpl userDetailsService;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService)
                    .passwordEncoder(new BCryptPasswordEncoder());
        }
    }
}

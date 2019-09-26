package account.account.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
            .antMatchers("/account/**").permitAll() // /account以下のURLも認証不要
            .anyRequest().authenticated(); // それ以外はすべて認証された状態じゃなきゃダメだよ〜
    }
}

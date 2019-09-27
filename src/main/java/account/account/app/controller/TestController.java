package account.account.app.controller;

import account.account.domain.entity.*;
import lombok.extern.slf4j.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class TestController {

    @GetMapping("/test")
    public String test(Model model, Authentication authentication) {
        Account account = (Account)authentication.getPrincipal();
        String userEmail = account.getEmail();
        log.info("authPrincipal={}", userEmail);
        model.addAttribute("user", userEmail);
        return "pages/index";
    }
}

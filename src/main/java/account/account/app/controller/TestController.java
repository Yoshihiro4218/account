package account.account.app.controller;

import lombok.extern.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.*;

@Controller
@Slf4j
public class TestController {

    @GetMapping("/test")
    public String test(Model model, HttpServletRequest httpServletRequest) {
        log.info("user={}", httpServletRequest.getRemoteUser());
        model.addAttribute("user", httpServletRequest.getRemoteUser());
        return "pages/index";
    }
}

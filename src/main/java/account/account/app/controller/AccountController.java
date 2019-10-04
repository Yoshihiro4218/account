package account.account.app.controller;

import account.account.domain.entity.*;
import account.account.domain.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.validation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @ModelAttribute
    public AccountForm setupForm() {
        return new AccountForm();
    }

    @GetMapping("")
    public String accountForm() {
        return "pages/accountForm";
    }

    @PostMapping("")
    String create(@Validated AccountForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pages/accountForm";
        }
        Account account = new Account();
        account.setEmail(form.getEmail());
        accountService.create(account, form.getPassword());
        return "redirect:/account/complete";
    }

    @GetMapping("/complete")
    String createFinish() {
        return "pages/accountComplete";
    }
}

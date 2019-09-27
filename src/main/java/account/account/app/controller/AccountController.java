package account.account.app.controller;

import account.account.domain.entity.Account;
import account.account.domain.entity.AccountForm;
import account.account.domain.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

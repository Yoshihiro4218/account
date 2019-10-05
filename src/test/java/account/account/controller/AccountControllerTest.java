package account.account.controller;

import account.account.app.controller.AccountController;
import account.account.domain.entity.Account;
import account.account.domain.entity.AccountForm;
import account.account.domain.service.AccountService;
import account.account.domain.service.JpaUserDetailsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    JpaUserDetailsServiceImpl jpaUserDetailsService;
    @MockBean
    AccountService accountService;

    @Test
    public void accountForm() throws Exception {
        mockMvc.perform(get("/account"))
               .andExpect(status().isOk())
               .andExpect(view().name("pages/accountForm"));
    }

    @Test
    public void create() throws Exception {
        AccountForm form = new AccountForm();
        form.setEmail("test@test.com");
        form.setPassword("testPassword");
        Account account = new Account();
        account.setEmail(form.getEmail());

        mockMvc.perform(post("/account")
                                .flashAttr("form", form)
                                .with(SecurityMockMvcRequestPostProcessors.csrf()))
               .andExpect(status().isFound())
               .andExpect(view().name("redirect:/account/complete"));

        // TODO: verify
//        verify(accountService, times(1))
//                .create(account, form.getPassword());
    }

    @Test
    public void create__formError() throws Exception {
        AccountForm form = new AccountForm();
        form.setEmail("test@test.com");
        form.setPassword("");
        Account account = new Account();
        account.setEmail(form.getEmail());

        mockMvc.perform(post("/account")
                                .flashAttr("form", form)
                                .with(SecurityMockMvcRequestPostProcessors.csrf()))
               .andExpect(status().isOk())
               .andExpect(model().hasErrors())
               .andExpect(view().name("pages/accountForm"));
    }

//    private static void accountFormBuilder() {
//        AccountForm accountForm = AccountForm.builder()
//                                             .email("test@test.com")
//                                             .password("testPassword")
//                                             .build();
//    }
}

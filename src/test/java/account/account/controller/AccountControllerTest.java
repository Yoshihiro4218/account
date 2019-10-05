package account.account.controller;

import account.account.app.controller.AccountController;
import account.account.app.controller.LoginController;
import account.account.domain.service.AccountService;
import account.account.domain.service.JpaUserDetailsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
}

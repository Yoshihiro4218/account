//package account.account.controller;
//
//import account.account.app.controller.LoginController;
//import account.account.app.controller.TestController;
//import account.account.domain.entity.Account;
//import account.account.domain.service.AccountService;
//import account.account.domain.service.JpaUserDetailsServiceImpl;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.core.Authentication;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(TestController.class)
//public class TestControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    JpaUserDetailsServiceImpl jpaUserDetailsService;
//    @MockBean
//    AccountService accountService;
//    @MockBean
//    Authentication authentication;
//
//
//    @Test
//    public void test() throws Exception {
//        Account account = new Account();
//        account.setEmail("test@test.com");
//        when((Account)authentication.getPrincipal()).thenReturn(account);
//
//        mockMvc.perform(get("/test"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("pages/index"));
//    }
//}

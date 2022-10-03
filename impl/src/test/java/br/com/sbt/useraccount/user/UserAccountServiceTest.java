package br.com.sbt.useraccount.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = UserAccountService.class)
class UserAccountServiceTest {

  @Autowired
  private UserAccountService service;

  @MockBean
  private UserAccountRepository repository;

  @Test
  void create() {
    UserAccount toCreate = UserAccount.builder()
        .username("user01")
        .build();
    UserAccount createdMock = UserAccount.builder()
        .username("user01")
        .build();
    when(repository.save(toCreate)).thenReturn(createdMock);
    UserAccount created = service.create(toCreate);
    assertEquals("user01", created.getUsername());
  }

}
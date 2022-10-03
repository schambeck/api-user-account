package br.com.sbt.useraccount.config;

import br.com.sbt.useraccount.user.UserAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;

import java.util.UUID;

@Configuration
class IdGeneratorConfig {

  @Bean
  BeforeConvertCallback<UserAccount> beforeSaveCallback() {
    return (user) -> {
      if (user.getId() == null) {
        user.setId(UUID.randomUUID().toString());
      }
      return user;
    };
  }

}

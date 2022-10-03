package br.com.sbt.useraccount.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAccountWeb {

  private String id;
  private String username;
  private String email;
  private String firstName;
  private String lastName;

}

package br.com.sbt.useraccount.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@Table("user_account")
public class UserAccount implements Serializable {

  @Id
  private String id;
  private String username;
  private String email;
  private String firstName;
  private String lastName;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserAccount userAccount = (UserAccount) o;
    return Objects.equals(username, userAccount.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username);
  }

}

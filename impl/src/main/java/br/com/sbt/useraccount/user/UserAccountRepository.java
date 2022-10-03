package br.com.sbt.useraccount.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, UUID> {

  Optional<UserAccount> findByUsername(String username);

}

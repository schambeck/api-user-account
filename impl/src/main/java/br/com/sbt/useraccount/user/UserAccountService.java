package br.com.sbt.useraccount.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAccountService {

    private final UserAccountRepository repository;

//    @CacheEvict(value = "user", key = "T(org.springframework.cache.interceptor.SimpleKey).EMPTY")
    public UserAccount create(UserAccount userAccount) {
        log.info("Create: {}", userAccount);
        return repository.save(userAccount);
    }

//    @Cacheable("user")
    public List<UserAccount> list() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

}

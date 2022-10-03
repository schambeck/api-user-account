package br.com.sbt.useraccount.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
class UserAccountController {

    private final UserAccountService service;

    @PostMapping
    ResponseEntity<UserAccountWeb> create(@RequestBody UserAccountRequestWeb user) {
        log.info("Create: {}", user);
        UserAccount created = service.create(UserAccountMapper.INSTANCE.toEntity(user));
        return ResponseEntity.ok(UserAccountMapper.INSTANCE.toWeb(created));
    }

    @GetMapping
    ResponseEntity<List<UserAccountWeb>> list() {
        List<UserAccountWeb> users = service.list().stream()
            .map(UserAccountMapper.INSTANCE::toWeb)
            .collect(toList());
        return ResponseEntity.ok(users);
    }

}

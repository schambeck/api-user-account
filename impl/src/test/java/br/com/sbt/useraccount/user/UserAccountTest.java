package br.com.sbt.useraccount.user;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static nl.jqno.equalsverifier.Warning.ALL_FIELDS_SHOULD_BE_USED;

class UserAccountTest {

    @Test
    void equalsContract() {
        EqualsVerifier.simple()
            .suppress(ALL_FIELDS_SHOULD_BE_USED)
            .forClass(UserAccount.class)
            .verify();
    }

}
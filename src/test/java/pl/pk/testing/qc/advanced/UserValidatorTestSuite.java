package pl.pk.testing.qc.advanced;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserValidatorTestSuite {

    private UserValidator userValidator = new UserValidator();

    @ParameterizedTest
    @ValueSource(strings = {"jan+", "/heniek"})
    public void should_return_false_after_match_for_username(String username) {
        assertFalse(userValidator.validateUsername(username));
    }

    @ParameterizedTest
    @ValueSource(strings = {"janek123", "-heniek"})
    public void should_return_true_after_match_for_username(String username) {
        assertTrue(userValidator.validateUsername(username));
    }

    @ParameterizedTest
    @ValueSource(strings = {"jan@pl.123", "/heniek/@jan.pl"})
    public void should_return_false_after_match_for_mail(String mail) {
        assertFalse(userValidator.validateEmail(mail));
    }

    @ParameterizedTest
    @ValueSource(strings = {"janek123@op.pl", "heniek@onet.gov"})
    public void should_return_true_after_match_for_mail(String mail) {
        assertTrue(userValidator.validateEmail(mail));
    }

}

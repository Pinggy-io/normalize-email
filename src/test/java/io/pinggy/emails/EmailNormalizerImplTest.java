package io.pinggy.emails;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailNormalizerImplTest {

    private final EmailNormalizer emailNormalizer = new EmailNormalizerImpl();

    //Added new strategy to test
    private static class testEmailNormalizationStrategy implements EmailNormalizationStrategy {

        @Override
        public String normalizeEmailString(String localPart, String domain) {
            return localPart + "@" + domain;
        }
    }

    @Test
    public void checkGmailNormalize() {
        assertEquals("johndoe@gmail.com", emailNormalizer.normalize("john.doe+test@gmail.com"));
        assertEquals("johndoe@gmail.com", emailNormalizer.normalize("John.d.o.e+test+test1@gmail.com"));
        assertEquals("johndoe@gmail.com", emailNormalizer.normalize("John.d.o.e+test+test1@googlemail.com"));
    }

    @Test
    public void checkOutlookNormalize() {
        assertEquals("johndoe@outlook.com", emailNormalizer.normalize("Johndoe+test@outlook.com"));
        assertEquals("johndoe@outlook.com", emailNormalizer.normalize("johndoe+test+test1@outlook.com"));
        assertEquals("john.doe@outlook.com", emailNormalizer.normalize("john.doe+test@outlook.com"));
    }

    @Test
    public void checkLiveNormalize() {
        assertEquals("johndoe@live.com", emailNormalizer.normalize("Johndoe+test@live.com"));
        assertEquals("johndoe@live.com", emailNormalizer.normalize("johndoe+test+test1@live.com"));
        assertEquals("johndoe@live.com", emailNormalizer.normalize("john.doe+test@live.com"));
    }

    @Test
    public void checkHotmailNormalize() {
        assertEquals("johndoe@hotmail.com", emailNormalizer.normalize("Johndoe+test@hotmail.com"));
        assertEquals("johndoe@hotmail.com", emailNormalizer.normalize("johndoe+test+test1@hotmail.com"));
        assertEquals("john.doe@hotmail.com", emailNormalizer.normalize("john.doe+test@hotmail.com"));
    }

    @Test
    public void checkDefaultNormalize() {
        assertEquals("contact@pinggy.io", emailNormalizer.normalize("contact@pinggy.io"));
        assertEquals("contact@pinggy.io", emailNormalizer.normalize("Contact@Pinggy.io"));
        assertEquals("contact.p@pinggy.io", emailNormalizer.normalize("Contact.p@Pinggy.io"));
    }

    @Test
    public void testAddStrategy() {
        emailNormalizer.addStrategy("test.com", new testEmailNormalizationStrategy());
        assertEquals("john.doe@test.com", emailNormalizer.normalize("John.Doe@Test.com"));
    }

    @Test
    public void testOverrideStrategy() {
        emailNormalizer.addStrategy("live.com", new testEmailNormalizationStrategy());
        assertEquals("john.doe@live.com", emailNormalizer.normalize("John.Doe@live.com"));
    }

    @Test
    public void testUnicodeEmails() {
        assertEquals("johndoe\tγ@live.com", emailNormalizer.normalize("John.Doe\tΓ@live.com"));
        assertEquals("अ@live.com", emailNormalizer.normalize("अ@live.com"));
        assertEquals("γ@live.com", emailNormalizer.normalize("Γ@live.com"));
        assertEquals("γ@live.com", emailNormalizer.normalize("γ@live.com"));
    }
}
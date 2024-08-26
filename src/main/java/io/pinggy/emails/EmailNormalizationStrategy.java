package io.pinggy.emails;

/**
 * Interface for email normalization strategies.
 */
public interface EmailNormalizationStrategy {

    /**
     * Normalizes the given local part of an email address.
     *
     * @param localPart The local part of the email.
     * @param domain    The domain of the email.
     * @return The normalized email string.
     */
    String normalizeEmailString(String localPart, String domain);
}
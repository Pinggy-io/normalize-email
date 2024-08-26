package io.pinggy.emails;

import io.pinggy.emails.util.EmailNormalizationUtils;

/**
 * Normalization strategy for Gmail addresses.
 */
public class GmailNormalizationStrategy implements EmailNormalizationStrategy {

    @Override
    public String normalizeEmailString(String localPart, String domain) {
        // Normalize the domain to gmail.com
        if (domain.equals("googlemail.com")) {
            domain = "gmail.com";
        }

        localPart = EmailNormalizationUtils.removeDots(localPart);
        localPart = EmailNormalizationUtils.removeSuffixAfterPlus(localPart);

        return localPart + "@" + domain;
    }
}
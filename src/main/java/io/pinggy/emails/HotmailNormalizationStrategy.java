package io.pinggy.emails;

import io.pinggy.emails.util.EmailNormalizationUtils;

/**
 * Normalization strategy for Hotmail addresses.
 */
public class HotmailNormalizationStrategy implements EmailNormalizationStrategy {

    @Override
    public String normalizeEmailString(String localPart, String domain) {

        localPart = EmailNormalizationUtils.removeSuffixAfterPlus(localPart);

        return localPart + "@" + domain;
    }
}

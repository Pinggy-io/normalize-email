package io.pinggy.emails;

import io.pinggy.emails.util.EmailNormalizationUtils;

/**
 * Normalization strategy for Live addresses.
 */
public class LiveNormalizationStrategy implements EmailNormalizationStrategy {

    @Override
    public String normalizeEmailString(String localPart, String domain) {

        localPart = EmailNormalizationUtils.removeDots(localPart);
        localPart = EmailNormalizationUtils.removeSuffixAfterPlus(localPart);

        return localPart + "@" + domain;
    }
}

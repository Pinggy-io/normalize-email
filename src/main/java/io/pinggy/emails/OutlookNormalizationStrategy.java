package io.pinggy.emails;

import io.pinggy.emails.util.EmailNormalizationUtils;

/**
 * Normalization strategy for Outlook addresses.
 */
public class OutlookNormalizationStrategy implements EmailNormalizationStrategy {

    @Override
    public String normalizeEmailString(String localPart, String domain) {
        localPart = EmailNormalizationUtils.removeSuffixAfterPlus(localPart);
        return localPart + "@" + domain;
    }
}

package io.pinggy.emails;

public class DefaultNormalizationStrategy implements EmailNormalizationStrategy {

    @Override
    public String normalizeEmailString(String localPart, String domain) {
        return localPart + "@" + domain;
    }

}

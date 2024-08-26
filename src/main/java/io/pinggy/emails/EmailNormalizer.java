package io.pinggy.emails;

/**
 * Interface for normalizing email addresses and adding new normalization strategy.
 */
public interface EmailNormalizer {


    String normalize(String email);

    void addStrategy(String domain, EmailNormalizationStrategy strategy);
}
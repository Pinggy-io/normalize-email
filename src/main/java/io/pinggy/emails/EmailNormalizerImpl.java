package io.pinggy.emails;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Implementation of email normalizer
 */
public class EmailNormalizerImpl implements EmailNormalizer {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    private final Map<String, EmailNormalizationStrategy> strategies = new HashMap<>();

    public EmailNormalizerImpl() {

        /**
         * Initialize the map with default email normalization strategies for common domains.
         * Each domain is associated with a specific strategy to handle its unique normalization rules.
         */
        strategies.put("gmail.com", new GmailNormalizationStrategy());
        strategies.put("outlook.com", new OutlookNormalizationStrategy());
        strategies.put("googlemail.com", new GmailNormalizationStrategy());
        strategies.put("live.com", new LiveNormalizationStrategy());
        strategies.put("hotmail.com", new HotmailNormalizationStrategy());
    }

    @Override
    public String normalize(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        email = email.toLowerCase();

        // Split email into local part and domain
        String[] parts = email.split("@");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid email format");
        }
        String localPart = parts[0];
        String domain = parts[1];

        //Matches Email String to check whether it is valid format or not
        if (!EMAIL_PATTERN.matcher(domain).matches()) {
            throw new IllegalArgumentException("Invalid domain format");
        }

        /**
         * Retrieve the normalization strategy for the given domain from the map.
         * If the domain is not found in the map, uses the default normalization strategy.
         */
        EmailNormalizationStrategy strategy = strategies.getOrDefault(domain, new DefaultNormalizationStrategy());
        return strategy.normalizeEmailString(localPart, domain);
    }

    // You can add or update strategies in the map as needed to handle additional domains.
    @Override
    public void addStrategy(String domain, EmailNormalizationStrategy strategy) {
        if (domain == null || domain.isEmpty()) {
            throw new IllegalArgumentException("Domain cannot be null or empty");
        }
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null");
        }
        strategies.put(domain, strategy);
    }
}
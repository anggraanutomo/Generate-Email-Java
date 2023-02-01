package org.example;

import java.util.Random;

public class EmailGenerator {

    private static final String[] EMAIL_PROVIDERS = {"gmail", "hotmail", "yahoo", "ymail"};
    private static final String[] EMAIL_DOMAINS = {".com", ".edu", ".co.id", ".gov"};

    public static String generateEmail() {
        Random random = new Random();

        // generate random characters for part 1
        String part1 = "";
        int length1 = random.nextInt(5) + 5;
        for (int i = 0; i < length1; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            part1 = part1 + c;
        }

        // generate random characters for part 3
        String part3 = "";
        int length3 = random.nextInt(5) + 5;
        for (int i = 0; i < length3; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            part3 = part3 + c;
        }

        // choose random email provider
        int emailProviderIndex = random.nextInt(EMAIL_PROVIDERS.length);
        String emailProvider = EMAIL_PROVIDERS[emailProviderIndex];

        // choose random email domain
        int emailDomainIndex = random.nextInt(EMAIL_DOMAINS.length);
        String emailDomain = EMAIL_DOMAINS[emailDomainIndex];

        // choose random 2-digit number
        int twoDigits = random.nextInt(100);

        // choose random connector (_ or .)
        String connector = random.nextInt(2) == 0 ? "_" : ".";

        // build email string
        String email = part1 + connector + part3 + twoDigits + "@" + emailProvider + emailDomain;

        return email;
    }


}

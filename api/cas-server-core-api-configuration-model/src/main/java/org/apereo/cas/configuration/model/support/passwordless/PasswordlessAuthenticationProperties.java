package org.apereo.cas.configuration.model.support.passwordless;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apereo.cas.configuration.model.core.util.EncryptionJwtSigningJwtCryptographyProperties;
import org.apereo.cas.configuration.model.support.email.EmailProperties;
import org.apereo.cas.configuration.model.support.sms.SmsProperties;
import org.apereo.cas.configuration.support.RequiresModule;
import org.apereo.cas.configuration.support.RestEndpointProperties;
import org.apereo.cas.configuration.support.SpringResourceProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This is {@link PasswordlessAuthenticationProperties}.
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@RequiresModule(name = "cas-server-support-passwordless")
@Slf4j
@Getter
@Setter
public class PasswordlessAuthenticationProperties implements Serializable {
    private static final long serialVersionUID = 8726382874579042117L;

    /**
     * Properties to instruct CAS how accounts for passwordless authentication should be located.
     */
    private Accounts accounts = new Accounts();

    /**
     * Properties to instruct CAS how tokens for passwordless authentication should be located.
     */
    private Tokens tokens = new Tokens();

    @Getter
    @Setter
    public static class Accounts {
        /**
         * Passwordless authentication settings via Groovy.
         */
        private Groovy groovy = new Groovy();

        /**
         * Passwordless authentication settings using static accounts.
         * The key is the user identifier, while the value is the form of
         * contact such as email, sms, etc.
         */
        private Map<String, String> simple = new LinkedHashMap<>();
    }

    @Getter
    @Setter
    public static class Tokens {

        /**
         * Indicate how long should the token be considered valid.
         */
        private final int expireInSeconds = 180;

        /**
         * Email settings for notifications.
         */
        @NestedConfigurationProperty
        private EmailProperties mail = new EmailProperties();

        /**
         * SMS settings for notifications.
         */
        @NestedConfigurationProperty
        private SmsProperties sms = new SmsProperties();
    }

    @RequiresModule(name = "cas-server-support-passwordless")
    @Getter
    @Setter
    public static class Groovy extends SpringResourceProperties {
        private static final long serialVersionUID = 8079027843747126083L;
    }

    @RequiresModule(name = "cas-server-support-passwordless")
    @Getter
    @Setter
    public static class Rest extends RestEndpointProperties {
        private static final long serialVersionUID = -8102345678378393382L;
    }

}

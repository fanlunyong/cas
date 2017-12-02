package org.apereo.cas.support.saml.web.idp.profile.builders.response.query;

import org.apache.velocity.app.VelocityEngine;
import org.apereo.cas.support.saml.OpenSamlConfigBean;
import org.apereo.cas.support.saml.web.idp.profile.builders.SamlProfileObjectBuilder;
import org.apereo.cas.support.saml.web.idp.profile.builders.enc.BaseSamlObjectSigner;
import org.apereo.cas.support.saml.web.idp.profile.builders.enc.SamlObjectEncrypter;
import org.apereo.cas.support.saml.web.idp.profile.builders.response.soap.SamlProfileSamlSoap11FaultResponseBuilder;
import org.opensaml.saml.common.SAMLObject;
import org.opensaml.saml.saml2.core.Assertion;

/**
 * This is {@link SamlProfileAttributeQueryFaultResponseBuilder}.
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
public class SamlProfileAttributeQueryFaultResponseBuilder extends SamlProfileSamlSoap11FaultResponseBuilder {
    private static final long serialVersionUID = -5582616946993706815L;

    public SamlProfileAttributeQueryFaultResponseBuilder(final OpenSamlConfigBean openSamlConfigBean, final BaseSamlObjectSigner samlObjectSigner,
                                                         final VelocityEngine velocityEngineFactory,
                                                         final SamlProfileObjectBuilder<Assertion> samlProfileSamlAssertionBuilder,
                                                         final SamlProfileObjectBuilder<? extends SAMLObject> saml2ResponseBuilder,
                                                         final SamlObjectEncrypter samlObjectEncrypter) {
        super(openSamlConfigBean, samlObjectSigner, velocityEngineFactory, samlProfileSamlAssertionBuilder,
            saml2ResponseBuilder, samlObjectEncrypter);
    }
}

package org.apereo.cas.audit.spi.resource;

import org.apereo.cas.services.RegisteredServiceTestUtils;

import lombok.val;
import org.aspectj.lang.JoinPoint;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * This is {@link ServiceAuditResourceResolverTests}.
 *
 * @author Misagh Moayyed
 * @since 6.0.0
 */
@Tag("Audits")
public class ServiceAuditResourceResolverTests {
    @Test
    public void verifyOperation() {
        val jp = mock(JoinPoint.class);
        when(jp.getArgs()).thenReturn(new Object[]{"something", RegisteredServiceTestUtils.getService()});
        val resolver = new ServiceAuditResourceResolver();
        var input = resolver.resolveFrom(jp, null);
        assertTrue(input.length > 0);

        input = resolver.resolveFrom(jp, new RuntimeException());
        assertTrue(input.length > 0);
    }
}

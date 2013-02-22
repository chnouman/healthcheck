package net.atos.xa.production.healthcheck.spi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import net.atos.xa.healthcheck.servlet.RegisterHealthCheck;

import org.junit.Test;

import com.yammer.metrics.core.HealthCheck;

public class RegisterHealthCheckTestCase {

	@Test
	public void testGetFilteredHealthChecksList() {

		Collection<HealthCheck> healthChecks = RegisterHealthCheck
				.getFilteredHealthChecksList(null);

		assertNotNull(healthChecks);
		assertEquals(3, healthChecks.size());

		healthChecks = RegisterHealthCheck
				.getFilteredHealthChecksList("testCheck3 ");

		assertNotNull(healthChecks);
		assertEquals(2, healthChecks.size());

		healthChecks = RegisterHealthCheck
				.getFilteredHealthChecksList("testCheck3   ;   testCheck2");

		assertNotNull(healthChecks);
		assertEquals(1, healthChecks.size());

	}
}
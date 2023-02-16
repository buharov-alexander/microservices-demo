/***************       BEGIN-STANDARD-COPYRIGHT      ***************

 Copyright (c) 2009-2023, Spirent Communications.

 All rights reserved. Proprietary and confidential information of Spirent Communications.
 ***************        END-STANDARD-COPYRIGHT       ***************/
package ru.buharov.microservices.producer.kafka;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class KafkaHealthIndicator implements HealthIndicator {
	@Override
	public Health health() {
		return Health.down().build();
	}
}

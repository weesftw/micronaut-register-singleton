package com.example.healthcheck;

import com.example.manager.HealthManager;
import io.micronaut.core.async.publisher.Publishers;
import io.micronaut.health.HealthStatus;
import io.micronaut.management.health.indicator.HealthIndicator;
import io.micronaut.management.health.indicator.HealthResult;
import org.reactivestreams.Publisher;

public class MicronautHealthIndicator implements HealthIndicator
{
    private final HealthManager healthManager;

    public MicronautHealthIndicator(HealthManager healthManager)
    {
        this.healthManager = healthManager;
    }

    @Override
    public Publisher<HealthResult> getResult()
    {
        var health = healthManager.getHealth();

        return Publishers.just(
                HealthResult
                        .builder(health.getName(),
                                new HealthStatus(health.getStatus().name()))
                        .details(health.getDescription())
                        .build()
        );
    }
}

package com.example.config;

import com.example.health.MicronautHealthIndicator;
import com.example.manager.HealthManager;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.annotation.Context;
import io.micronaut.inject.qualifiers.Qualifiers;
import io.micronaut.management.health.indicator.HealthIndicator;
import jakarta.inject.Inject;

import java.util.List;

@Context
public class MicronautHealthBeanInitialization
{
    @Inject
    public MicronautHealthBeanInitialization(ApplicationContext context, List<HealthManager> managers)
    {
        for(HealthManager manager : managers)
            context.registerSingleton(HealthIndicator.class,
                    new MicronautHealthIndicator(manager),
                    Qualifiers.byName(manager.getHealth().getName()));
    }
}

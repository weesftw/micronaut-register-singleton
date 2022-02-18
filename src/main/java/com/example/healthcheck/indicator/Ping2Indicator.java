package com.example.healthcheck.indicator;

import com.example.manager.DefaultHealth;
import com.example.manager.HealthManager;
import jakarta.inject.Named;

@Named
public class Ping2Indicator implements HealthManager
{
    @Override
    public DefaultHealth getHealth()
    {
        return DefaultHealth.up("ping2")
                .build();
    }
}

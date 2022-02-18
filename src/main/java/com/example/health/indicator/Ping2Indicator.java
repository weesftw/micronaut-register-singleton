package com.example.health.indicator;

import com.example.manager.DefaultHealth;
import com.example.manager.HealthManager;
import jakarta.inject.Named;

@Named("ping2")
public class Ping2Indicator implements HealthManager
{
    @Override
    public DefaultHealth getHealth()
    {
        return DefaultHealth.up("ping2")
                .build();
    }
}

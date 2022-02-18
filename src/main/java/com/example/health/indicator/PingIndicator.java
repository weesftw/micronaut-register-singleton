package com.example.health.indicator;

import com.example.manager.DefaultHealth;
import com.example.manager.HealthManager;
import jakarta.inject.Named;

@Named("ping")
public class PingIndicator implements HealthManager
{
    @Override
    public DefaultHealth getHealth()
    {
        return DefaultHealth.down("ping1")
                .build();
    }
}

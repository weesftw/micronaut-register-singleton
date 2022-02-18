package com.example.manager;

import lombok.Getter;

import java.util.Map;

@Getter
public final class DefaultHealth
{
    private final String name;
    private final HealthStatus status;
    private final Map<String, ?> description;

    public DefaultHealth(Builder builder)
    {
        this.name = builder.name;
        this.status = builder.status;
        this.description = builder.description;
    }

    public static Builder up(String name)
    {
        return new Builder(name, HealthStatus.UP);
    }

    public static Builder down(String name)
    {
        return new Builder(name, HealthStatus.DOWN);
    }

    public static Builder unavaliable(String name)
    {
        return new Builder(name, HealthStatus.UNAVALIABLE);
    }

    public static class Builder
    {
        private final String name;
        private final HealthStatus status;
        private Map<String, ?> description;

        public Builder(String name, HealthStatus status)
        {
            this.name = name;
            this.status = status;
        }

        public Builder description(Map<String, ?>  description)
        {
            this.description = description;
            return this;
        }

        public DefaultHealth build()
        {
            return new DefaultHealth(this);
        }
    }
}

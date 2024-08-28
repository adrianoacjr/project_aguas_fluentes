package com.example.projeto_aguas_fluentes.domain;

import java.math.BigDecimal;

public class PressureThresholds {
    private BigDecimal minimalThreshold;

    private BigDecimal maximumThreshold;

    public PressureThresholds(BigDecimal minimalThreshold, BigDecimal maximumThreshold) {
        this.minimalThreshold = minimalThreshold;
        this.maximumThreshold = maximumThreshold;
    }

    public BigDecimal getMinimumThreshold() {
        return minimalThreshold;
    }

    public void setMinimalThreshold(BigDecimal minimalThreshold) {
        this.minimalThreshold = minimalThreshold;
    }

    public BigDecimal getMaximumThreshold() {
        return maximumThreshold;
    }

    public void setMaximumThreshold(BigDecimal maximumThreshold) {
        this.maximumThreshold = maximumThreshold;
    }
}

package br.com.gubee.interview.application.gateway;

import br.com.gubee.interview.core.domain.PowerStats;

public interface CreatePowerStatsGateway {
    PowerStats create(PowerStats powerStats);
}

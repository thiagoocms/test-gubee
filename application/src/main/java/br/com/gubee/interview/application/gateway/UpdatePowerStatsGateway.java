package br.com.gubee.interview.application.gateway;

import br.com.gubee.interview.core.domain.PowerStats;

import java.util.UUID;

public interface UpdatePowerStatsGateway {

    PowerStats updateById(UUID id, PowerStats powerStats);

}

package br.com.gubee.interview.infrastructure.gatewayimpl;

import br.com.gubee.interview.application.gateway.CreatePowerStatsGateway;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.infrastructure.repository.PowerStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CreatePowerStatsGatewayImpl implements CreatePowerStatsGateway {

    @Lazy
    @Autowired
    private PowerStatsRepository powerStatsRepository;

    @Override
    public PowerStats create(PowerStats powerStats) {
        return powerStatsRepository.create(powerStats);
    }
}

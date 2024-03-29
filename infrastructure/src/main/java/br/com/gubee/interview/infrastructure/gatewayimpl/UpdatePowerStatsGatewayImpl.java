package br.com.gubee.interview.infrastructure.gatewayimpl;

import br.com.gubee.interview.application.gateway.UpdatePowerStatsGateway;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.infrastructure.repository.PowerStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdatePowerStatsGatewayImpl implements UpdatePowerStatsGateway {

    @Lazy
    @Autowired
    private PowerStatsRepository powerStatsRepository;

    @Override
    public PowerStats updateById(UUID id, PowerStats powerStats) {
        return powerStatsRepository.update(id, powerStats);
    }
}

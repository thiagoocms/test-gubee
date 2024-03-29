package br.com.gubee.interview.infrastructure.gatewayimpl;

import br.com.gubee.interview.application.gateway.FindPowerStatsByIdGateway;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.infrastructure.repository.PowerStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindPowerStatsByIdGatewayImpl implements FindPowerStatsByIdGateway {

    @Lazy
    @Autowired
    private PowerStatsRepository powerStatsRepository;

    @Override
    public PowerStats findById(UUID id) {
        return powerStatsRepository.findById(id);
    }
}

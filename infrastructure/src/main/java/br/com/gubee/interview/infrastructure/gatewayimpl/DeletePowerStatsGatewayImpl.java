package br.com.gubee.interview.infrastructure.gatewayimpl;

import br.com.gubee.interview.application.gateway.DeletePowerStatsGateway;
import br.com.gubee.interview.infrastructure.repository.PowerStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeletePowerStatsGatewayImpl implements DeletePowerStatsGateway {

    private final PowerStatsRepository powerStatsRepository;

    @Autowired
    public DeletePowerStatsGatewayImpl(PowerStatsRepository powerStatsRepository) {
        this.powerStatsRepository = powerStatsRepository;
    }

    @Override
    public void deleteById(UUID id) {
        this.powerStatsRepository.deleteById(id);
    }
}

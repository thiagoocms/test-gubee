package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.CreatePowerStatsGateway;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.core.exception.BadRequestException;
import br.com.gubee.interview.usecase.CreatePowerStatsUseCase;

public class CreatePowerStatsUseCaseImpl implements CreatePowerStatsUseCase {

    private final CreatePowerStatsGateway createPowerStatsGateway;

    public CreatePowerStatsUseCaseImpl(CreatePowerStatsGateway createPowerStatsGateway) {
        this.createPowerStatsGateway = createPowerStatsGateway;
    }

    @Override
    public PowerStats create(PowerStats powerStats) {
        if (powerStats == null) {
            throw new BadRequestException("As habilidades são obrigatórias");
        }
        return this.createPowerStatsGateway.create(powerStats);
    }
}

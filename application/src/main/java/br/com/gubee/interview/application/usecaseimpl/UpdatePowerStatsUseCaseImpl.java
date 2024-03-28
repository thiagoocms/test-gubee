package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.UpdatePowerStatsGateway;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.usecase.UpdatePowerStatsUseCase;

import java.util.UUID;

public class UpdatePowerStatsUseCaseImpl implements UpdatePowerStatsUseCase {

    private final UpdatePowerStatsGateway updatePowerStatsGateway;

    public UpdatePowerStatsUseCaseImpl(UpdatePowerStatsGateway updatePowerStatsGateway) {
        this.updatePowerStatsGateway = updatePowerStatsGateway;
    }

    @Override
    public PowerStats updateById(UUID id, PowerStats powerStats) {
        return this.updatePowerStatsGateway.updateById(id, powerStats);
    }
}

package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.UpdatePowerStatsGateway;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.usecase.FindPowerStatsByIdUseCase;
import br.com.gubee.interview.usecase.UpdatePowerStatsUseCase;

import java.time.LocalDateTime;
import java.util.UUID;

public class UpdatePowerStatsUseCaseImpl implements UpdatePowerStatsUseCase {

    private final UpdatePowerStatsGateway updatePowerStatsGateway;
    private final FindPowerStatsByIdUseCase findPowerStatsByIdUseCase;

    public UpdatePowerStatsUseCaseImpl(UpdatePowerStatsGateway updatePowerStatsGateway, FindPowerStatsByIdUseCase findPowerStatsByIdUseCase) {
        this.updatePowerStatsGateway = updatePowerStatsGateway;
        this.findPowerStatsByIdUseCase = findPowerStatsByIdUseCase;
    }

    @Override
    public PowerStats updateById(UUID id, PowerStats powerStats) {
        PowerStats existPowerStats = this.findPowerStatsByIdUseCase.findById(id);
        powerStats.setId(id);
        powerStats.setCreatedAt(existPowerStats.getCreatedAt());
        powerStats.setUpdatedAt(LocalDateTime.now());
        return this.updatePowerStatsGateway.updateById(id, powerStats);
    }
}

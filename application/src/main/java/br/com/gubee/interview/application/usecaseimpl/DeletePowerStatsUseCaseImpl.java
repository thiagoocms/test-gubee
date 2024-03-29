package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.DeletePowerStatsGateway;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.usecase.DeletePowerStatsUseCase;
import br.com.gubee.interview.usecase.FindPowerStatsByIdUseCase;

import java.util.UUID;

public class DeletePowerStatsUseCaseImpl implements DeletePowerStatsUseCase {

    private final DeletePowerStatsGateway deletePowerStatsGateway;
    private final FindPowerStatsByIdUseCase findPowerStatsByIdUseCase;

    public DeletePowerStatsUseCaseImpl(DeletePowerStatsGateway deletePowerStatsGateway, FindPowerStatsByIdUseCase findPowerStatsByIdUseCase) {
        this.deletePowerStatsGateway = deletePowerStatsGateway;
        this.findPowerStatsByIdUseCase = findPowerStatsByIdUseCase;
    }

    @Override
    public void deleteById(UUID id) {
        PowerStats powerStats = this.findPowerStatsByIdUseCase.findById(id);
        this.deletePowerStatsGateway.deleteById(powerStats.getId());
    }
}

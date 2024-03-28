package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.DeletePowerStatsGateway;
import br.com.gubee.interview.usecase.DeletePowerStatsUseCase;

import java.util.UUID;

public class DeletePowerStatsUserCaseImpl implements DeletePowerStatsUseCase {

    private final DeletePowerStatsGateway deletePowerStatsGateway;

    public DeletePowerStatsUserCaseImpl(DeletePowerStatsGateway deletePowerStatsGateway) {
        this.deletePowerStatsGateway = deletePowerStatsGateway;
    }

    @Override
    public void deleteById(UUID id) {
        this.deletePowerStatsGateway.deleteById(id);
    }
}

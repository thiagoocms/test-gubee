package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.FindPowerStatsByIdGateway;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.core.exception.ResourceNotFoundException;
import br.com.gubee.interview.usecase.FindPowerStatsByIdUseCase;

import java.util.UUID;

public class FindPowerStatsByIdUserCaseImpl implements FindPowerStatsByIdUseCase {

    private final FindPowerStatsByIdGateway powerStatsByIdGateway;

    public FindPowerStatsByIdUserCaseImpl(FindPowerStatsByIdGateway powerStatsByIdGateway) {
        this.powerStatsByIdGateway = powerStatsByIdGateway;
    }

    @Override
    public PowerStats findById(UUID id) {
        PowerStats powerStats = this.powerStatsByIdGateway.findById(id);
        if (powerStats == null) {
            throw new ResourceNotFoundException("");
        }
        return powerStats;
    }
}

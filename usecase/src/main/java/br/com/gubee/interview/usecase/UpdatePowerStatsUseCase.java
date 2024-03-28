package br.com.gubee.interview.usecase;

import br.com.gubee.interview.core.domain.PowerStats;

import java.util.UUID;

public interface UpdatePowerStatsUseCase {
    PowerStats updateById(UUID id, PowerStats powerStats);
}

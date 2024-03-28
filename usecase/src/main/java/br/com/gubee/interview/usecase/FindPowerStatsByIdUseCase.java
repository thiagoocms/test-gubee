package br.com.gubee.interview.usecase;

import br.com.gubee.interview.core.domain.PowerStats;

import java.util.UUID;

public interface FindPowerStatsByIdUseCase {
    PowerStats findById(UUID id);
}

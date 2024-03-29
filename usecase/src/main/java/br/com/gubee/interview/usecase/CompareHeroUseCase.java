package br.com.gubee.interview.usecase;

import br.com.gubee.interview.core.domain.HeroComparePowerStats;

import java.util.UUID;

public interface CompareHeroUseCase {
    HeroComparePowerStats compareTo(UUID heroId, UUID opponentId);
}

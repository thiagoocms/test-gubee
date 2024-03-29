package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.HeroComparePowerStats;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.usecase.CompareHeroUseCase;
import br.com.gubee.interview.usecase.FindHeroByIdUseCase;

import java.util.UUID;

public class CompareHeroUseCaseImpl implements CompareHeroUseCase {

    private final FindHeroByIdUseCase findHeroByIdUseCase;

    public CompareHeroUseCaseImpl(FindHeroByIdUseCase findHeroByIdUseCase) {
        this.findHeroByIdUseCase = findHeroByIdUseCase;
    }

    @Override
    public HeroComparePowerStats compareTo(UUID heroId, UUID opponentId) {
        Hero hero = this.findHeroByIdUseCase.findById(heroId);
        PowerStats powerStatsHero = hero.getPowerStats();

        Hero opponent = this.findHeroByIdUseCase.findById(opponentId);
        PowerStats powerStatsOpponent = opponent.getPowerStats();

        int strengthDifference = powerStatsHero.getStrength() - powerStatsOpponent.getStrength();
        int agilityDifference = powerStatsHero.getAgility() - powerStatsOpponent.getAgility();
        int dexterityDifference = powerStatsHero.getDexterity() - powerStatsOpponent.getDexterity();
        int intelligenceDifference = powerStatsHero.getIntelligence() - powerStatsOpponent.getIntelligence();

        return new HeroComparePowerStats(heroId, opponentId, strengthDifference,
                agilityDifference, dexterityDifference, intelligenceDifference);
    }
}

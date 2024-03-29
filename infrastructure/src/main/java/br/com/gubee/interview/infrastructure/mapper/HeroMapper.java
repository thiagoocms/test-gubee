package br.com.gubee.interview.infrastructure.mapper;

import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.infrastructure.dto.HeroRequest;
import br.com.gubee.interview.infrastructure.repository.HeroRepository;

public class HeroMapper {

    public static Hero toHero(HeroRequest heroRequest) {
        Hero hero = new Hero();
        PowerStats powerStats = new PowerStats();

        hero.setId(heroRequest.getHeroId());
        hero.setName(heroRequest.getName());
        hero.setRace(heroRequest.getRace());

        powerStats.setAgility(heroRequest.getAgility());
        powerStats.setDexterity(heroRequest.getDexterity());
        powerStats.setIntelligence(heroRequest.getIntelligence());
        powerStats.setStrength(heroRequest.getStrength());

        hero.setPowerStats(powerStats);

        return  hero;
    }
}

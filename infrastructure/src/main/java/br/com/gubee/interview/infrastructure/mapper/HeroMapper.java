package br.com.gubee.interview.infrastructure.mapper;

import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.HeroFilter;
import br.com.gubee.interview.core.domain.PowerStats;
import br.com.gubee.interview.infrastructure.dto.HeroFilterRequest;
import br.com.gubee.interview.infrastructure.dto.HeroRequest;
import br.com.gubee.interview.infrastructure.dto.HeroResponse;
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

    public static HeroResponse toHeroResponse(Hero hero){
        HeroResponse heroResponse = new HeroResponse();

        heroResponse.setHeroId(hero.getId());
        heroResponse.setName(hero.getName());
        heroResponse.setRace(hero.getRace());

        heroResponse.setAgility(hero.getPowerStats().getAgility());
        heroResponse.setDexterity(hero.getPowerStats().getDexterity());
        heroResponse.setIntelligence(hero.getPowerStats().getIntelligence());
        heroResponse.setStrength(hero.getPowerStats().getStrength());

        return heroResponse;
    }

    public static HeroFilter toFilter(HeroFilterRequest filterRequest) {
       HeroFilter heroFilter = new HeroFilter();

       heroFilter.setName(filterRequest.getName());

       return heroFilter;
    }
}

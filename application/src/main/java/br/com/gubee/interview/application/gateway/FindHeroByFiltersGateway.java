package br.com.gubee.interview.application.gateway;

import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.HeroFilter;

import java.util.Set;

public interface FindHeroByFiltersGateway {
    Set<Hero> findFilter(HeroFilter filter);
}

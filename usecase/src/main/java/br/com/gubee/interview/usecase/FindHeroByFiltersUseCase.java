package br.com.gubee.interview.usecase;

import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.HeroFilter;

import java.util.Set;

public interface FindHeroByFiltersUseCase {
    Set<Hero> findFilter(HeroFilter filter);
}

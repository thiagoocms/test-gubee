package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.FindHeroByFiltersGateway;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.domain.HeroFilter;
import br.com.gubee.interview.usecase.FindHeroByFiltersUseCase;

import java.util.Set;

public class FindHeroByFiltersUseCaseImpl implements FindHeroByFiltersUseCase {

    private final FindHeroByFiltersGateway findHeroByFiltersGateway;

    public FindHeroByFiltersUseCaseImpl(FindHeroByFiltersGateway findHeroByFiltersGateway) {
        this.findHeroByFiltersGateway = findHeroByFiltersGateway;
    }

    @Override
    public Set<Hero> findFilter(HeroFilter filter) {
        return findHeroByFiltersGateway.findFilter(filter);
    }
}

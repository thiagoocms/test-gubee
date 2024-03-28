package br.com.gubee.interview.application.usecaseimpl;

import br.com.gubee.interview.application.gateway.FindHeroByNameGateway;
import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.usecase.FindHeroByNameUseCase;

import java.util.Set;

public class FindHeroByNameUserCaseImpl implements FindHeroByNameUseCase {

    private final FindHeroByNameGateway findHeroByNameGateway;

    public FindHeroByNameUserCaseImpl(FindHeroByNameGateway findHeroByNameGateway) {
        this.findHeroByNameGateway = findHeroByNameGateway;
    }

    @Override
    public Set<Hero> findFilterByName(String name) {
        return findHeroByNameGateway.findFilterByName(name);
    }
}

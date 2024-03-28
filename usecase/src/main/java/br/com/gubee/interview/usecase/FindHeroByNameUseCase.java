package br.com.gubee.interview.usecase;

import br.com.gubee.interview.core.domain.Hero;

import java.util.Set;

public interface FindHeroByNameUseCase {
    Set<Hero> findFilterByName(String name);
}

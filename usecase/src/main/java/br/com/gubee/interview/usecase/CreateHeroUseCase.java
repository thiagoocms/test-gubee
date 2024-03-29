package br.com.gubee.interview.usecase;

import br.com.gubee.interview.core.domain.Hero;

public interface CreateHeroUseCase {
    Hero create(Hero hero) throws Throwable;
}

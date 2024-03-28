package br.com.gubee.interview.usecase;

import br.com.gubee.interview.core.domain.Hero;

import java.util.UUID;

public interface UpdateHeroUseCase {
    Hero updateById(UUID id, Hero hero);
}

package br.com.gubee.interview.usecase;

import br.com.gubee.interview.core.domain.Hero;

import java.util.UUID;

public interface FindHeroByIdUseCase {
    Hero findById(UUID id);
}

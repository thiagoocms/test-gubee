package br.com.gubee.interview.application.validation;

import br.com.gubee.interview.core.domain.Hero;
import br.com.gubee.interview.core.exception.BadRequestException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HeroValidation {

    public void checkMandatoryFields(Hero hero) throws Throwable {

        List<String> notInformedFieldsList = new ArrayList<>();

        if (Objects.isNull(hero.getName()) || hero.getName().isEmpty()) {
            notInformedFieldsList.add("Nome");
        }
        if (Objects.isNull(hero.getRace())) {
            notInformedFieldsList.add("Raça");
        }
        if (Objects.isNull(hero.getPowerStats())) {
            notInformedFieldsList.add("habilidades");
        }

        if (!notInformedFieldsList.isEmpty()) {
            throw new BadRequestException("Campos obrigatórios não informados: " + String.join(", ", notInformedFieldsList));
        }

    }
}

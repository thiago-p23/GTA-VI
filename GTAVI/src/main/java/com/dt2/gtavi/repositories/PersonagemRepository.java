package com.dt2.gtavi.repositories;

import com.dt2.gtavi.entities.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem, Integer> {
}

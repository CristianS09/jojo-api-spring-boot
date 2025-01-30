package com.cristian.jojoapi.repository;

import com.cristian.jojoapi.model.JojoCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface que interage com o banco de dados
@org.springframework.stereotype.Repository
public interface JojoRepository extends JpaRepository<JojoCharacter, Long> {
}

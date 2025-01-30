package com.cristian.jojoapi.controller;

import com.cristian.jojoapi.model.JojoCharacter;
import com.cristian.jojoapi.repository.JojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
//Classe controller
public class Controller {

    //Instância de repository
    @Autowired
    private JojoRepository jojoRepository;

    //Método para obter todos os personagens
    @GetMapping
    public List<JojoCharacter> getCharacters(){
        return jojoRepository.findAll();
    }

    //Procura um personagem por id
    @GetMapping("/{id}")
    //Recebe o id pesquisado no parâmetro da função
    public ResponseEntity<JojoCharacter>  findById(@PathVariable Long id){
        //Optinal pois o objeto pode ser nulo
        Optional<JojoCharacter> optional = jojoRepository.findById(id);
        //Verifica se o optinal obteve algum resultado
        if (optional.isPresent()){
            //Retorna o objeto pesquisado e um status code OK
            return ResponseEntity.ok(optional.get());
        } else{
            //Retorna um erro caso o objeto não seja encontrado
            return ResponseEntity.notFound().build();
        }
    }

    //Método para inserir um personagem
    @PostMapping
    //Retorna um status code 201
    @ResponseStatus(HttpStatus.CREATED)
    public JojoCharacter addCharacter(@RequestBody JojoCharacter character){
        return jojoRepository.save(character);
    }

    //Atualiza um personagem por id
    @PutMapping("/{id}")
    //Recebe um id e um corpo no parâmetro da função
    public ResponseEntity<JojoCharacter> updateCharacter(@PathVariable Long id,@RequestBody JojoCharacter character){
        //Optinal pois o objeto pode ser nulo
        Optional<JojoCharacter> optional = jojoRepository.findById(id);
        //Verifica se o optinal obteve algum resultado
        if(optional.isPresent()){
            //Retorna o objeto pesquisado
            JojoCharacter characterResult = optional.get();
            //Atribui os novos valores do corpo da requisição ao
            // objeto pesquisado
            characterResult.setName(character.getName());
            characterResult.setDescription(character.getDescription());
            characterResult.setImageUrl(character.getImageUrl());
            //Salva o objeto com os novos dados
            jojoRepository.save(characterResult);
            return ResponseEntity.ok(characterResult);
        }else{
            //Retorna um erro caso o objeto não seja encontrado
            return ResponseEntity.notFound().build();
        }
    }

    //Delete um personagem por id
    @DeleteMapping("/{id}")
    public ResponseEntity<JojoCharacter> deleteCharacter(@PathVariable Long id){
        //Optinal pois o objeto pode ser nulo
        Optional<JojoCharacter> optional = jojoRepository.findById(id);
        //Verifica se o optinal obteve algum resultado
        if(optional.isPresent()){
            //Delete o objeto retornado
            jojoRepository.delete(optional.get());
            //Retorna um status code OK com o objeto deletado
            return ResponseEntity.ok(optional.get());
        }else{
            //Retorna um erro caso o objeto não seja encontrado
            return ResponseEntity.notFound().build();
        }
    }
}

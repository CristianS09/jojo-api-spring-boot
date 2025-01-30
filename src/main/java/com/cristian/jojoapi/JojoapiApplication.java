package com.cristian.jojoapi;

import com.cristian.jojoapi.model.JojoCharacter;
import com.cristian.jojoapi.repository.JojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class JojoapiApplication implements CommandLineRunner {

	//Instância de repository
	@Autowired
	JojoRepository jojoRepository;

	//Adiciona valores iniciais ao banco de dados
	public void initialCharacters(){
		jojoRepository.save(new JojoCharacter("Jotaro Kujo","Jotaro é um delinquente que vive uma vida normal até que o velho inimigo da Família Joestar, DIO, retorna. Jotaro viaja para o Egito para salvar sua mãe e parar o Vampiro de uma vez por todas.","https://static.wikia.nocookie.net/jjba/images/9/9a/JotaroKujo.png/revision/latest?cb=20170204224518&path-prefix=pt-br"));
		jojoRepository.save(new JojoCharacter("Dio Brando","Depois de se tornar um Vampiro e mais tarde um usuário de Stand, Dio reuniu ao seu redor muitos lacaios e é responsável por muitos eventos importantes da série.","https://static.wikia.nocookie.net/jjba/images/a/a8/DioAnimePart3.jpg/revision/latest?cb=20220713174123&path-prefix=pt-br"));
		jojoRepository.save(new JojoCharacter("Joseph Joestar","Joseph é um usuário natural do Hamon e eventual usuário do Stand, empunhando o Stand fotográfico psíquico, Hermit Purple. Joseph enfrenta as ameaças fantásticas que se aproximam dele ao longo de sua vida com iniciativa e engenhosidade impressionante.","https://static.wikia.nocookie.net/jjba/images/f/f3/Joseph_Infobox-0.jpg/revision/latest?cb=20200803153455&path-prefix=pt-br"));
		jojoRepository.save(new JojoCharacter("Jonathan Joestar","Filho de George Joestar I, Jonathan é um homem honesto, gentil e positivo, cuja vida está repleta de tragédias após conhecer seu irmão mais velho adotivo, Dio Brando. ","https://static.wikia.nocookie.net/jjba/images/7/72/Jonathan_Joestar.png/revision/latest?cb=20201204173134&path-prefix=pt-br"));

	}

	public static void main(String[] args) {
		SpringApplication.run(JojoapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initialCharacters();
	}
}

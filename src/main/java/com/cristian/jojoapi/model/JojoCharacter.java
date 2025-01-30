package com.cristian.jojoapi.model;

import jakarta.persistence.*;

//Definindo a classe como entidade
@Entity
//Nome da tabela no banco de dados
@Table(name = "jojo_table")
//Classe que representa o dado que será armazenado
public class JojoCharacter {

    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Nome do personagem
    @Column(nullable = false)
    private String name;

    //Descrição do personagem
    @Column(nullable = false)
    private String description;

    //Url da imagem do personagem
    @Column(nullable = false)
    private String imageUrl;

    //Construtor padrão
    public JojoCharacter(){};

    //Construtor completo
    public JojoCharacter(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    //Métodos Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    //Método toString para imprimir os dados do objeto no console
    @Override
    public String toString() {
        return "JojoCharacter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
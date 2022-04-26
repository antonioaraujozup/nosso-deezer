package br.com.zup.edu.nossodezeer.musica;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Entity
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer numeroDeOuvintes;

    @Column(nullable = false)
    private Integer quantidadeLikes;

    private LocalDateTime criadoEm = now();

    private LocalDateTime atualiazadoEm = now();


    public Musica(String nome) {
        this.nome = nome;
    }

    /**
     * @deprecated construtor de uso exclusivo
     */
    @Deprecated
    public Musica() {
    }


    public void aumentarOuvinte() {
        this.numeroDeOuvintes++;
    }

    public void aumentarLikes() {
        this.quantidadeLikes++;
    }
}


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

    private LocalDateTime criadoEm = now();

    private LocalDateTime atualiazadoEm = now();

    @Version
    private int versao;

    @OneToOne(mappedBy = "musica", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeOuvintesMusica numeroDeOuvintes;

    @OneToOne(mappedBy = "musica", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeLikesMusica quantidadeLikes;

    public Musica(String nome) {
        this.nome = nome;
        this.numeroDeOuvintes = new QuantidadeOuvintesMusica(this);
        this.quantidadeLikes = new QuantidadeLikesMusica(this);
    }

    /**
     * @deprecated construtor de uso exclusivo
     */
    @Deprecated
    public Musica() {
    }

    public void aumentarOuvinte() {
        this.numeroDeOuvintes.incrementa();
    }

    public void aumentarLikes() {
        this.quantidadeLikes.incrementa();
    }
}


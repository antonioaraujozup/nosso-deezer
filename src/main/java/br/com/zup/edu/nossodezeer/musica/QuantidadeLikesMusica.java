package br.com.zup.edu.nossodezeer.musica;

import javax.persistence.*;

@Entity
public class QuantidadeLikesMusica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantidade;

    @Version
    private int versao;

    @OneToOne
    private Musica musica;

    public QuantidadeLikesMusica(Musica musica) {
        this.musica = musica;
        this.quantidade = 0;
    }

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public QuantidadeLikesMusica() {
    }

    public void incrementa() {
        this.quantidade++;
    }
}

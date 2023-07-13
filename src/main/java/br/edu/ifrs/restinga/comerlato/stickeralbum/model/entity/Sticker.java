package br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;
import static java.lang.String.format;

@Getter
@Table(name = "sticker")
@Entity
@NoArgsConstructor
public class Sticker {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean extra;

    @Column(nullable = false)
    private Boolean rare;

    @Length(max = 10)
    @Column(nullable = false, length = 10)
    private String version;

    @Length(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @Column
    private LocalDate birthdate;

    @Length(max = 3)
    @Column(length = 3)
    private String team;

    @Length(max = 3)
    @Column(length = 3)
    private String position;

    @Column
    private Integer summoningYear;

    @Positive
    @Column
    private Double height;

    @Column
    private Integer weight;

    @ManyToOne(targetEntity = Album.class, fetch = EAGER, cascade = ALL)
    @JoinColumn(name = "album_id")
    private Album album;

    public Sticker(Boolean extra, Boolean rare, String version, String name) {
        this.extra = extra;
        this.rare = rare;
        this.version = version;
        this.name = name;
    }

    @Override
    public String toString() {
        final var block = """
                    Extra:              %s
                    Raro:               %s
                    Versão:             %s
                    Nome:               %s
                    Nascimento:         %s
                    Seleção:            %s
                    Posição:            %s
                    Ano convocação:     %s
                    Altura:             %s
                    Peso:               %s
                """;
        return format(block, extra, rare, version, name, birthdate, team, position, summoningYear, height, weight);
    }
}

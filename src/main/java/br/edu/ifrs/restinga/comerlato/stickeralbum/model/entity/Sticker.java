package br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;
import static java.lang.Boolean.FALSE;
import static java.lang.String.format;
import static java.util.Objects.isNull;

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
        setExtra(extra);
        setRare(rare);
        setVersion(version);
        setName(name);
    }

    public void setExtra(Boolean extra) {
        this.extra = (isNull(extra)) ? FALSE : extra;
    }

    public void setRare(Boolean rare) {
        this.rare = (isNull(rare)) ? FALSE : rare;
    }

    public void setVersion(String version) {
        if (isNull(version) || version.length() > 10) {
            throw new IllegalArgumentException("Version should have up to 10 characters.");
        }
        this.version = version;
    }

    public void setName(String name) {
        if (isNull(name) || name.length() < 3 || name.length() > 100) {
            throw new IllegalArgumentException("Name should have between 3 and 100 characters.");
        }
        this.name = name;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setTeam(String team) {
        if (team.length() > 3) {
            throw new IllegalArgumentException("Team should have up to 3 characters.");
        }
        this.team = team;
    }

    public void setPosition(String position) {
        if (position.length() > 3) {
            throw new IllegalArgumentException("Position should have up to 3 characters.");
        }
        this.position = position;
    }

    public void setSummoningYear(Integer summoningYear) {
        if (summoningYear < 1) {
            throw new IllegalArgumentException("Summoning year must be a positive number.");
        }
        this.summoningYear = summoningYear;
    }

    public void setHeight(Double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot be negative number.");
        }
        this.height = height;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setAlbum(Album album) {
        this.album = album;
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

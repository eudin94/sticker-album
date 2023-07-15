package br.edu.ifrs.restinga.comerlato.stickeralbum.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;
import static java.lang.String.format;
import static java.util.Objects.isNull;

@Getter
@Table(name = "album")
@Entity
@NoArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Length(min = 10, max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @Length(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String hostCountry;

    @Column(nullable = false)
    private Integer year;

    @ElementCollection(fetch = EAGER)
    private @NotNull @NotEmpty List<@Size(min = 3, max = 100) String> teams;

    @Length(min = 4, max = 10)
    @Column(nullable = false, length = 10)
    private String cover;

    @Column
    private Integer stickers;

    @Column
    private Integer specialStickers;

    @Column
    private Integer extraStickers;

    @OneToMany(targetEntity = Sticker.class, fetch = EAGER, mappedBy = "album", cascade = ALL)
    private List<Sticker> stickerList;

    public Album(String name, String hostCountry, Integer year, List<String> teams, String cover) {
        setName(name);
        setHostCountry(hostCountry);
        setYear(year);
        setTeams(teams);
        setCover(cover);
    }

    public void setName(String name) {
        if (isNull(name) || name.length() < 10 || name.length() > 100) {
            throw new IllegalArgumentException("Name should have between 10 and 100 characters.");
        }
        this.name = name;
    }

    public void setHostCountry(String hostCountry) {
        if (isNull(hostCountry) || hostCountry.length() < 3 || hostCountry.length() > 100) {
            throw new IllegalArgumentException("Host country should have between 3 and 100 characters.");
        }
        this.hostCountry = hostCountry;
    }

    public void setYear(Integer year) {
        if (isNull(year) || year < 1) {
            throw new IllegalArgumentException("Year must be a positive number.");
        }
        this.year = year;
    }

    public void setTeams(List<String> teams) {
        if (isNull(teams) || teams.isEmpty() || teams.stream().anyMatch(s -> s.length() < 3 || s.length() > 100)) {
            throw new IllegalArgumentException("Teams should have between 3 and 100 characters.");
        }
        this.teams = teams;
    }

    public void setCover(String cover) {
        if (isNull(cover) || cover.length() < 4 || cover.length() > 10) {
            throw new IllegalArgumentException("Cover should have between 4 and 10 characters.");
        }
        this.cover = cover;
    }

    public void setStickers(Integer stickers) {
        this.stickers = stickers;
    }

    public void setSpecialStickers(Integer specialStickers) {
        this.specialStickers = specialStickers;
    }

    public void setExtraStickers(Integer extraStickers) {
        this.extraStickers = extraStickers;
    }

    public void setStickerList(List<Sticker> stickerList) {
        this.stickerList = stickerList;
    }

    @Override
    public String toString() {
        final var block = """
                    Nome:               %s
                    País sede:          %s
                    Ano:                %s
                    Seleções:           %s
                    Capa:               %s
                    Cromos:             %s
                    Cromos especiais:   %s
                    Cromos extras:      %s
                """;
        return format(block, name, hostCountry, year, teams, cover, stickers, specialStickers, extraStickers);
    }


}

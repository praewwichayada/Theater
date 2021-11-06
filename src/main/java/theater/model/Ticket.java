package theater.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    private UUID movieID;
    private UUID cinemaID;
    private String email;
    private String seat;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getMovieID() {
        return movieID;
    }

    public void setMovieID(UUID movieID) {
        this.movieID = movieID;
    }

    public UUID getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(UUID cinemaID) {
        this.cinemaID = cinemaID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}

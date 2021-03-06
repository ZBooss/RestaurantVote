package ru.topjava.voting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "dishes", uniqueConstraints = {@UniqueConstraint(columnNames = "id", name = "dishes_unique_idx")})
public class Dish extends AbstractNamedEntity {

    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    @NotNull
    private Restaurant rest;

    @Column(name = "price", nullable = false)
    @Range(min = 1000, max = 1000000)
    private Integer price;

    public Dish() {
    }

    public Dish(Integer id, String name, LocalDate date, Restaurant rest) {
        super(id, name);
        this.date = date;
        this.rest = rest;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Restaurant getRest() {
        return rest;
    }

    public void setRest(Restaurant rest) {
        this.rest = rest;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", rest=" + rest +
                ", price=" + price +
                '}';
    }
}

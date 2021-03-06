package ru.topjava.voting.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = "id", name = "rests_unique_idx")})
public class Restaurant extends AbstractNamedEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rest")
    @OrderBy("date DESC")
    private List<Dish> dishes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rest")
    @OrderBy("date DESC")
    private List<Vote> votes;

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public Restaurant() {
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

}

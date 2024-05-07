package it.epicode.entities;

import it.epicode.entities.constants.Tables;

import jakarta.persistence.*;

@Entity
@Table(name = Tables.Names.USER)
public class User extends BaseEntity{
    private String name;
    private String last_name;

    @OneToOne(mappedBy = "user")
    private Card card;

    public User(String name, String last_name) {
        this.name = name;
        this.last_name = last_name;
        this.card = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "User{" + "Id:"+ getId() + " Created At:" + getInsertedAt() + "name:'" + name + '\'' + ", last_name:'" + last_name + '\'' + ", card:" + card + '}';
    }
}

package com.betaplan.tvshows_belt_exam.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "avgRating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float rate;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User raties;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="show_id")
    private Show show;

    public Rating() {
    }

    public Rating(User raties, Show show) {
        this.raties = raties;
        this.show = show;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getRaties() {
        return raties;
    }

    public void setRaties(User raties) {
        this.raties = raties;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}

package com.seankang.persistence.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer maxBudget;

    @Column(nullable = false)
    private Date lastBidDate;

    public Project() {
        super();
    }

    public Project(String descr, Integer budget) {
        super();
        this.description = descr;
        this.maxBudget = budget;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String newdesc) {
        this.description = newdesc;
    }

    public Integer getMaxBudget() {
        return maxBudget;
    }

    public void setMaxBudget(Integer newbudget) {
        this.maxBudget = newbudget;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maxBudget == null) ? 0 : maxBudget.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Project other = (Project) obj;
        if (maxBudget == null) {
            if (other.maxBudget != null)
                return false;
        } else if (!maxBudget.equals(other.maxBudget))
            return false;
        if (id != other.id)
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Project [id=" + id + ", description=" + description + ", maxBudget=" + maxBudget + "]";
    }

    public Date getLastBidDate() {
        return lastBidDate;
    }

    public void setLastBidDate(Date lastBidDate) {
        this.lastBidDate = lastBidDate;
    }
}

package com.cross.model.dish;


import java.io.Serializable;

/**
 * A DTO for the SelfDishDetails entity.
 */
public class SelfDishDetails implements Serializable {

    private Long id;

    private Long dishId;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelfDishDetails that = (SelfDishDetails) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SelfDishDetailsDTO{" +
            "id=" + getId() +
            ", dishId=" + getDishId() +
            ", content='" + getContent() + "'" +
            "}";
    }
}

package com.cross.model;


import com.cross.model.dish.ShopDish;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the HomeDishCat entity.
 */
public class HomeDishCatModel implements Serializable {

    private Long id;

    private String catName;

    private Integer sort;

    private Long platFormId;

    private List<String> DishIdList;

    private List<ShopDish> dishList;

    private List<HomeImageUrlModel> imageUrlList;

    public List<HomeImageUrlModel> getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(List<HomeImageUrlModel> imageUrlList) {
        this.imageUrlList = imageUrlList;
    }

    public List<ShopDish> getDishList() {
        return dishList;
    }

    public void setDishList(List<ShopDish> dishList) {
        this.dishList = dishList;
    }

    public List<String> getDishIdList() {
        return DishIdList;
    }

    public void setDishIdList(List<String> dishIdList) {
        DishIdList = dishIdList;
    }

    public Long getPlatFormId() {
        return platFormId;
    }

    public void setPlatFormId(Long platFormId) {
        this.platFormId = platFormId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HomeDishCatModel that = (HomeDishCatModel) o;

        if (!id.equals(that.id)) return false;
        return platFormId != null ? platFormId.equals(that.platFormId) : that.platFormId == null;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "HomeDishCatDTO{" +
            "id=" + getId() +
            ", catName='" + getCatName() + "'" +
            ", sort=" + getSort() +
            "}";
    }
}

package com.cross.model;

public class PackageInfoVM {
    /**
     * 套餐名称
     */
    private String PackageName;
    /**
     * 菜品名称
     */
    private String dishName;
    /**
     * 菜品id
     */
    private Long dishId;

    public String getPackageName() {
        return PackageName;
    }

    public void setPackageName(String packageName) {
        PackageName = packageName;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }
}

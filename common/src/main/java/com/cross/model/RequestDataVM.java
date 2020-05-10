package com.cross.model;

public class RequestDataVM {
    private String text;

    private String type;

    private Integer paddind;

    private Boolean linenums;

    private Boolean highlight;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPaddind() {
        return paddind;
    }

    public void setPaddind(Integer paddind) {
        this.paddind = paddind;
    }

    public Boolean getLinenums() {
        return linenums;
    }

    public void setLinenums(Boolean linenums) {
        this.linenums = linenums;
    }

    public Boolean getHighlight() {
        return highlight;
    }

    public void setHighlight(Boolean highlight) {
        this.highlight = highlight;
    }
}

package main.dto;

import java.util.Date;

public class NeuterDto {

    private int id;
    private String name;
    private Long createDate;

    public NeuterDto() {
    }

    public NeuterDto(String name, Long createDate) {
        this.name = name;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }
}

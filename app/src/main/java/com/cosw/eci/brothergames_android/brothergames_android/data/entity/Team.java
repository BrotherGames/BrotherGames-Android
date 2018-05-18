package com.cosw.eci.brothergames_android.brothergames_android.data.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author Santiago Carrillo
 */

//TODO add database annotations and proper model structure
@DatabaseTable
public class Team  extends BaseEntity {
    @DatabaseField(columnName = "name")
    private String name;
    @DatabaseField(columnName = "description")
    private String description;
    @DatabaseField(columnName = "photo")
    private String photo;
    @DatabaseField(columnName = "rateAcum")
    private String rate;
    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String imageUrl) {
        this.photo = photo;
    }

    public String getRate() { return rate; }

    public void setRate(String rate) { this.rate = rate; }
}

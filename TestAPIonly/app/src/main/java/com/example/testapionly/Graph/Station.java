package com.example.testapionly.Graph;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Station implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    private final static long serialVersionUID = 2515921688977238402L;

    public String getStationName() {
        return name;
    }
    public void setStationName(String name) {
        this.name = name;
    }

}

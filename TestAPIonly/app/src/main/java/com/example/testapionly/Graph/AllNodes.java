package com.example.testapionly.Graph;

import java.io.Serializable;
import java.util.ArrayList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllNodes implements Serializable {

    @SerializedName("allNodes")
    @Expose
    private ArrayList<Station> allNodes = null;
    private final static long serialVersionUID = 2201606446242142124L;

    public ArrayList<Station> getAllNodes() {
        return allNodes;
    }

    public void setAllNodes(ArrayList<Station> allNodes) {
        this.allNodes = allNodes;
    }

}

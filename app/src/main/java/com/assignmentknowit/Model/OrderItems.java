package com.assignmentknowit.Model;

import org.json.JSONObject;

public class OrderItems {
    private String name;
    private JSONObject media;

    public OrderItems(String name, JSONObject media) {
        this.name = name;
        this.media = media;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    private String imageurl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public JSONObject getMedia() {
        return media;
    }

    public void setMedia(JSONObject media) {
        this.media = media;
    }
}

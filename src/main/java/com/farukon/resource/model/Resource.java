package com.farukon.resource.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;

import java.util.*;

public class Resource {
    @Id private String id;
    private String url;
    private Map<String, String> meta;
    private List<String> images;
    @TextIndexed private String title;
    @TextIndexed private String summary;

    public Resource() {
        this.images = new ArrayList();
    }

    public Resource(String url) {
        this.url = url;
        this.images = new ArrayList();
        this.meta = new HashMap<>();
    }

    public Resource(String id, String url, String title, String summary, List<String> images) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.summary = summary;
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getMeta() {
        return Collections.unmodifiableMap(meta);
    }

    public void setMeta(Map<String, String> meta) {
        this.meta = meta;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImages() {
        return Collections.unmodifiableList(images);
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", images=" + images +
                '}';
    }
}

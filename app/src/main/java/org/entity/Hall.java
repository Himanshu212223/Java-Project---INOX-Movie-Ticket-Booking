package org.entity;

public class Hall {

    private String id;
    private String name;
    private String location;
    private String studio;
    private Integer maxSeat;
    private String movieName;

    public String getMovieName() {
        return movieName;
    }

    public Integer getMaxSeat() {
        return maxSeat;
    }

    public String getStudio() {
        return studio;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setMaxSeat(Integer maxSeat) {
        this.maxSeat = maxSeat;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

//    public String getHall() {
//        return "id : " + this.id + ", location : " + this.location + ", name : " + this.name + ", studio" + this.studio + ", maxSeat" + this.maxSeat + ", movieName" + this.movieName;
//    }
}
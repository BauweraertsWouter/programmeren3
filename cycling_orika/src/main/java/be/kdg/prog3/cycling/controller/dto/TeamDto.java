package be.kdg.prog3.cycling.controller.dto;

import java.util.List;

public class TeamDto {
    private String name;
    private String uciCode;
    private short founded;
    private List<RiderDto> riders;

    public TeamDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUciCode() {
        return uciCode;
    }

    public void setUciCode(String uciCode) {
        this.uciCode = uciCode;
    }

    public short getFounded() {
        return founded;
    }

    public void setFounded(short founded) {
        this.founded = founded;
    }

    public List<RiderDto> getRiders() {
        return riders;
    }

    public void setRiders(List<RiderDto> riders) {
        this.riders = riders;
    }
}

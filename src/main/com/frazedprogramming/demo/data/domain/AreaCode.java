package com.frazedprogramming.demo.data.domain;

/**
 * Created by Santosh on 1/20/2017.
 */
public class AreaCode {


    private Integer areaCode;
    private String state_code;
    private String city_name;


    public AreaCode() {
        super();
    }

    public AreaCode(Integer areaCode, String state_code, String city_name) {
        this.areaCode = areaCode;
        this.state_code = state_code;
        this.city_name = city_name;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }


    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AreaCode areaCodes = (AreaCode) o;

        if (areaCode != null ? !areaCode.equals(areaCodes.areaCode) : areaCodes.areaCode != null) return false;
        return (state_code != null ? state_code.equals(areaCodes.state_code) : areaCodes.state_code == null) && (city_name != null ? city_name.equals(areaCodes.city_name) : areaCodes.city_name == null);
    }

    @Override
    public int hashCode() {
        int result = areaCode != null ? areaCode.hashCode() : 0;
        result = 31 * result + (state_code != null ? state_code.hashCode() : 0);
        result = 31 * result + (city_name != null ? city_name.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "AreaCode{" +
                "areaCode=" + areaCode +
                ", state_code='" + state_code + '\'' +
                ", city_name='" + city_name + '\'' +
                '}';
    }
}

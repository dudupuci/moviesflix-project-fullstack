package com.moviesflix.watch.constant;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum ParentalRatingEnum {

   ALL(0), KIDS(10), ADOLESCENT(14), YOUNG_PEOPLE(16), ADULTS(18);

    private Integer age;
    public static final Map<Integer, ParentalRatingEnum> mapList = new HashMap<>();

    static {
        for (ParentalRatingEnum x : ParentalRatingEnum.values()) {
            mapList.put(x.getAge(), x);

        }
    }

    ParentalRatingEnum(Integer age){
        this.age = age;
    }

    public static ParentalRatingEnum getAge(Integer age) {
        return mapList.get(age);

    }





}

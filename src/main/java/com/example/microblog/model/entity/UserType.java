package com.example.microblog.model.entity;

import lombok.Getter;

@Getter
public enum UserType {

    REGULAR_BLOGER(1),
    PRIVILEGED_BLOGER(2);


    private Integer id;

    UserType(Integer id) {
        this.id = id;
    }

    public static UserType getById(Integer id) {
        if (id == null) {
            return null;
        }

        for (UserType userType : UserType.values()) {
            if (userType.getId().equals(id)) {
                return userType;
            }
        }

        return null;
    }

}

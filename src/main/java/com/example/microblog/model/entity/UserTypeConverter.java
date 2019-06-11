package com.example.microblog.model.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserTypeConverter implements AttributeConverter<UserType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserType userType) {
        return userType == null ? null : userType.getId();
    }

    @Override
    public UserType convertToEntityAttribute(Integer integer) {
        return UserType.getById(integer);
    }
}

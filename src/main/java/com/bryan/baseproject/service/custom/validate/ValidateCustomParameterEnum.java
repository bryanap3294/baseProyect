package com.bryan.baseproject.service.custom.validate;

public enum ValidateCustomParameterEnum {

    ID(ValidateParameterEnum.ID, true),
    MODULE(ValidateParameterEnum.MODULE, true),
    LABEL(ValidateParameterEnum.LABEL, false),
    VALUE1(ValidateParameterEnum.VALUE1, true);

    private final ValidateParameterEnum validateParameterEnum;
    private final Boolean required;

    ValidateCustomParameterEnum(ValidateParameterEnum validateParameterEnum, Boolean required){
        this.validateParameterEnum = validateParameterEnum;
        this.required = required;
    }

}

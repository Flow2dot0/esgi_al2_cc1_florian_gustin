package com.amazen.core.value_objects;

import com.amazen.core.validators.IdValidator;
import com.amazen.core.interfaces.DateEngine;
import com.amazen.core.validators.*;

public final class ValueObjectFactory{
    private ValueObjectFactory() {
        throw new AssertionError();
    }

    public static ValueObjectAbstract<String> withEmailValidator(String value) {
        return new EmailValueObject(EmailValidator.INSTANCE, value);
    }

    public static ValueObjectAbstract<String> withCompanyValidator(String value) {
        return new CompanyValueObject(CompanyValidator.INSTANCE, value);
    }

    public static ValueObjectAbstract<Integer> withZipcodeValidator(int value) {
        return new ZipcodeValueObject(ZipcodeValidator.INSTANCE, value);
    }

    public static ValueObjectAbstract<String> withCityValidator(String value) {
        return new CityValueObject(CityValidator.INSTANCE, value);
    }

    public static ValueObjectAbstract<String> withCountryValidator(String value) {
        return new CountryValueObject(CountryValidator.INSTANCE, value);
    }

    public static ValueObjectAbstract<String> withSiretValidator(String value) {
        return new SiretValueObject(SiretValidator.INSTANCE, value);
    }

    public static ValueObjectAbstract<String> withAddressValidator(String value) {
        return new AddressValueObject(AddressValidator.INSTANCE, value);
    }

    public static ValueObjectAbstract<String> withFirstnameValidator(String value) {
        return new FirstnameValueObject(FirstnameValidator.INSTANCE, value);
    }

    public static ValueObjectAbstract<Integer> withIdValidator(int value) {
        return new IdValueObject(IdValidator.INSTANCE, value);
    }

    public static ValueObjectAbstract<String> withLastnameValidator(String value) {
        return new LastnameValueObject(LastnameValidator.INSTANCE, value);
    }

    public static ValueObjectAbstract<Long> withCardNumberValidator(long value) {
        return new CardNumberValueObject(CardNumberValidator.INSTANCE, value);
    }

    public static ValueObjectAbstract<Integer> withCardSecurityCodeValidator(int value) {
        return new CardSecurityCodeValueObject(CardSecurityCodeValidator.INSTANCE, value);
    }

    public static ValueObjectAbstract<DateEngine> withCardExpirationDateValidator(DateEngine value) {
        return new CardExpirationDateValueObject(CardExpirationDateValidator.INSTANCE, value);
    }

    public static ValueObjectAbstract<String> withPasswordValidator(String value) {
        return new PasswordValueObject(PasswordValidator.INSTANCE, value);
    }
}

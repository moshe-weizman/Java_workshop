package com.example.myapplication.model;

public class Parcel {
    private ParcelType _type;
    private boolean _fragile;
    private WeightParcel _weight;
    private String _location;
    private String _phone;
    private Person _person;

    //-------------------------------------------------------
    public Parcel() {}

    public Parcel(ParcelType type, boolean fragile, WeightParcel weight, String location, Person person) {
        this._type = type;
        this._fragile = fragile;
        this._weight = weight;
        this._location = location;
        this._phone = person.get_phone();
        this._person = person;
    }
//-------------------------------------------------------------------
    public ParcelType get_type() {
        return _type;
    }

    public void set_type(ParcelType _type) {
        this._type = _type;
    }

    public boolean is_fragile() {
        return _fragile;
    }

    public void set_fragile(boolean _fragile) {
        this._fragile = _fragile;
    }

    public WeightParcel get_weight() {
        return _weight;
    }

    public void set_weight(WeightParcel _weight) {
        this._weight = _weight;
    }

    public String get_location() {
        return _location;
    }

    public void set_location(String _location) {
        this._location = _location;
    }

    public String get_phone() {
        return _phone;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }

    public Person get_person() {
        return _person;
    }

    public void set_person(Person _person) {
        this._person = _person;
    }
}

package com.example.myapplication.model;

public class Parcel {
    public enum ParcelType {
        ENVELOPE, SMALL_PARCEL, BIG_PARCEL
    }
    public enum WeightParcel {
        UP_TO_500G, UP_TO_1KG, UP_TO_5KG, UP_TO_20KG
    }

    private ParcelType _type;
    private boolean _fragile;
    private WeightParcel _weight;
    private String _phone;
    private Person _person;
    private String _parcelID;
    private String _locationOfStorage;

    //-------------------------------------------------------
    public Parcel() {}

    public Parcel(ParcelType type, boolean fragile, WeightParcel weight, Person person, String parcelID,  String locationOfStorage) {
        this._type = type;
        this._fragile = fragile;
        this._weight = weight;
        this._phone = person.get_phone();
        this._person = person;
        this._parcelID=parcelID;
        this._locationOfStorage=locationOfStorage;
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

    public String get_parcelID() {
        return _parcelID;
    }

    public void set_parcelID(String _parcelID) {
        this._parcelID = _parcelID;
    }

    public String get_locationOfStorage() {
        return _locationOfStorage;
    }

    public void set_locationOfStorage(String _locationOfStorage) {
        this._locationOfStorage = _locationOfStorage;
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

package com.example.myapplication.model;

public class Parcel {
    public enum ParcelType {
        ENVELOPE, SMALL_PARCEL, BIG_PARCEL
    }
    public enum ParcelWeight {
        UP_TO_500G, UP_TO_1KG, UP_TO_5KG, UP_TO_20KG
    }

    private ParcelType _type;
    private boolean _fragile;
    private ParcelWeight _weight;
    private String _phone;
    private Person _person;
    private String _parcelID;
    private String _locationOfStorage;

    //-------------------------------------------------------
    public Parcel() {}

    public Parcel(ParcelType type, boolean fragile, ParcelWeight weight, Person person, String parcelID, String locationOfStorage) {
        _type = type;
        _fragile = fragile;
        _weight = weight;
        _phone = person.get_phone();
        _person = person;
        _parcelID = parcelID;
        _locationOfStorage = locationOfStorage;
    }
//-------------------------------------------------------------------


    public ParcelType getType() {
        return _type;
    }

    public boolean isFragile() {
        return _fragile;
    }

    public ParcelWeight getWeight() {
        return _weight;
    }

    public String getPhone() {
        return _phone;
    }

    public Person getPerson() {
        return _person;
    }

    public String getParcelID() {
        return _parcelID;
    }

    public String getLocationOfStorage() {
        return _locationOfStorage;
    }
//---------------------------------------------------------------------

    public void setType(ParcelType type) {
        _type = type;
    }

    public void setFragile(boolean fragile) {
        _fragile = fragile;
    }

    public void setWeight(ParcelWeight weight) {
        _weight = weight;
    }

    public void setPhone(String phone) {
        _phone = phone;
    }

    public void setPerson(Person person) {
        _person = person;
        _phone = person.get_phone();
    }

    public void setLocationOfStorage(String locationOfStorage) {
        _locationOfStorage = locationOfStorage;
    }
}

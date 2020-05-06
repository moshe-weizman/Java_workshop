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
    private String _parcelID;
    private String _locationOfStorage;
    private String _firstName;
    private String _lastName;
    private String _recipientAddress;

    //-------------------------------------------------------
    public Parcel() {
    }

    public Parcel(String phone, String firstName, String lastName, String recipientAddress,
                  ParcelType type, boolean fragile, ParcelWeight weight, String parcelID,
                  String locationOfStorage) {
        _type = type;
        _fragile = fragile;
        _weight = weight;
        _phone = phone;
        _parcelID = parcelID;
        _locationOfStorage = locationOfStorage;
        this._firstName = firstName;
        this._lastName = lastName;
        this._recipientAddress = recipientAddress;
    }
//-------------------------------------------------------------------

    public String get_firstName() {
        return _firstName;
    }

    public void set_firstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String get_lastName() {
        return _lastName;
    }

    public void set_lastName(String _lastName) {
        this._lastName = _lastName;
    }

    public String get_recipientAddress() {
        return _recipientAddress;
    }

    public void set_recipientAddress(String _recipientAddress) {
        this._recipientAddress = _recipientAddress;
    }


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

    public void setLocationOfStorage(String locationOfStorage) {
        _locationOfStorage = locationOfStorage;
    }
}

/*
Java Workshop 2020
First Application
06/05/2020
Moshe Weizman 305343931
Aharon Packter 201530508
 */
package com.example.myapplication.model;

/**
 * represents a package sent to a receiver including relevant information
 */
public class Parcel {

    /**
     * Optional types of parcel sent by the network
     */
    public enum ParcelType {
        ENVELOPE, SMALL_PARCEL, BIG_PARCEL
    }

    /**
     * Optional weight of the package
     */
    public enum ParcelWeight {
        UP_TO_500G, UP_TO_1KG, UP_TO_5KG, UP_TO_20KG
    }

    private ParcelType _type;
    private boolean _fragile;
    private ParcelWeight _weight;
    private String _locationOfStorage;
    private String _parcelID;


    //private String _delivers;
    private String _recipientPhone;
    private String _recipientFirstName;
    private String _recipientLastName;
    private String _recipientAddress;

    //---------------------------------------Constructors------------------------------------------
    public Parcel() {
    }

    /**
     * @param recipientPhone     recipient's phone
     * @param recipientFirstName recipient's first name
     * @param recipientLastName  recipient's last name
     * @param recipientAddress   recipient's address
     * @param type               parcel type
     * @param fragile            is the parcel fragile
     * @param weight             maximum weight
     * @param parcelID           the serial number of the parcel on the database
     * @param locationOfStorage  the location the parcel is stored
     */
    public Parcel(String recipientPhone, String recipientFirstName, String recipientLastName, String recipientAddress,
                  ParcelType type, boolean fragile, ParcelWeight weight, String parcelID,
                  String locationOfStorage) {
        _type = type;
        _fragile = fragile;
        _weight = weight;
        _recipientPhone = recipientPhone;
        _parcelID = parcelID;
        _locationOfStorage = locationOfStorage;
        _recipientFirstName = recipientFirstName;
        _recipientLastName = recipientLastName;
        _recipientAddress = recipientAddress;
    }
//------------------------------Getters------------------------------------------

    public String getRecipientFirstName() {
        return _recipientFirstName;
    }

    public String getRecipientLastName() {
        return _recipientLastName;
    }

    public String getRecipientAddress() {
        return _recipientAddress;
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

    public String getRecipientPhone() {
        return _recipientPhone;
    }

    public String getParcelID() {
        return _parcelID;
    }

    public String getLocationOfStorage() {
        return _locationOfStorage;
    }

//    public String get_delivers() {
//        return _delivers;
//    }
//-------------------------------Setters--------------------------------------

//    public void set_delivers(String _delivers) {
//        this._delivers = _delivers;
//    }

    public void setRecipientAddress(String recipientAddress) {
        _recipientAddress = recipientAddress;
    }

    public void setRecipientFirstName(String recipientFirstName) {
        _recipientFirstName = recipientFirstName;
    }

    public void setRecipientLastName(String recipientLastName) {
        _recipientLastName = recipientLastName;
    }

    public void setType(ParcelType type) {
        _type = type;
    }

    public void setFragile(boolean fragile) {
        _fragile = fragile;
    }

    public void setWeight(ParcelWeight weight) {
        _weight = weight;
    }

    public void setRecipientPhone(String recipientPhone) {
        _recipientPhone = recipientPhone;
    }

    public void setLocationOfStorage(String locationOfStorage) {
        _locationOfStorage = locationOfStorage;
    }
}

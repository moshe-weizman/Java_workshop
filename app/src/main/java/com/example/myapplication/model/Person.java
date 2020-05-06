/*
Java Workshop 2020
First Application
06/05/2020
Moshe Weizman 305343931
Aharon Packter 201530508
 */
package com.example.myapplication.model;

public class Person {
    private String _firstName;
    private String _lastName;
    private String _address;
    private String _phone;
    private String _email;

//---------------------------------------------------
    public Person(String firstName, String lastName , String address, String phone, String email) {
        this._firstName = firstName;
        this._lastName= lastName;
        this._address=address;
        this._phone= phone;
        this._email=email;
    }

    public Person() {}

    //----------------------------------------------------------
    public String get_lastName() {
        return _lastName;
    }

    public void set_lastName(String _lastName) {
        this._lastName = _lastName;
    }
    public String get_firstName() {
        return _firstName;
    }

    public void set_firstName(String _firstName) {
        this._firstName = _firstName;
    }
    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }
    public String get_phone() {
        return _phone;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

}

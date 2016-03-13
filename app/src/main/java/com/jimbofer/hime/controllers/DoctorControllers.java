package com.jimbofer.hime.controllers;

import com.jimbofer.hime.model.items;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christian on 3/13/2016.
 */
public class DoctorControllers {

    private List<items> Item = new ArrayList<>();

    public DoctorControllers() {
        Item.add( new items("View Appointment Request"));
        Item.add(new items("View Patients"));
//        Item.add(new items("Accept referral request"));
        Item.add(new items("Log out"));
    }

    public List<items> getItem() {
        return Item;
    }

    public void setItem(List<items> item) {
        Item = item;
    }

}

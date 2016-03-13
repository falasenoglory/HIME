package com.jimbofer.hime.controllers;

import com.jimbofer.hime.models.items;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shanyl Jimenez on 3/12/2016.
 */
public class InsuranceAdminControllers {

    private List<items> Item = new ArrayList<>();

    public InsuranceAdminControllers() {
        Item.add( new items("View Hospitals"));
        Item.add(new items("View Patients"));
        Item.add(new items("View Doctors"));
        Item.add(new items("Log out"));
    }

    public List<items> getItem() {
        return Item;
    }

    public void setItem(List<items> item) {
        Item = item;
    }
}

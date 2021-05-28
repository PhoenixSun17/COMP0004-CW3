package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;

public class Search {
    List<patient> patients;
    String searchText;

    public Search(List<patient> patients, String searchText){
        this.patients = patients;
        this.searchText = searchText;
    }
    /*
        id, birthdate, deathdate, ssn, drivers, passport,
        prefix, first, last, suffix, maiden,
        marital, race, ethnicity, gender,
        birthplace, address, city, state, zip */

    public List<patient> selectField(String field){
        List<patient> list = new ArrayList<>();
        switch (field){
            case "id": list = idList();
                break;
            case "birthdate": list = birthdateList();
                break;
            case "deathdate": list = deathdateList();
                break;
            case "ssn": list = ssnList();
                break;
            case "driver": list = driverList();
                break;
            case "passport": list = passportList();
                break;
            case "first": list = firstList();
                break;
            case "last": list = lastList();
                break;
            case "marital": list = maritalList();
                break;
            case "race": list = raceList();
                break;
            case "ethnicity": list = ethnicityList();
                break;
            case "gender": list = genderList();
                break;
            case "birthplace": list = birthplaceList();
                break;
            case "address": list = addressList();
                break;
            case "city": list = cityList();
                break;
            case "state": list = stateList();
                break;
            case "zip": list = zipList();
                break;
            case "prefix": list = prefixList();
                break;
            case "suffix": list = suffixList();
                break;
            case "maiden": list = maidenList();
                break;

            default: System.out.println("choose a field");
        }

        return list;
    }

    public List<patient> selectField(String field, String type){
        List<patient> list = new ArrayList<>();
        list = idList(type);
        return list;
    }

    private List<patient> idList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getId().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> idList(String type){
        List<patient> list = new ArrayList<>();
        List<patient> list2 = new ArrayList<>();
        for (patient p : patients) {
            if (p.getGender().contains(type)) {
                list.add(p);
            }
        }
        for (patient p : list) {
            if (p.getId().contains(searchText)) {
                list2.add(p);
            }
        }
        return list2;
    }

    private List<patient> birthdateList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getBirthdate().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> deathdateList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getDeathdate().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> ssnList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getSsn().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> driverList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getDrivers().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> passportList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getPassport().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> firstList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getFirst().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> lastList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getLast().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> maritalList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getMarital().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> raceList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getRace().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> ethnicityList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getEthnicity().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> genderList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getGender().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> birthplaceList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getBirthplace().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> addressList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getAddress().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> cityList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getCity().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> stateList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getState().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> zipList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getZip().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }

    private List<patient> prefixList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getPrefix().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }
    private List<patient> suffixList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getSuffix().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }
    private List<patient> maidenList(){
        List<patient> list = new ArrayList<>();
        for (patient p : patients) {
            if (p.getMaiden().contains(searchText)) {
                list.add(p);
            }
        }
        return list;
    }
}

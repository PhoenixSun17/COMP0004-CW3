package uk.ac.ucl.model;

public class patient {
    private String id, birthD, deathD, ssn, drivers;
    private String passport, prefix, first, last, suffix;
    private String maiden, marital, race, ethnicity, gender;
    private String birthplace, address, city, state, zip;

    public patient(String id, String birthdate, String deathdate, String ssn, String drivers, String passport,
                   String prefix, String first, String last, String suffix, String maiden,
                   String marital, String race, String ethnicity, String gender,
                   String birthplace, String address, String city, String state, String zip){
        this.id = id;
        this.birthD = birthdate;
        this.deathD = deathdate;
        this.ssn = ssn;
        this.drivers = drivers;
        this.passport = passport;
        this.prefix = prefix;
        this.first = first;
        this.last = last;
        this.suffix = suffix;
        this.maiden = maiden;
        this.marital = marital;
        this.race = race;
        this.ethnicity = ethnicity;
        this.gender = gender;
        this.birthplace = birthplace;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public patient(String value, String type){
        switch (type){
            case "URL":
                this.gender = "URL";
            case "Image":
                this.gender = "Image";
            case "Text":
                this.gender = "Text";
            default:
                this.gender = type;
                //System.out.println("The type of data is "+type);
        }
        this.id = value;
        this.birthD = null;
        this.deathD = null;
        this.ssn =null;
        this.drivers = null;
        this.passport = null;
        this.prefix = null;
        this.first = null;
        this.last = null;
        this.suffix = null;
        this.maiden = null;
        this.marital =null;
        this.race = null;
        this.ethnicity = null;
        this.birthplace = null;
        this.address = null;
        this.city = null;
        this.state = null;
        this.zip = null;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthdate() {
        return birthD;
    }

    public void setBirthdate(String birthdate) {
        this.birthD = birthdate;
    }

    public String getDeathdate() {
        return deathD;
    }

    public void setDeathdate(String deathdate) {
        this.deathD = deathdate;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getDrivers() {
        return drivers;
    }

    public void setDrivers(String drivers) {
        this.drivers = drivers;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getMaiden() {
        return maiden;
    }

    public void setMaiden(String maiden) {
        this.maiden = maiden;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    /* for test only -- not JSON */
    @Override
    public String toString() {
        return first + " " + last;
    }
}
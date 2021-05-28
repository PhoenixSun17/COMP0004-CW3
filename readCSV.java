package uk.ac.ucl.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class readCSV {
    private patient createPatient(String[] data) {
        // the method if for making a new Patient Object

        String id = data[0];
        String birthdate = data[1];
        String deathdate = data[2];
        String ssn = data[3];
        String drivers = data[4];
        String passport = data[5];
        String prefix = data[6];
        String first = data[7];
        String last = data[8];
        String suffix = data[9];
        String maiden = data[10];
        String marital = data[11];
        String race = data[12];
        String ethnicity = data[13];
        String gender = data[14];
        String birthplace = data[15];
        String address = data[16];
        String city = data[17];
        String state = data[18];
        String zip = data[19];

        return new patient(id, birthdate, deathdate, ssn, drivers, passport,
                prefix, first, last, suffix, maiden,
                marital, race, ethnicity, gender,
                birthplace, address, city, state, zip);
    }

    public patient newPatient(String[] info){
        String s1 = info[0];
        String s2 = info[1];
        String s3 = info[2];
        String s4 = info[3];
        String s5 = info[4];
        String s6 = info[5];
        String s7 = info[6];
        String s8 = info[7];
        String s9 = info[8];
        String s10 = info[9];
        String s11 = info[10];
        String s12 = info[11];
        String s13 = info[12];
        String s14 = info[13];
        String s15 = info[14];
        String s16 = info[15];
        String s17 = info[16];
        String s18 = info[17];
        String s19 = info[18];
        String s20 = info[19];
        return new patient(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20);
    }

    public ArrayList<patient> createPatientList(String path) {
        ArrayList<patient> patients = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader(path))) {
            String line = buffer.readLine();
            while (line != null) {
                String[] contents = line.split(",", 21); // avoid emety string at the end
                patient one = createPatient(contents);
                patients.add(one);
                line = buffer.readLine();
            }
        } catch (IOException e) {
            return null;
        }
        return patients;
    }

}

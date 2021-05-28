package uk.ac.ucl.model;

import java.util.ArrayList;

public class DataFrame {
    private ArrayList<patient> patientList;
    private ArrayList<ArrayList<patient>> listOlist;
    private String listname;
    private ArrayList<String> nameList;

    public DataFrame(String name) {
        patientList = new ArrayList<patient>();
        listOlist = null;
        listname = name;
        nameList = null;
    }

    public DataFrame(String name, DataFrame data){
        nameList = new ArrayList<String>();
        listOlist = new ArrayList<ArrayList<patient>>();
        if (data.isListOlist()) {
            int i=0;
            for (ArrayList<patient> plist : data.getPatientLists()) {
                listOlist.add(plist);
                this.nameList.add(data.getNameList().get(i));
                i++;
            }
        }else{
            listOlist.add(data.getPatientList());
            nameList.add(data.getListname());
        }
        listname = name;
        patientList = null;
    }

    public void addPatientList(DataFrame data){
        if (listOlist!=null)
            listOlist.add(data.getPatientList());
            nameList.add(data.getListname());
    }

    public void addPatient(patient currentPatient) {
        if (listOlist==null)
            patientList.add(currentPatient);
    }

    public ArrayList<String> getNameList(){
        return nameList;
    }

    public String getListname(){
        return listname;
    }

    public ArrayList<patient> getPatientList() {
        return patientList;
    }

    public ArrayList<ArrayList<patient>> getPatientLists(){
        return listOlist;
    }

    public boolean isListOlist(){
        if (listOlist == null)
            return false;
        return true;
    }

    public void renameList(int idx, String name){
        nameList.set(idx,name);
    }

    public patient getPatient(int idx){
        return patientList.get(idx);
    }

    public patient getPatient(String name, int idx){
        if (listOlist==null && name != this.listname)
            return null;
        else if (name == this.listname) {
            return patientList.get(idx);
        } else {
            int i = 0;
            for (String id:nameList){
                if(id == name){
                    return listOlist.get(i).get(idx);
                }
                i++;
            }
        }
        return null;
    }

    public int findPatient(String id){
        for(int i =0; i<patientList.size(); i++){
            if (patientList.get(i).getId() == id) {
                return i;
                }
            }
        System.out.println("The list does not contain such id.");
        return -1;
    }

    public void removePatient(int idx, patient p){
        listOlist.get(idx).remove(p);
    }

    public void setPatientList(ArrayList<patient> patientList) {
        this.patientList = patientList;
    }

    public void deletePatientList(String name){
        if (listOlist != null && nameList.contains(name)){
            int idx = nameList.indexOf(name);
            listOlist.remove(idx);
            nameList.remove(idx);
        }
    }

    public void deletePatient(patient p){
        this.patientList.remove(p);
    }

    public void removePatientList(String name){
        this.listOlist.remove(nameList.indexOf(name));
        this.nameList.remove(name);
    }
}

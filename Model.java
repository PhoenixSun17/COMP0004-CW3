package uk.ac.ucl.model;

import java.io.*;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

public class Model {
  private DataFrame frame;
  private readCSV CSV;
  private String filepath = "./data/autosave.csv";
  private int i = 0;

  public Model() {
    frame = null;
    CSV = new readCSV();
  }

  public void test(int num) {
    DataFrame temp = new DataFrame("TEST", this.frame);
    for (int i = 0; i < num; i++) {
      String tmp = "test"+i;
      DataFrame a = new DataFrame(tmp);
      patient John = new patient("Johndoe", "TEST");
      John.setFirst("Test");
      John.setLast("Object "+i);
      a.addPatient(John);
      temp.addPatientList(a);
    }
    this.frame = temp;
  }

  public List<String> getListNames() {
    List<String> names = new ArrayList<String>();
    if (frame.isListOlist()) {
      names = frame.getNameList();
    } else {
      names.add(frame.getListname());
    }
    return names;
  }

  public void removeList(String name){
    this.frame.removePatientList(name);
  }

  public boolean readFile(File file) {
    String filePath = file.getAbsolutePath();
    String name = file.getName();
    ArrayList<patient> patients = CSV.createPatientList(filePath);
    if (patients==null){
      return false;
    }
    patients.remove(0);
    this.frame = new DataFrame(name);
    frame.setPatientList(patients);
    return true;
  }

  public boolean readFile(File file,String add) {
    String filePath = file.getAbsolutePath();
    String name = file.getName();
    ArrayList<patient> patients = CSV.createPatientList(filePath);
    if (patients==null){
      return false;
    }
    patients.remove(0);
    DataFrame tmp = new DataFrame(name);
    tmp.setPatientList(patients);
    frame.addPatientList(tmp);
    return true;
  }

  public List<patient> getPatientList() {
    if (!frame.isListOlist()) {
      return frame.getPatientList();
    } else
      return null;
  }

  public DataFrame returnFrame() {
    return this.frame;
  }

  public int findIdsList(String id){
    List<ArrayList<patient>> tmp = frame.getPatientLists();
    int i = -1;
    for (ArrayList<patient> a :tmp){
      for (patient b :a){
        if(b.getId()==id){
          i = tmp.indexOf(a);
          return i;
        }
      }
    }
    return i;
  }

  public void renameList(int idx, String name){
    frame.renameList(idx,name);
  }

  public List<ArrayList<patient>> getListOList() {
    return frame.getPatientLists();
  }

  public boolean isList() {
    return frame.isListOlist();
  }

  public patient getPatient(String name, int idx) {
    if (frame.isListOlist()) {
      return frame.getPatientLists().get(frame.getNameList().indexOf(name)).get(idx);
    } else {
      if (frame.getListname() != name)
        return null;
      else
        return frame.getPatientList().get(idx);
    }
  }

  public patient getPatientDetail(String id, int pat) {
    patient patient = searchById(id, pat);
    return patient;
  }

  public void removePatient(String name, patient p){
    if (frame.getNameList().contains(name)){
      int idx = frame.getNameList().indexOf(name);
      frame.removePatient(idx,p);
    }
  }

  public void addPatient(String name, String[] info){
    patient tmp = CSV.newPatient(info);
    if (name == "allList"){
      for (int i = 0; i < frame.getNameList().size(); i++){
        frame.getPatientLists().get(i).add(tmp);
      }
    }else if (frame.getNameList().contains(name)){
      int idx = frame.getNameList().indexOf(name);
      frame.getPatientLists().get(idx).add(tmp);
    }else {
      //do nothing
    }
  }

  public int getAge(patient patient) {
    int age;
    String birthdate = patient.getBirthdate();
    String deathdate = patient.getDeathdate();
    if(patient.getBirthdate()==null||patient.getBirthdate().length()<4){
      System.out.println("These objects are not classified as human, ");
      System.out.println("either because it is URL type or other types that does not have a birthdate");
      return -10000;
    }
    String birthyear = birthdate.substring(0, 4);
    Integer intBirthYear = Integer.valueOf(birthyear);

    if (!deathdate.equals("")) {  // if the person dead
      String deathyear = deathdate.substring(0, 4);
      Integer intDeathYear = Integer.valueOf(deathyear);

      age = intDeathYear - intBirthYear;
    } else { // the person is alive
      int currentYear = Calendar.getInstance().get(Calendar.YEAR);
      age = currentYear - intBirthYear;
    }
    return age;
  }

  private List<Integer> getAgeList(List<patient> patients) {
    List<Integer> ageList = new ArrayList<>();

    for (patient p : patients) {
      if (getAge(p)>0)
        ageList.add(getAge(p));
    }

    return ageList;
  }

  public patient getYoungest(List<patient> patients) {
    patient patient = null;
    List<Integer> ageList = getAgeList(patients);
    int minAge = 10000;
    int index = 0;

    for (int i = 0; i < ageList.size(); i++) {
      if (ageList.get(i) < minAge) {
        minAge = ageList.get(i);
        index = i;
      }
    }
    patient = patients.get(index);

    return patient;
  }

  public patient getOldest(List<patient> patients){
    patient pat = null;
    List<Integer> ageList = getAgeList(patients);
    int maxAge = 0;
    int index = 0;

    for (int i = 0; i < ageList.size(); i++){
      if(ageList.get(i) > maxAge){
        maxAge = ageList.get(i);
        index = i;
      }
    }
    pat = patients.get(index);

    return pat;
  }

  public double averageAge(List<patient> patients){
    List<Integer> ageList = getAgeList(patients);
    int sum = 0;

    for(int age: ageList){
      sum += age;
    }
    double average = sum / ageList.size();

    return average;
  }

  public int getAgeDistribution(List<patient> patients, int min, int max){
    List<Integer> ageList = getAgeList(patients);
    int num = 0;
    for(int age: ageList){
      if (min<= age && max > age){
        num++;
      }
    }

    return num;
  }


  public patient searchById(String id, int pat) {
    List<patient> patients = frame.getPatientLists().get(pat);
    patient result = patients.stream()
            .filter(patient -> id.equals(patient.getId()))
            .findAny()
            .orElse(null);

    return result;
  }

  public List<patient> getAllPatient(){
    List<patient> temp = new ArrayList<>();
    for (int i = 0; i< frame.getPatientLists().size();i++){
      for (int j = 0; j<frame.getPatientLists().get(i).size();j++){
        temp.add(frame.getPatientLists().get(i).get(j));
      }
    }
    return temp;
  }

  // This also returns dummy data. The real version should use the keyword parameter to search
  // the patient data and return a list of matching items.
  public List<patient> singleSearch(List<patient> patients, String field, String keyword) {
    List<patient> resultList = new ArrayList<>();
    Search searchList = new Search(patients, keyword);

    resultList = searchList.selectField(field);

    return resultList;
  }

  public List<String> searchFor(String keyword) {
    return List.of("Search keyword is: " + keyword, "result1", "result2", "result3");
  }

  public List<patient> ageSearch(List<patient> patients, int min, int max){
    List<patient> resultList = new ArrayList<>();
    List<Integer> ages = getAgeList(patients);

    for(int i = 0; i < ages.size(); i++){
      int age = ages.get(i);
      if(min <= age && max > age){
        patient p = patients.get(i);
        resultList.add(p);
      }
    }
    return resultList;
  }

  public void autoSave(){
    String tmp = "temp.csv";
    File oldFile = new File(filepath);
    File newFile = new File(tmp);
    try{
      FileWriter fw = new FileWriter(newFile,true);
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);
      pw.println("AutoSave log version."+i);
      pw.println("ID,BIRTHDATE,DEATHDATE,SSN,DRIVERS,PASSPORT,PREFIX,FIRST,LAST,SUFFIX,MAIDEN,MARITAL,RACE,ETHNICITY,GENDER,BIRTHPLACE,ADDRESS,CITY,STATE,ZIP");
      for(List<patient> l:frame.getPatientLists()){
        for (patient p : l){
          pw.println(p.getId()+","+p.getBirthdate()+","+p.getDeathdate()+","+p.getSsn()+","+p.getDrivers()+","+p.getPassport()+
                  ","+p.getPrefix()+ ","+p.getFirst()+","+p.getLast()+","+p.getSuffix()+","+p.getMaiden()+","+p.getMarital()+
                  ","+p.getRace()+","+ p.getEthnicity()+ ","+p.getGender()+","+p.getBirthplace()+","+p.getAddress()+","+
                  p.getCity()+","+p.getState()+","+p.getZip());
        }
      }
      pw.flush();
      pw.close();
      oldFile.delete();
      File dump = new File(filepath);
      newFile.renameTo(dump);
    } catch (IOException e) {
      System.out.println("ERROR");
    }
    i++;
  }

  public String getPath(){
    File tmp = new File(filepath);
    return tmp.getAbsolutePath();
  }

}


package com.example.testfigma2;

public class State {

    private String state_patient; // название
    private String state_doctor;  // столица
    private String state_time; // ресурс флага

    public State(String state_patient, String state_doctor, String state_time) {
        this.state_patient = state_patient;
        this.state_doctor = state_doctor;
        this.state_time = state_time;
    }

    public String getState_patient() {
        return state_patient;
    }

    public void setState_patient(String state_patient) {
        this.state_patient = state_patient;
    }

    public String getState_doctor() {
        return state_doctor;
    }

    public void setState_doctor(String state_doctor) {
        this.state_doctor = state_doctor;
    }

    public String getState_time() {
        return state_time;
    }

    public void setState_time(String state_time) {
        this.state_time = state_time;
    }
}


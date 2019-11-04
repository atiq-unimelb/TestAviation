package com.flightcenter.testaviation.model;

/*
 * This class demonstrate
 * 1. Plain Old Java Objects for flight
 * Atiq Shaikh 31/10/2019
 * */

public class Flight {

    private int id;
    private String departureDate;
    private String airlineCode;
    private int flightNumber;
    private String departureCity;
    private String departureAirport;
    private String arrivalCity;
    private String arrivalAirport;
    private String scheduledDuration;
    private String arrivalDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getScheduledDuration() {
        return scheduledDuration;
    }

    public void setScheduledDuration(String scheduledDuration) {
        this.scheduledDuration = scheduledDuration;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", departureDate=" + departureDate +
                ", airlineCode='" + airlineCode + '\'' +
                ", flightNumber=" + flightNumber +
                ", departureCity='" + departureCity + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", scheduledDuration='" + scheduledDuration + '\'' +
                ", arrivalDate=" + arrivalDate +
                '}';
    }

}

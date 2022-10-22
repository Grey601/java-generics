package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int cost;
    private String from;
    private String to;
    private int during;

    public Ticket(int id, int cost, String from, String to, int during) {
        this.id = id;
        this.cost = cost;
        this.from = from;
        this.to = to;
        this.during = during;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getCost() {
//        return cost;
//    }
//
//    public void setCost(int cost) {
//        this.cost = cost;
//    }

    public String getFrom() {
        return from;
    }

//    public void setFrom(String from) {
//        this.from = from;
//    }

    public String getTo() {
        return to;
    }

//    public void setTo(String to) {
//        this.to = to;
//    }
//
//    public int getDuring() {
//        return during;
//    }
//
//    public void setDuring(int during) {
//        this.during = during;
//    }

    @Override
    public int compareTo(Ticket otherTicket) {
        if (this.cost == otherTicket.cost) {
            return 0;
        }
        if (this.cost < otherTicket.cost) {
            return -1;
        }
        return 1;
    }
}

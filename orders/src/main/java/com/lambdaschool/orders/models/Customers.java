package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customers
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custcode;

    @Column(nullable = false)
    private String custname;

    private String custcity;
    private String workingarea;
    private String custcountry;
    private String grade;
    private Double openingamt;
    private Double receiveamt;
    private Double paymentamt;
    private Double outstandingamt;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "agentcode",
                nullable = false)
    @JsonIgnoreProperties("custcode")
    private Agents agentcode;

    @OneToMany(mappedBy = "custcode", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("custcode")
    private List<Orders> orders = new ArrayList<>();

    public Customers()
    {
    }

    public Customers(String custname, String custcity, String workingarea, String custcountry, String grade, Double openingamt, Double receiveamt, Double paymentamt, Double outstandingamt, String phone, Agents agentcode)
    {
        this.custname = custname;
        this.custcity = custcity;
        this.workingarea = workingarea;
        this.custcountry = custcountry;
        this.grade = grade;
        this.openingamt = openingamt;
        this.receiveamt = receiveamt;
        this.paymentamt = paymentamt;
        this.outstandingamt = outstandingamt;
        this.phone = phone;
        this.agentcode = agentcode;
    }

    public List<Orders> getOrders()
    {
        return orders;
    }

    public void setOrders(List<Orders> orders)
    {
        this.orders = orders;
    }

    public long getCustcode()
    {
        return custcode;
    }

    public String getCustname()
    {
        return custname;
    }

    public void setCustname(String custname)
    {
        this.custname = custname;
    }

    public String getCustcity()
    {
        return custcity;
    }

    public void setCustcity(String custcity)
    {
        this.custcity = custcity;
    }

    public String getWorkingarea()
    {
        return workingarea;
    }

    public void setWorkingarea(String workingarea)
    {
        this.workingarea = workingarea;
    }

    public String getCustcountry()
    {
        return custcountry;
    }

    public void setCustcountry(String custcountry)
    {
        this.custcountry = custcountry;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public Double getOpeningamt()
    {
        return openingamt;
    }

    public void setOpeningamt(Double openingamt)
    {
        this.openingamt = openingamt;
    }

    public Double getReceiveamt()
    {
        return receiveamt;
    }

    public void setReceiveamt(Double receiveamt)
    {
        this.receiveamt = receiveamt;
    }

    public Double getPaymentamt()
    {
        return paymentamt;
    }

    public void setPaymentamt(Double paymentamt)
    {
        this.paymentamt = paymentamt;
    }

    public Double getOutstandingamt()
    {
        return outstandingamt;
    }

    public void setOutstandingamt(Double outstandingamt)
    {
        this.outstandingamt = outstandingamt;
    }

    public String getPhone()
    {
        return phone;
    }

    public Agents getAgentcode()
    {
        return agentcode;
    }

    public void setAgentcode(Agents agentcode)
    {
        this.agentcode = agentcode;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;

    }

}

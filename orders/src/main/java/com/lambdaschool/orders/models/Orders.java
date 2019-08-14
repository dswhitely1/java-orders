package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ordnum;

    private Double ordamount;
    private Double advanceamount;

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnoreProperties("orders")
    private Long custcode;

    private String orddescription;

    public Orders()
    {
    }

    public Orders(Double ordamount, Double advanceamount, Long custcode, String orddescription)
    {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.custcode = custcode;
        this.orddescription = orddescription;
    }

    public Long getOrdnum()
    {
        return ordnum;
    }

    public Double getOrdamount()
    {
        return ordamount;
    }

    public void setOrdamount(Double ordamount)
    {
        this.ordamount = ordamount;
    }

    public Double getAdvanceamount()
    {
        return advanceamount;
    }

    public void setAdvanceamount(Double advanceamount)
    {
        this.advanceamount = advanceamount;
    }

    public Long getCustcode()
    {
        return custcode;
    }

    public void setCustcode(Long custcode)
    {
        this.custcode = custcode;
    }

    public String getOrddescription()
    {
        return orddescription;
    }

    public void setOrddescription(String orddescription)
    {
        this.orddescription = orddescription;
    }
}

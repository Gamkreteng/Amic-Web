package com.tmu.amic.controller.response;

import java.util.Objects;

public class ClientPartnerResponse {

    private String cpName;

    private String cpAddress;

    private String cpDetails;

    public ClientPartnerResponse() {
    }

    public ClientPartnerResponse(String cpName, String cpAddress, String cpDetails) {
        this.cpName = cpName;
        this.cpAddress = cpAddress;
        this.cpDetails = cpDetails;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName;
    }

    public String getCpAddress() {
        return cpAddress;
    }

    public void setCpAddress(String cpAddress) {
        this.cpAddress = cpAddress;
    }

    public String getCpDetails() {
        return cpDetails;
    }

    public void setCpDetails(String cpDetails) {
        this.cpDetails = cpDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientPartnerResponse)) return false;
        ClientPartnerResponse that = (ClientPartnerResponse) o;
        return Objects.equals(getCpName(), that.getCpName()) &&
                Objects.equals(getCpAddress(), that.getCpAddress()) &&
                Objects.equals(getCpDetails(), that.getCpDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpName(), getCpAddress(), getCpDetails());
    }

    @Override
    public String toString() {
        return "ClientPartnerResponse{" +
                "cpName='" + cpName + '\'' +
                ", cpAddress='" + cpAddress + '\'' +
                ", cpDetails='" + cpDetails + '\'' +
                '}';
    }
}

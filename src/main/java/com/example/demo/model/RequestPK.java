package com.example.demo.model;
import java.io.Serializable;
import java.util.Objects;

public class RequestPK implements Serializable {


    private String username;
    private int pId;

    public RequestPK(){

    }

    public RequestPK(String username,int pId){
        this.username=username;
        this.pId=pId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.pId;
        hash = 83 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RequestPK other = (RequestPK) obj;
        if (this.pId != other.pId) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }


}

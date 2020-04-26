package com.ss.retraining.dto;

import com.ss.retraining.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor

public class FormsResultsDTO {
    private long id;
    private long tokenId;
    private String answers;
    private Timestamp created;

    private Users users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

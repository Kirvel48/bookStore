package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiLoginResponseModel {
    private String userId, password, token, expires;
    @JsonProperty("username")
    private String userName;
    @JsonProperty("created_date")
    private String createdDate;
}
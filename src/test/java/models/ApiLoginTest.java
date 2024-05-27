package models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data

public class ApiLoginTest {
    @Setter
    String password;
    @Setter
    String userName;
}

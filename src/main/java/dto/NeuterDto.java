package dto;

import lombok.Data;
import java.util.Date;

@Data
public class NeuterDto {

    private int id;
    private String name;
    private Date createDate = new Date();
}

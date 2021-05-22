package pl.edu.pw.pik.pikactivitytrackerserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebsiteDTO {
    private Integer website_id;
    private Integer user_id;
    private String url;
}

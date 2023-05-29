package pojo;

import lombok.Data;

import java.util.List;

@Data
public class Pet {
    private Integer id;
    private Category category;
    private String name;
    private List<String> photoUrls = null;
    private List<Tag> tags = null;
    private String status;
}

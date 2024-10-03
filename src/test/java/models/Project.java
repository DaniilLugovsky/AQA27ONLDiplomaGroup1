package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Project {
    @EqualsAndHashCode.Exclude
    private Integer id;
    private String name;
    @SerializedName("project_key")
    @JsonProperty("project_key")
    private String projectKey;
    private String description;
}

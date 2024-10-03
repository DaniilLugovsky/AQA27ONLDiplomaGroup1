package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TestCase {
    private String title;
    private String owner;
    private String template;
    private String priority;
    private String type;
    private String precondition;
    private String steps;
    private String expectedResults;
}
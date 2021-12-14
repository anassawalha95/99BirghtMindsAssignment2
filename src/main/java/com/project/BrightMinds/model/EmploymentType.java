package com.project.BrightMinds.model;


public
enum EmploymentType {
    CONTRACT ("Contract"),
    PERMANENT ("Permanent"),
    INTERN ("Intern");

    private final String type;

    EmploymentType(String type) {
        this.type=type;
    }

    public
    String getType() {
        return type;
    }
}

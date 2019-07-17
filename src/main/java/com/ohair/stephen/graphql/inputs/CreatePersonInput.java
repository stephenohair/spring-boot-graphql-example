package com.ohair.stephen.graphql.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePersonInput {
    private String firstName;
    private String middleName;
    private String lastName;
}
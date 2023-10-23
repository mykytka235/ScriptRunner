package mykytka235.ms.scriptrunner.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PythonScript {

    DELETE_USER("./src/main/resources/scripts/deleteUser.py");

    private final String pathToFile;

}

package mykytka235.ms.scriptrunner.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PythonScriptExecutorUtil {

    private static final String PYTHON_COMMAND = "python3";

    public static Process execScript(String pathToFile, List<String> args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(buildCommand(pathToFile, args));
        return processBuilder.start();
    }

    public static List<String> readProcessOutput(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        List<String> content = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            content.add(line);
        }

        return content;
    }

    private static List<String> buildCommand(String pathToFile, List<String> args) {
        List<String> command = new ArrayList<>();
        command.add(PYTHON_COMMAND);
        command.add(pathToFile);
        command.addAll(args);

        return command;
    }

}

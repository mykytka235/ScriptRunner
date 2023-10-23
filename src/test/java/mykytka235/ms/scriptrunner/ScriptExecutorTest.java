package mykytka235.ms.scriptrunner;

import mykytka235.ms.scriptrunner.util.PythonScriptExecutorUtil;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class ScriptExecutorTest {

    @Test
    public void givenPythonScript_whenPythonProcessInvoked_thenSuccess() throws Exception {

        List<String> args = List.of("1", "message");
        Process process = PythonScriptExecutorUtil.execScript("./src/test/resources/scripts/args-test.py", args);
        List<String> results = PythonScriptExecutorUtil.readProcessOutput(process.getInputStream());
        int exitCode = process.waitFor();

        assertEquals("Success", 3, results.size());
        assertEquals("Success", "./src/test/resources/scripts/args-test.py", results.get(0));
        assertEquals("Success", "1", results.get(1));
        assertEquals("Success", "message", results.get(2));
        assertEquals("Success", 0, exitCode);
    }

    private List<String> readProcessOutput(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        List<String> content = new ArrayList<>();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            content.add(line);
        }

        return content;
    }


}

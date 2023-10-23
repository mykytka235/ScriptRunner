package mykytka235.ms.scriptrunner.service;

import mykytka235.ms.scriptrunner.constants.PythonScript;
import mykytka235.ms.scriptrunner.exception.InnerServiceException;
import mykytka235.ms.scriptrunner.util.PythonScriptExecutorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ServiceProviderImpl implements ServiceProvider {

    @Override
    public void deleteUser(String customerId) {
        try {

            log.info("Start processing script = {}, path = {}", PythonScript.DELETE_USER, PythonScript.DELETE_USER.getPathToFile());
            Process process = PythonScriptExecutorUtil.execScript(PythonScript.DELETE_USER.getPathToFile(), List.of(customerId));

            List<String> results = PythonScriptExecutorUtil.readProcessOutput(process.getInputStream());
            results.forEach(log::info);

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                log.error("Script executed. Exit code = {}", exitCode);
                throw new InnerServiceException(String.format("Error during script execution. Script = %s",
                        PythonScript.DELETE_USER));
            }

        } catch (IOException | InterruptedException ex) {
            log.error("Error due script execution. Script name = {}, path to file = {}. Error: {}",
                    PythonScript.DELETE_USER, PythonScript.DELETE_USER.getPathToFile(), ex);
        }
    }

}

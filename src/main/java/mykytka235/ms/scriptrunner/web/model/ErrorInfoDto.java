
package mykytka235.ms.scriptrunner.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfoDto {

    @NotNull
    private Integer status;
    @NotNull
    private List<String> messages = new ArrayList<>();
    @NotNull
    private String debugMessage;
    @NotNull
    private Integer code;
    private String header;

}

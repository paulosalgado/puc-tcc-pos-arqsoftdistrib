package tech.paulosalgado.puc.compliance.application.environmental;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = @Builder)
public class EnvironmentalStandardDTO {

    private Long id;
    private String source;
    private String content;

}

package tech.paulosalgado.puc.compliance.application.environmental;

import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import tech.paulosalgado.puc.compliance.domain.environmental.EnvironmentalStandard;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class EnvironmentalStandardFactory {

    public static Page<EnvironmentalStandardDTO> toListEnvironmentalStandardDTO(Page<EnvironmentalStandard> standards) {
        return standards.map(EnvironmentalStandardFactory::toEnvironmentalStandardDTO);
    }

    private static EnvironmentalStandardDTO toEnvironmentalStandardDTO(EnvironmentalStandard standard) {
        return EnvironmentalStandardDTO.builder()
                .id(standard.getId())
                .source(standard.getSource())
                .content(standard.getContent())
                .build();
    }

}

package tech.paulosalgado.puc.compliance.domain.environmental;

import lombok.NoArgsConstructor;
import tech.paulosalgado.puc.compliance.domain.environmental.thirdparty.EnvironmentalThirdPartyResponse;
import tech.paulosalgado.puc.compliance.domain.environmental.thirdparty.SourceThirdPartyResponse;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;
import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

@NoArgsConstructor(access = PRIVATE)
public class EnvironmentalStandardFactory {

    public static List<EnvironmentalStandard> toListEnvironmentalStandard(EnvironmentalThirdPartyResponse standardsThirdParty) {

        List<EnvironmentalStandard> standards = newArrayList();

        for (SourceThirdPartyResponse source : standardsThirdParty.getSources()) {

            List<EnvironmentalStandard> collect = source.getStandards().stream()
                    .map(standard -> makeEnvironmentalStandard(source.getTitle(), standard))
                    .collect(toList());

            standards.addAll(collect);
        }

        return standards;
    }

    public static EnvironmentalStandard makeEnvironmentalStandard(String source, String standard) {
        return EnvironmentalStandard.builder()
                .source(source)
                .content(standard)
                .build();
    }

}

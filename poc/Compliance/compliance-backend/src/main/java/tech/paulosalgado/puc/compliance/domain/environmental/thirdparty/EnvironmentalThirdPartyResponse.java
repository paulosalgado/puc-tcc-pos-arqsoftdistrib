package tech.paulosalgado.puc.compliance.domain.environmental.thirdparty;

import lombok.Data;

import java.util.List;

@Data
public class EnvironmentalThirdPartyResponse {

    private List<SourceThirdPartyResponse> sources;

}

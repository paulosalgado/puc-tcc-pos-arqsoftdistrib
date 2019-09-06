package tech.paulosalgado.puc.compliance.domain.environmental.thirdparty;

import lombok.Data;

import java.util.List;

@Data
public class SourceThirdPartyResponse {

    private String title;
    private List<String> standards;

}

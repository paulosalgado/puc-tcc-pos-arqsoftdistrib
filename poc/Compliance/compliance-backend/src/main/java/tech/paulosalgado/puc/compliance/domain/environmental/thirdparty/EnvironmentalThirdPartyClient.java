package tech.paulosalgado.puc.compliance.domain.environmental.thirdparty;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "${api.client.environmental.name}", url = "${api.client.environmental.url}")
public interface EnvironmentalThirdPartyClient {

    @GetMapping("/standards")
    EnvironmentalThirdPartyResponse getStandards(@RequestHeader("x-api-key") String apiKey);

}

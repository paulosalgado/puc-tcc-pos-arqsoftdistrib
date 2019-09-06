package tech.paulosalgado.puc.compliance.domain.environmental;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.paulosalgado.puc.compliance.domain.environmental.thirdparty.EnvironmentalThirdPartyClient;
import tech.paulosalgado.puc.compliance.domain.environmental.thirdparty.EnvironmentalThirdPartyResponse;

import java.util.List;

import static tech.paulosalgado.puc.compliance.domain.environmental.EnvironmentalStandardFactory.toListEnvironmentalStandard;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class EnvironmentalServiceImpl implements EnvironmentalService {

    private final EnvironmentalStandardRepository repository;
    private final EnvironmentalThirdPartyClient environmentalClient;

    @Value("${api.client.environmental.api-key}")
    private String apiKeyEnvironmentalClient;

    public void syncLocalDatabase() {

        EnvironmentalThirdPartyResponse standardsThirdParty = environmentalClient.getStandards(apiKeyEnvironmentalClient);
        List<EnvironmentalStandard> standards = toListEnvironmentalStandard(standardsThirdParty);

        repository.replaceData(standards);
    }

    public Page<EnvironmentalStandard> findStandards(Pageable pageable) {
        return repository.findAll(pageable);
    }

}

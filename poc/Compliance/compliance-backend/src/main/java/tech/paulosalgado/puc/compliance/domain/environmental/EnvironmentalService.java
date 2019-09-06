package tech.paulosalgado.puc.compliance.domain.environmental;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnvironmentalService {

    void syncLocalDatabase();

    Page<EnvironmentalStandard> findStandards(Pageable pageable);

}

package tech.paulosalgado.puc.compliance.domain.environmental;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EnvironmentalStandardRepository {

    void replaceData(List<EnvironmentalStandard> standards);

    Page<EnvironmentalStandard> findAll(Pageable pageable);

}

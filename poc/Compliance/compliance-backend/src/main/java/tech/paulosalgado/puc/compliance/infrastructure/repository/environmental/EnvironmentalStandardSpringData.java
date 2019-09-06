package tech.paulosalgado.puc.compliance.infrastructure.repository.environmental;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import tech.paulosalgado.puc.compliance.domain.environmental.EnvironmentalStandard;

public interface EnvironmentalStandardSpringData extends CrudRepository<EnvironmentalStandard, Long> {

    Page<EnvironmentalStandard> findAll(Pageable pageable);

}

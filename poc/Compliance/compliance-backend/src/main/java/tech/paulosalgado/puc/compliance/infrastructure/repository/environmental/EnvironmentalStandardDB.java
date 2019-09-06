package tech.paulosalgado.puc.compliance.infrastructure.repository.environmental;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import tech.paulosalgado.puc.compliance.domain.environmental.EnvironmentalStandard;
import tech.paulosalgado.puc.compliance.domain.environmental.EnvironmentalStandardRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class EnvironmentalStandardDB implements EnvironmentalStandardRepository {

    private final EnvironmentalStandardSpringData repository;

    @Override
    @Transactional
    public void replaceData(List<EnvironmentalStandard> standards) {
        repository.deleteAll();
        repository.saveAll(standards);
    }

    @Override
    public Page<EnvironmentalStandard> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

}

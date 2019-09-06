package tech.paulosalgado.puc.compliance.infrastructure.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.paulosalgado.puc.compliance.application.environmental.EnvironmentalStandardDTO;
import tech.paulosalgado.puc.compliance.domain.environmental.EnvironmentalService;
import tech.paulosalgado.puc.compliance.domain.environmental.EnvironmentalStandard;

import static org.springframework.http.ResponseEntity.ok;
import static tech.paulosalgado.puc.compliance.application.environmental.EnvironmentalStandardFactory.toListEnvironmentalStandardDTO;

@RestController
@RequestMapping("/environmental")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class EnvironmentalController {

    private final EnvironmentalService service;

    @PostMapping
    public ResponseEntity<Page<EnvironmentalStandardDTO>> syncLocalDatabase(@PageableDefault Pageable pageable) {
        service.syncLocalDatabase();
        return findStandards(pageable);
    }

    @GetMapping
    public ResponseEntity<Page<EnvironmentalStandardDTO>> findStandards(@PageableDefault Pageable pageable) {
        Page<EnvironmentalStandard> standards = service.findStandards(pageable);
        Page<EnvironmentalStandardDTO> standardsDTO = toListEnvironmentalStandardDTO(standards);
        return ok().body(standardsDTO);
    }

}

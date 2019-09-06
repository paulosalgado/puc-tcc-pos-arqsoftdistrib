package tech.paulosalgado.puc.compliance.domain.environmental;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = @Builder)
@Entity
@EntityListeners(AuditingEntityListener.class)
public class EnvironmentalStandard {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String source;

    @Column(columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    private LocalDateTime creationDate;

}

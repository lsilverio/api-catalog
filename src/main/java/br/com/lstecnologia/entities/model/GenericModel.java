package br.com.lstecnologia.entities.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class GenericModel implements Serializable {

    private static final long serialVersionUID = 6967241038577250988L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "timestamp", name = "creation_date")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "timestamp", name = "change_date")
    private LocalDateTime changeDate;

}
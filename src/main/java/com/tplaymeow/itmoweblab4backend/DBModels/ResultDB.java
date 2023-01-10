package com.tplaymeow.itmoweblab4backend.DBModels;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "results_web_lab4")
public class ResultDB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "coordinate_x")
    private Double x;

    @Column(name = "coordinate_y")
    private Double y;

    @Column(name = "coordinate_r")
    private Double r;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "success")
    private Boolean success;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserDB owner;
}

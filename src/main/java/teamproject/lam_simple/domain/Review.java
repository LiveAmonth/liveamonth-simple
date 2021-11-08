package teamproject.lam_simple.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reviewNO")
    private Long id;

    @Column
    private String reviewCategory;

    @Lob
    private String reviewDesc;

    private LocalDateTime reviewDate;

    @Column
    private int reviewViewCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNO")
    private User user;
}

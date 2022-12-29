package org.example;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Transactional
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @NonNull
    @Column
    private String firstname;
    @NonNull
    @Column
    private String lastname;
    @NonNull
    @Column
    private String email;

}

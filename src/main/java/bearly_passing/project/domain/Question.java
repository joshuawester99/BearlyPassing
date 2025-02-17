package bearly_passing.project.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body = "";
    private String correctAnswer = "";
    private String givenAnswer;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "studyset_id")
    private StudySet studySet;

    public enum Difficulty {
        EASY, MEDIUM, HARD
    }
}
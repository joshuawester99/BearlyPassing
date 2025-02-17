package bearly_passing.project.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Entity
public class StudySet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JsonIgnore
    private User creator;

    @JsonIgnore
    @OneToMany(mappedBy = "studySet")
    private List<Game> games;

    @JsonIgnore
    @OneToMany(mappedBy = "studySet")
    private List<Question> questions = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Game> getGames() {
        if (games == null) {
            games = new ArrayList<Game>();
        }
        return games;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        if (questions == null) {
            questions = new ArrayList<Question>();
        }
        return questions;
    }

}

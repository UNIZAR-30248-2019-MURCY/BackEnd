package es.unizar.murcy.model.request;

import es.unizar.murcy.model.Question;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionRequest {
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private List<OptionRequest> options;

    public boolean isValid() {
        return title != null
                && !title.equals("")
                && options != null
                && (options.size() >= Question.MIN_OPTIONS && options.size() <= Question.MAX_OPTIONS);
    }

    public Question toEntity() {
        Question question = new Question();
        question.setTitle(title);
        question.setDescription((this.description == null) ? "" : description);
        question.setOptions(options.stream().map(OptionRequest::toEntity).collect(Collectors.toList()));
        question.setIsMultiple(isMultiple());
        return question;
    }

    private Boolean isMultiple() {
        long corrects = options.parallelStream().filter(OptionRequest::isCorrect).count();
        return corrects > 1 || corrects == 0;
    }
}

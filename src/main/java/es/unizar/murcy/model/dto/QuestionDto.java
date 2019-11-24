package es.unizar.murcy.model.dto;

import es.unizar.murcy.model.Option;
import es.unizar.murcy.model.Question;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private boolean isMultiple;

    @Getter
    @Setter
    private WorkflowDto workflow;

    @Getter
    @Setter
    private WorkflowDto lastWorkflow;

    @Getter
    @Setter
    private boolean approved;

    @Getter
    @Setter
    private boolean closed;

    @Getter
    @Setter
    private List<Option> options;

    public QuestionDto(Question question) {
        this.id = question.getId();
        this.title = question.getTitle();
        this.userName = question.getUser().getUsername();
        this.isMultiple = question.getIsMultiple();
        this.description = question.getDescription();
        this.workflow = new WorkflowDto(question.getWorkflow());
        this.lastWorkflow = new WorkflowDto(question.getLastWorkflow());
        this.options = question.getOptions();
        this.approved = question.isApproved();
        this.closed = question.isClosed();
    }
}

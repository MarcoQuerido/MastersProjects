package pt.isep.edom.atb.publico;

import pt.isep.edom.atb.publico.domain.Comment;
import pt.isep.edom.atb.publico.domain.ValidationCommentProcess;

public interface SFactory {

	ValidationCommentProcess getValidationProcess(Comment c);
}

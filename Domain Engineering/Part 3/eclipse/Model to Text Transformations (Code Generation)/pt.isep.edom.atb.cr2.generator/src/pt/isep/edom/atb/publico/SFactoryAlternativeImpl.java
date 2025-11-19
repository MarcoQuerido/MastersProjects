package pt.isep.edom.atb.publico;


import pt.isep.edom.atb.publico.domain.Comment;
import pt.isep.edom.atb.publico.domain.ValidationCommentProcess;
import pt.isep.edom.atb.publico.domain.ValidationCommentProcessImpl2;

public class SFactoryAlternativeImpl implements SFactory {

	@Override
	public ValidationCommentProcess getValidationProcess(Comment c) {
		// TODO Auto-generated method stub
		return new ValidationCommentProcessImpl2(c);
	}
}

package pt.isep.edom.atb.publico;

import pt.isep.edom.atb.publico.domain.Comment;
import pt.isep.edom.atb.publico.domain.ValidationCommentProcess;
import pt.isep.edom.atb.publico.domain.ValidationCommentProcessImpl;

public class SFactoryDefaultImpl implements SFactory {

	@Override
	public ValidationCommentProcess getValidationProcess(Comment c) {
		// TODO Auto-generated method stub
		return new ValidationCommentProcessImpl(c);
	}

}

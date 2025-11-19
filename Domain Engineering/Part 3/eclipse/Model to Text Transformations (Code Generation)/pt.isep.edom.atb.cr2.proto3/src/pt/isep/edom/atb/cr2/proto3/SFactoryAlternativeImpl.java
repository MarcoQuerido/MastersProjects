package pt.isep.edom.atb.cr2.proto3;

import pt.isep.edom.atb.cr2.proto3.domain.Comment;
import pt.isep.edom.atb.cr2.proto3.domain.ValidationCommentProcess;
import pt.isep.edom.atb.cr2.proto3.domain.ValidationCommentProcessImpl2;

public class SFactoryAlternativeImpl implements SFactory {

	@Override
	public ValidationCommentProcess getValidationProcess(Comment c) {
		// TODO Auto-generated method stub
		return new ValidationCommentProcessImpl2(c);
	}
}

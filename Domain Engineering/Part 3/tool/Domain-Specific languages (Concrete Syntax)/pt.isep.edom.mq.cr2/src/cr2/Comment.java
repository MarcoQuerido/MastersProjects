/**
 */
package cr2;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link cr2.Comment#isReply <em>Reply</em>}</li>
 *   <li>{@link cr2.Comment#isModeration <em>Moderation</em>}</li>
 *   <li>{@link cr2.Comment#getCommentType <em>Comment Type</em>}</li>
 *   <li>{@link cr2.Comment#getModerationprocess <em>Moderationprocess</em>}</li>
 *   <li>{@link cr2.Comment#isHasModerationProcess <em>Has Moderation Process</em>}</li>
 * </ul>
 *
 * @see cr2.Cr2Package#getComment()
 * @model annotation="gmf.node label='name'"
 * @generated
 */
public interface Comment extends UserFeedback {
	/**
	 * Returns the value of the '<em><b>Reply</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reply</em>' attribute.
	 * @see #setReply(boolean)
	 * @see cr2.Cr2Package#getComment_Reply()
	 * @model required="true"
	 * @generated
	 */
	boolean isReply();

	/**
	 * Sets the value of the '{@link cr2.Comment#isReply <em>Reply</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reply</em>' attribute.
	 * @see #isReply()
	 * @generated
	 */
	void setReply(boolean value);

	/**
	 * Returns the value of the '<em><b>Moderation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moderation</em>' attribute.
	 * @see #setModeration(boolean)
	 * @see cr2.Cr2Package#getComment_Moderation()
	 * @model required="true"
	 * @generated
	 */
	boolean isModeration();

	/**
	 * Sets the value of the '{@link cr2.Comment#isModeration <em>Moderation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moderation</em>' attribute.
	 * @see #isModeration()
	 * @generated
	 */
	void setModeration(boolean value);

	/**
	 * Returns the value of the '<em><b>Comment Type</b></em>' attribute.
	 * The literals are from the enumeration {@link cr2.CommentType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment Type</em>' attribute.
	 * @see cr2.CommentType
	 * @see #setCommentType(CommentType)
	 * @see cr2.Cr2Package#getComment_CommentType()
	 * @model
	 * @generated
	 */
	CommentType getCommentType();

	/**
	 * Sets the value of the '{@link cr2.Comment#getCommentType <em>Comment Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment Type</em>' attribute.
	 * @see cr2.CommentType
	 * @see #getCommentType()
	 * @generated
	 */
	void setCommentType(CommentType value);

	/**
	 * Returns the value of the '<em><b>Moderationprocess</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moderationprocess</em>' containment reference.
	 * @see #setModerationprocess(ModerationProcess)
	 * @see cr2.Cr2Package#getComment_Moderationprocess()
	 * @model containment="true"
	 * @generated
	 */
	ModerationProcess getModerationprocess();

	/**
	 * Sets the value of the '{@link cr2.Comment#getModerationprocess <em>Moderationprocess</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moderationprocess</em>' containment reference.
	 * @see #getModerationprocess()
	 * @generated
	 */
	void setModerationprocess(ModerationProcess value);

	/**
	 * Returns the value of the '<em><b>Has Moderation Process</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Moderation Process</em>' attribute.
	 * @see cr2.Cr2Package#getComment_HasModerationProcess()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='not self.moderationprocess-&gt;isEmpty()'"
	 * @generated
	 */
	boolean isHasModerationProcess();

} // Comment

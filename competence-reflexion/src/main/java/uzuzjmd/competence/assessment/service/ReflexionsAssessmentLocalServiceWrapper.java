package uzuzjmd.competence.assessment.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReflexionsAssessmentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReflexionsAssessmentLocalService
 * @generated
 */
public class ReflexionsAssessmentLocalServiceWrapper
    implements ReflexionsAssessmentLocalService,
        ServiceWrapper<ReflexionsAssessmentLocalService> {
    private ReflexionsAssessmentLocalService _reflexionsAssessmentLocalService;

    public ReflexionsAssessmentLocalServiceWrapper(
        ReflexionsAssessmentLocalService reflexionsAssessmentLocalService) {
        _reflexionsAssessmentLocalService = reflexionsAssessmentLocalService;
    }

    /**
    * Adds the reflexions assessment to the database. Also notifies the appropriate model listeners.
    *
    * @param reflexionsAssessment the reflexions assessment
    * @return the reflexions assessment that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public uzuzjmd.competence.assessment.model.ReflexionsAssessment addReflexionsAssessment(
        uzuzjmd.competence.assessment.model.ReflexionsAssessment reflexionsAssessment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.addReflexionsAssessment(reflexionsAssessment);
    }

    /**
    * Creates a new reflexions assessment with the primary key. Does not add the reflexions assessment to the database.
    *
    * @param assessmentId the primary key for the new reflexions assessment
    * @return the new reflexions assessment
    */
    @Override
    public uzuzjmd.competence.assessment.model.ReflexionsAssessment createReflexionsAssessment(
        long assessmentId) {
        return _reflexionsAssessmentLocalService.createReflexionsAssessment(assessmentId);
    }

    /**
    * Deletes the reflexions assessment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param assessmentId the primary key of the reflexions assessment
    * @return the reflexions assessment that was removed
    * @throws PortalException if a reflexions assessment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public uzuzjmd.competence.assessment.model.ReflexionsAssessment deleteReflexionsAssessment(
        long assessmentId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.deleteReflexionsAssessment(assessmentId);
    }

    /**
    * Deletes the reflexions assessment from the database. Also notifies the appropriate model listeners.
    *
    * @param reflexionsAssessment the reflexions assessment
    * @return the reflexions assessment that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public uzuzjmd.competence.assessment.model.ReflexionsAssessment deleteReflexionsAssessment(
        uzuzjmd.competence.assessment.model.ReflexionsAssessment reflexionsAssessment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.deleteReflexionsAssessment(reflexionsAssessment);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _reflexionsAssessmentLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link uzuzjmd.competence.assessment.model.impl.ReflexionsAssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link uzuzjmd.competence.assessment.model.impl.ReflexionsAssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public uzuzjmd.competence.assessment.model.ReflexionsAssessment fetchReflexionsAssessment(
        long assessmentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.fetchReflexionsAssessment(assessmentId);
    }

    /**
    * Returns the reflexions assessment with the matching UUID and company.
    *
    * @param uuid the reflexions assessment's UUID
    * @param companyId the primary key of the company
    * @return the matching reflexions assessment, or <code>null</code> if a matching reflexions assessment could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public uzuzjmd.competence.assessment.model.ReflexionsAssessment fetchReflexionsAssessmentByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.fetchReflexionsAssessmentByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the reflexions assessment matching the UUID and group.
    *
    * @param uuid the reflexions assessment's UUID
    * @param groupId the primary key of the group
    * @return the matching reflexions assessment, or <code>null</code> if a matching reflexions assessment could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public uzuzjmd.competence.assessment.model.ReflexionsAssessment fetchReflexionsAssessmentByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.fetchReflexionsAssessmentByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns the reflexions assessment with the primary key.
    *
    * @param assessmentId the primary key of the reflexions assessment
    * @return the reflexions assessment
    * @throws PortalException if a reflexions assessment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public uzuzjmd.competence.assessment.model.ReflexionsAssessment getReflexionsAssessment(
        long assessmentId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.getReflexionsAssessment(assessmentId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the reflexions assessment with the matching UUID and company.
    *
    * @param uuid the reflexions assessment's UUID
    * @param companyId the primary key of the company
    * @return the matching reflexions assessment
    * @throws PortalException if a matching reflexions assessment could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public uzuzjmd.competence.assessment.model.ReflexionsAssessment getReflexionsAssessmentByUuidAndCompanyId(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.getReflexionsAssessmentByUuidAndCompanyId(uuid,
            companyId);
    }

    /**
    * Returns the reflexions assessment matching the UUID and group.
    *
    * @param uuid the reflexions assessment's UUID
    * @param groupId the primary key of the group
    * @return the matching reflexions assessment
    * @throws PortalException if a matching reflexions assessment could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public uzuzjmd.competence.assessment.model.ReflexionsAssessment getReflexionsAssessmentByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.getReflexionsAssessmentByUuidAndGroupId(uuid,
            groupId);
    }

    /**
    * Returns a range of all the reflexions assessments.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link uzuzjmd.competence.assessment.model.impl.ReflexionsAssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of reflexions assessments
    * @param end the upper bound of the range of reflexions assessments (not inclusive)
    * @return the range of reflexions assessments
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<uzuzjmd.competence.assessment.model.ReflexionsAssessment> getReflexionsAssessments(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.getReflexionsAssessments(start,
            end);
    }

    /**
    * Returns the number of reflexions assessments.
    *
    * @return the number of reflexions assessments
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getReflexionsAssessmentsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.getReflexionsAssessmentsCount();
    }

    /**
    * Updates the reflexions assessment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param reflexionsAssessment the reflexions assessment
    * @return the reflexions assessment that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public uzuzjmd.competence.assessment.model.ReflexionsAssessment updateReflexionsAssessment(
        uzuzjmd.competence.assessment.model.ReflexionsAssessment reflexionsAssessment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reflexionsAssessmentLocalService.updateReflexionsAssessment(reflexionsAssessment);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _reflexionsAssessmentLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _reflexionsAssessmentLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _reflexionsAssessmentLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ReflexionsAssessmentLocalService getWrappedReflexionsAssessmentLocalService() {
        return _reflexionsAssessmentLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedReflexionsAssessmentLocalService(
        ReflexionsAssessmentLocalService reflexionsAssessmentLocalService) {
        _reflexionsAssessmentLocalService = reflexionsAssessmentLocalService;
    }

    @Override
    public ReflexionsAssessmentLocalService getWrappedService() {
        return _reflexionsAssessmentLocalService;
    }

    @Override
    public void setWrappedService(
        ReflexionsAssessmentLocalService reflexionsAssessmentLocalService) {
        _reflexionsAssessmentLocalService = reflexionsAssessmentLocalService;
    }
}

package api.dnevnik.partners;

import api.dnevnik.partners.data.*;
import api.dnevnik.partners.model.feed.UserFeedResponse;
import api.dnevnik.partners.model.mark.*;
import api.dnevnik.partners.model.schedule.DaySchedule;
import api.dnevnik.partners.model.schedule.Timetable;
import api.dnevnik.partners.model.user.*;
import api.dnevnik.partners.model.work.*;
import api.dnevnik.partners.network.AccessTokenInterceptor;
import api.dnevnik.partners.network.AccessTokenProvider;
import api.dnevnik.partners.suppliers.*;
import com.google.gson.Gson;
import io.reactivex.rxjava3.core.Single;
import lombok.*;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
public class DnevnikClient implements AccessTokenProvider, DnevnikPartnersApi {

    private DnevnikPartnersApi api;

    private AccessTokenRepository repository;

    protected DnevnikClient() {
    }

    public static DnevnikClient create() {
        Gson gson = new GsonSupplier().get();
        OkHttpClient okHttpClient = new OkHttpClientSupplier().get();
        Retrofit retrofit = new RetrofitSupplier(gson, okHttpClient).get();
        DnevnikPartnersApi api = new DnevnikPartnersApiSupplier(retrofit).get();
        RuntimeAccessTokenRepository repository = new RuntimeAccessTokenRepository();
        DnevnikClient dnevnikClient = new DnevnikClient();
        dnevnikClient.setApi(api);
        dnevnikClient.setRepository(repository);
        AccessTokenInterceptor.injectTokenProvider(okHttpClient, dnevnikClient);
        return dnevnikClient;
    }

    @Override
    public String getAccessToken() {
        return this.repository.getAccessToken();
    }

    public void setAccessToken(String accessToken) {
        this.repository.setAccessToken(accessToken);
    }

    @Override
    public Single<String> getAverageMarksByPeriod(long person, long period) {
        return api.getAverageMarksByPeriod(person, period);
    }

    @Override
    public Single<String> getAverageMarkBySubject(long person, long period, long subject) {
        return api.getAverageMarkBySubject(person, period, subject);
    }

    @Override
    public Single<List<AverageMark>> getAverageMarksTillDate(long group, long period, LocalDate date) {
        return api.getAverageMarksTillDate(group, period, date).map(this::injectMany);
    }

    @Override
    public Single<List<TinyAverageMark>> getAverageMarksByPeriod(long group, LocalDate from, LocalDate to) {
        return api.getAverageMarksByPeriod(group, from, to).map(this::injectMany);
    }

    @Override
    public Single<List<Long>> getClassmates() {
        return api.getClassmates();
    }

    @Override
    public Single<UserContext> getContext() {
        return api.getContext().map(this::inject);
    }

    @Override
    public Single<UserContext> getContextById(long userId) {
        return api.getContextById(userId).map(this::inject);
    }

    @Override
    public Single<EduGroup> getGroupById(long eduGroup) {
        return api.getGroupById(eduGroup).map(this::inject);
    }

    @Override
    public Single<List<StudentsWrapper>> getGroupsWithStudentsByIds(List<Long> groupIds) {
        return api.getGroupsWithStudentsByIds(groupIds).map(this::injectMany);
    }

    @Override
    public Single<List<EduGroup>> getGroupsByPerson(long person) {
        return api.getGroupsByPerson(person).map(this::injectMany);
    }

    @Override
    public Single<List<Person>> getGroupPersons(long group, Boolean archive) {
        return api.getGroupPersons(group, archive).map(this::injectMany);
    }

    @Override
    public Single<List<EduGroup>> getParallelGroups(long groupId) {
        return api.getParallelGroups(groupId).map(this::injectMany);
    }

    @Override
    public Single<List<EduGroup>> getGroupsByTeacher(long teacherId, long schoolId) {
        return api.getGroupsByTeacher(teacherId, schoolId).map(this::injectMany);
    }

    @Override
    public Single<List<PersonFinalMark>> getFinalMarksByGroup(long group) {
        return api.getFinalMarksByGroup(group).map(this::injectMany);
    }

    @Override
    public Single<List<SubjectFinalMark>> getFinalMarksByPerson(long person, long group) {
        return api.getFinalMarksByPerson(person, group).map(this::injectMany);
    }

    @Override
    public Single<FinalMarksResponse> getAllFinalMarksByPerson(long person, long group) {
        return api.getAllFinalMarksByPerson(person, group).map(this::inject);
    }

    @Override
    public Single<List<Mark>> getFinalMarksBySubject(long group, long subject) {
        return api.getFinalMarksBySubject(group, subject).map(this::injectMany);
    }

    @Override
    public Single<List<LessonLogEntry>> getLessonLogEntries(long lesson) {
        return api.getLessonLogEntries(lesson).map(this::injectMany);
    }

    @Override
    public Single<List<LessonLogEntry>> getLessonLogEntriesByGroup(long group, Long subject, LocalDateTime from, LocalDateTime to) {
        return api.getLessonLogEntriesByGroup(group, subject, from, to).map(this::injectMany);
    }

    @Override
    public Single<Lesson> getLessonById(long lesson) {
        return api.getLessonById(lesson).map(this::inject);
    }

    @Override
    public Single<List<Lesson>> getLessons(List<Long> lessonIds) {
        return api.getLessons(lessonIds).map(this::injectMany);
    }

    @Override
    public Single<List<Lesson>> getLessonsByDates(long group, LocalDate from, LocalDate to) {
        return api.getLessonsByDates(group, from, to).map(this::injectMany);
    }

    @Override
    public Single<List<Lesson>> getLessonsByDatesAndSubject(long group, long subject, LocalDate from, LocalDate to) {
        return api.getLessonsByDatesAndSubject(group, subject, from, to).map(this::injectMany);
    }

    @Override
    public Single<Mark> getMarkById(long mark) {
        return api.getMarkById(mark).map(this::inject);
    }

    @Override
    public Single<List<Mark>> getMarksByWork(long work) {
        return api.getMarksByWork(work).map(this::injectMany);
    }

    @Override
    public Single<List<Mark>> getMarksByLesson(long lesson) {
        return api.getMarksByLesson(lesson).map(this::injectMany);
    }

    @Override
    public Single<List<Mark>> getMarksByGroupAndDates(long group, LocalDateTime from, LocalDateTime to) {
        return api.getMarksByGroupAndDates(group, from, to).map(this::injectMany);
    }

    @Override
    public Single<List<Mark>> getMarksBySubjectAndDates(long group, long subject, LocalDate from, LocalDate to) {
        return api.getMarksBySubjectAndDates(group, subject, from, to).map(this::injectMany);
    }

    @Override
    public Single<List<Mark>> getPersonMarksBySchoolAndDates(long person, long school, LocalDate from, LocalDate to) {
        return api.getPersonMarksBySchoolAndDates(person, school, from, to).map(this::injectMany);
    }

    @Override
    public Single<List<Mark>> getPersonMarksByGroupAndDates(long person, long group, LocalDate from, LocalDate to) {
        return api.getPersonMarksByGroupAndDates(person, group, from, to).map(this::injectMany);
    }

    @Override
    public Single<List<Mark>> getPersonMarksByWork(long person, long work) {
        return api.getPersonMarksByWork(person, work).map(this::injectMany);
    }

    @Override
    public Single<List<Mark>> getPersonMarksByLesson(long person, long lesson) {
        return api.getPersonMarksByWork(person, lesson).map(this::injectMany);
    }

    @Override
    public Single<List<Mark>> getPersonMarksBySubjectAndDates(long person, long subject, LocalDate from, LocalDate to) {
        return api.getPersonMarksBySubjectAndDates(person, subject, from, to).map(this::injectMany);
    }

    @Override
    public Single<List<Mark>> getPersonMarksByLessonDate(LocalDate date, long person) {
        return api.getPersonMarksByLessonDate(date, person).map(this::injectMany);
    }

    @Override
    public Single<List<Mark>> getPersonMarksByGradingDate(LocalDate date, long person) {
        return api.getPersonMarksByGradingDate(date, person).map(this::injectMany);
    }

    @Override
    public Single<List<Person>> getPersonsByGroup(long eduGroup) {
        return api.getPersonsByGroup(eduGroup).map(this::injectMany);
    }

    @Override
    public Single<Person> getPersonById(long person) {
        return api.getPersonById(person).map(this::inject);
    }

    @Override
    public Single<RecentMarksResponse> getRecentMarks(long person, long group, LocalDate fromDate, Long subject, Integer limit) {
        return api.getRecentMarks(person, group, fromDate, subject, limit).map(this::inject);
    }

    @Override
    public Single<List<ReportingPeriod>> getReportingPeriods(long eduGroup) {
        return api.getReportingPeriods(eduGroup).map(this::injectMany);
    }

    @Override
    public Single<List<DaySchedule>> getSchedules(long person, long group, LocalDate startDate, LocalDate endDate) {
        return api.getSchedules(person, group, startDate, endDate).map(this::injectMany);
    }

    @Override
    public Single<School> getSchool(long school) {
        return api.getSchool(school).map(this::inject);
    }

    @Override
    public Single<List<School>> getSchools(List<Long> schools) {
        return api.getSchools(schools).map(this::injectMany);
    }

    @Override
    public Single<List<Person>> getSchoolMembership(long school, SchoolMembershipType type) {
        return api.getSchoolMembership(school, type).map(this::injectMany);
    }

    @Override
    public Single<List<Subject>> getSubjectsByGroup(long eduGroup) {
        return api.getSubjectsByGroup(eduGroup).map(this::injectMany);
    }

    @Override
    public Single<List<Subject>> getSubjectsBySchool(long school) {
        return api.getSubjectsBySchool(school).map(this::injectMany);
    }

    @Override
    public Single<Task> getTaskById(long task) {
        return api.getTaskById(task).map(this::inject);
    }

    @Override
    public Single<List<Task>> getTasksByLesson(long lesson) {
        return api.getTasksByLesson(lesson).map(this::injectMany);
    }

    @Override
    public Single<List<Task>> getTasksByWork(long work) {
        return api.getTasksByWork(work).map(this::injectMany);
    }

    @Override
    public Single<List<Task>> getPersonTasks(long person, long subject, LocalDate from, LocalDate to, int pageNumber, int pageSize) {
        return api.getPersonTasks(person, subject, from, to, pageNumber, pageSize).map(this::injectMany);
    }

    @Override
    public Single<List<Task>> getPersonUndoneTasks(long personId) {
        return api.getPersonUndoneTasks(personId).map(this::injectMany);
    }

    @Override
    public Single<List<PersonsWrapper>> getStudentsByTeacher(long teacher) {
        return api.getStudentsByTeacher(teacher).map(this::injectMany);
    }

    @Override
    public Single<List<Teacher>> getTeachersBySchool(long school) {
        return api.getTeachersBySchool(school).map(this::injectMany);
    }

    @Override
    public Single<List<Person>> getTeachersByGroup(long group) {
        return api.getTeachersByGroup(group).map(this::injectMany);
    }

    @Override
    public Single<Person> getClassTeacher(long group) {
        return api.getClassTeacher(group).map(this::inject);
    }

    @Override
    public Single<List<Timetable>> getTimetablesBySchool(long school) {
        return api.getTimetablesBySchool(school);
    }

    @Override
    public Single<List<Timetable>> getTimetablesByGroup(long eduGroup) {
        return api.getTimetablesByGroup(eduGroup);
    }

    @Override
    public Single<UserFeedResponse> getUserFeed(LocalDate fromDate, long person, int daysLimit) {
        return api.getUserFeed(fromDate, person, daysLimit).map(this::inject);
    }

    @Override
    public Single<List<UserRelative>> getUserRelativesById(long user) {
        return api.getUserRelativesById(user).map(this::injectMany);
    }

    @Override
    public Single<List<UserRelative>> getUserRelatives() {
        return api.getUserRelatives().map(this::injectMany);
    }

    @Override
    public Single<User> getUserById(long user) {
        return api.getUserById(user).map(this::inject);
    }

    @Override
    public Single<User> getUser() {
        return api.getUser().map(this::inject);
    }

    @Override
    public Single<List<String>> getUserRolesById(long user) {
        return api.getUserRolesById(user);
    }

    @Override
    public Single<List<String>> getUserRoles() {
        return api.getUserRoles();
    }

    @Override
    public Single<List<User>> getUsers(List<Long> userIds) {
        return api.getUsers(userIds).map(this::injectMany);
    }

    @Override
    public Single<WeightedMarksResponse> getWeightedMarks(long group, LocalDate from, LocalDate to) {
        return api.getWeightedMarks(group, from, to);
    }

    @Override
    public Single<List<Work>> getWorksByLesson(long lesson) {
        return api.getWorksByLesson(lesson).map(this::injectMany);
    }

    @Override
    public Single<Work> getWorkById(long work) {
        return api.getWorkById(work).map(this::inject);
    }

    @Override
    public Single<List<Work>> getWorks(List<Long> workIds) {
        return api.getWorks(workIds).map(this::injectMany);
    }

    @Override
    public Single<List<WorkType>> getWorkTypesBySchool(long school) {
        return api.getWorkTypesBySchool(school);
    }
}

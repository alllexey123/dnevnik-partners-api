package api.dnevnik.partners.model.user;

import api.dnevnik.partners.DnevnikPartnersApi;
import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.IdHolder;
import api.dnevnik.partners.model.mark.*;
import api.dnevnik.partners.model.schedule.DaySchedule;
import api.dnevnik.partners.model.schedule.Timetable;
import api.dnevnik.partners.model.work.Subject;
import com.google.gson.annotations.SerializedName;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
public class EduGroup implements ApiHolder, IdHolder {

    @ToString.Exclude @EqualsAndHashCode.Exclude
    private DnevnikPartnersApi api;

    private Long id;

    @SerializedName("id_str")
    private String idStr;

    private List<Long> parentIds;

    @SerializedName("parentIds_str")
    private List<String> parentIdsStr;

    private GroupType type;

    private String name;

    private String fullName;

    private int parallel;

    private long timetable;

    @SerializedName("timetable_str")
    private String timetableStr;

    private String status;

    @SerializedName("studyyear")
    private int studyYear;

    private List<Subject> subjects;

    private String journalType;

    public void setApi(DnevnikPartnersApi api) {
        this.api = api;
        api.injectMany(subjects);
    }

    // preferred
    public long getParsedId() {
        return Long.parseLong(idStr);
    }

    /**
     * @return true if a group has parents (it is a subgroup), false otherwise
     */
    public boolean hasParentIds() {
        return this.parentIds != null && !this.parentIds.isEmpty();
    }

    public Flowable<Person> getPersons() {
        return api.getGroupPersons(getParsedId(), false).flattenAsFlowable(personList -> personList);
    }

    public Flowable<Person> getArchivedPersons() {
        return api.getGroupPersons(getParsedId(), true).flattenAsFlowable(personList -> personList);
    }

    public Flowable<EduGroup> getParallelGroups() {
        return api.getParallelGroups(getParsedId()).flattenAsFlowable(eduGroups -> eduGroups);
    }

    public Flowable<PersonFinalMark> getFinalMarks() {
        return api.getFinalMarksByGroup(getParsedId()).flattenAsFlowable(personFinalMarks -> personFinalMarks);
    }

    public Flowable<AverageMark> getAverageMarksTillDate(long periodId, LocalDate date) {
        return api.getAverageMarksTillDate(getParsedId(), periodId, date).flattenAsFlowable(averageMarks -> averageMarks);
    }

    public Flowable<TinyAverageMark> getAverageMarksByPeriod(LocalDate from, LocalDate to) {
        return api.getAverageMarksByPeriod(getParsedId(), from, to).flattenAsFlowable(tinyAverageMarks -> tinyAverageMarks);
    }

    public Flowable<SubjectFinalMark> getPersonFinalMarks(long person) {
        return api.getFinalMarksByPerson(person, getParsedId()).flattenAsFlowable(subjectFinalMarks -> subjectFinalMarks);
    }

    public Single<FinalMarksResponse> getAllPersonFinalMarks(long person) {
        return api.getAllFinalMarksByPerson(person, getParsedId());
    }

    public Flowable<Mark> getFinalMarksBySubject(long subject) {
        return api.getFinalMarksBySubject(getParsedId(), subject).flattenAsFlowable(finalMarks -> finalMarks);
    }

    public Flowable<Mark> getMarksByDates(LocalDate from, LocalDate to) {
        return api.getMarksByGroupAndDates(getParsedId(), from, to).flattenAsFlowable(marks -> marks);
    }

    public Flowable<Mark> getMarksBySubjectAndDates(long subject, LocalDate from, LocalDate to) {
        return api.getMarksBySubjectAndDates(getParsedId(), subject, from, to).flattenAsFlowable(marks -> marks);
    }

    public Flowable<Mark> getPersonMarksByDates(long person, LocalDate from, LocalDate to) {
        return api.getPersonMarksByGroupAndDates(person, getParsedId(), from, to).flattenAsFlowable(marks -> marks);
    }

    public Single<RecentMarksResponse> getRecentMarks(long person, LocalDate from, Long subject, Integer limit) {
        return api.getRecentMarks(person, getParsedId(), from, subject, limit);
    }

    public Flowable<ReportingPeriod> getReportingPeriods() {
        return api.getReportingPeriods(getParsedId()).flattenAsFlowable(reportingPeriods -> reportingPeriods);
    }

    public Flowable<DaySchedule> getSchedules(long person, LocalDate startDate, LocalDate endDate) {
        return api.getSchedules(person, getParsedId(), startDate, endDate).flattenAsFlowable(schedules -> schedules);
    }

    public Flowable<Subject> getSubjects() {
        return api.getSubjectsByGroup(getParsedId()).flattenAsFlowable(subjects -> subjects);
    }

    public Flowable<Person> getTeachers() {
        return api.getTeachersByGroup(getParsedId()).flattenAsFlowable(personList -> personList);
    }

    public Single<Person> getClassTeacher() {
        return api.getClassTeacher(getParsedId());
    }

    public Flowable<Timetable> getTimetables() {
        return api.getTimetablesByGroup(getParsedId()).flattenAsFlowable(timetables -> timetables);
    }

    public Single<WeightedMarksResponse> getWeightedMarks(LocalDate from, LocalDate to) {
        return api.getWeightedMarks(getParsedId(), from, to);
    }

}

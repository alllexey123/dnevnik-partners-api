package api.dnevnik.partners;

import api.dnevnik.partners.model.ApiHolder;
import api.dnevnik.partners.model.feed.UserFeedResponse;
import api.dnevnik.partners.model.mark.*;
import api.dnevnik.partners.model.mark.FinalMarksResponse;
import api.dnevnik.partners.model.mark.RecentMarksResponse;
import api.dnevnik.partners.model.schedule.DaySchedule;
import api.dnevnik.partners.model.schedule.Timetable;
import api.dnevnik.partners.model.user.*;
import api.dnevnik.partners.model.work.*;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @see <a href="https://api.dnevnik.ru/partners/swagger/ui/index/index.html">Dnevnik Ru Partners API</a>
 */
public interface DnevnikPartnersApi {

    //region Injection
    default <T extends ApiHolder> T inject(T t) {
        if (t != null) t.setApi(this);
        return t;
    }

    default <T extends ApiHolder> List<T> injectMany(List<T> tList) {
        if (tList != null) tList.forEach(t -> t.setApi(this));
        return tList;
    }
    //endregion Injection

    //region Average Marks
    @GET("/v2/persons/{person}/reporting-periods/{period}/avg-mark")
    Single<String> getAverageMarksByPeriod(@Path("person") long person, @Path("period") long period);

    @GET("/v2/persons/{person}/reporting-periods/{period}/subjects/{subject}/avg-mark")
    Single<String> getAverageMarkBySubject(@Path("person") long person, @Path("period") long period, @Path("subject") long subject);

    @GET("/v2/edu-groups/{group}/reporting-periods/{period}/avg-marks/{date}")
    Single<List<AverageMark>> getAverageMarksTillDate(@Path("group") long group, @Path("period") long period, @Path("date") LocalDate date);

    @GET("/v2/edu-groups/{group}/avg-marks/{from}/{to}")
    Single<List<TinyAverageMark>> getAverageMarksByPeriod(@Path("group") long group, @Path("from") LocalDate from, @Path("to") LocalDate to);
    //endregion Average Marks

    //region Classmates
    @GET("/v2/users/me/classmates")
    Single<List<Long>> getClassmates();
    //endregion Classmates

    //region Context
    @GET("/v2/users/me/context")
    Single<UserContext> getContext();

    @GET("/v2/users/{userId}/context")
    Single<UserContext> getContextById(@Path("userId") long userId);
    //endregion Context

    //region Edu Groups
    @GET("/v2/edu-groups/{eduGroup}")
    Single<EduGroup> getGroupById(@Path("eduGroup") long eduGroup);

    @POST("/v2/edu-groups")
    Single<List<StudentsWrapper>> getGroupsWithStudentsByIds(@Body List<Long> groupIds);

    @GET("/v2/persons/{person}/edu-groups")
    Single<List<EduGroup>> getGroupsByPerson(@Path("person") long person);

    @GET("/v2/edu-groups/{group}/persons")
    Single<List<Person>> getGroupPersons(@Path("group") long group, @Query("includeArchive") Boolean includeArchive);

    @GET("/v2/edu-groups/{groupId}/parallel")
    Single<List<EduGroup>> getParallelGroups(@Path("groupId") long groupId);

    @GET("/v2/persons/{person}/schools/{school}/edu-groups/teacher")
    Single<List<EduGroup>> getGroupsByTeacher(@Path("person") long teacherId, @Path("school") long schoolId);
    //endregion Edu Groups

    //region Final Marks
    @GET("/v2/edu-groups/{group}/final-marks")
    Single<List<PersonFinalMark>> getFinalMarksByGroup(@Path("group") long group);

    @GET("/v2/persons/{person}/edu-groups/{group}/final-marks")
    Single<List<SubjectFinalMark>> getFinalMarksByPerson(@Path("person") long person, @Path("group") long group);

    @GET("/v2/persons/{person}/edu-groups/{group}/allfinalmarks")
    Single<FinalMarksResponse> getAllFinalMarksByPerson(@Path("person") long person, @Path("group") long group);

    @GET("/v2/edu-groups/{group}/subjects/{subject}/final-marks")
    Single<List<Mark>> getFinalMarksBySubject(@Path("group") long group, @Path("subject") long subject);
    //endregion Final Marks

    //region Lessons
    @GET("/v2/lessons/{lesson}")
    Single<Lesson> getLessonById(@Path("lesson") long lesson);

    @GET("/v2/edu-groups/{group}/lessons/{from}/{to}")
    Single<List<Lesson>> getLessonsByDates(@Path("group") long group, @Path("from") LocalDate from, @Path("to") LocalDate to);

    @GET("/v2/edu-groups/{group}/subjects/{subject}/lessons/{from}/{to}")
    Single<List<Lesson>> getLessonsByDatesAndSubject(@Path("group") long group, @Path("subject") long subject, @Path("from") LocalDate from, @Path("to") LocalDate to);
    //endregion Lessons

    //region Marks
    @GET("/v2/marks/{mark}")
    Single<Mark> getMarkById(@Path("mark") long mark);

    @GET("/v2/works/{work}/marks")
    Single<List<Mark>> getMarksByWork(@Path("work") long work);

    @GET("/v2/lessons/{lesson}/marks")
    Single<List<Mark>> getMarksByLesson(@Path("lesson") long lesson);

    @GET("/v2/edu-groups/{group}/marks/{from}/{to}")
    Single<List<Mark>> getMarksByGroupAndDates(@Path("group") long group, @Path("from") LocalDate from, @Path("to") LocalDate to);

    @GET("/v2/edu-groups/{group}/subjects/{subject}/marks/{from}/{to}")
    Single<List<Mark>> getMarksBySubjectAndDates(@Path("group") long group, @Path("subject") long subject, @Path("from") LocalDate from, @Path("to") LocalDate to);
    //endregion Marks

    //region Person Marks
    @GET("/v2/persons/{person}/schools/{school}/marks/{from}/{to}")
    Single<List<Mark>> getPersonMarksBySchoolAndDates(@Path("person") long person, @Path("school") long school, @Path("from") LocalDate from, @Path("to") LocalDate to);

    @GET("/v2/persons/{person}/edu-groups/{group}/marks/{from}/{to}")
    Single<List<Mark>> getPersonMarksByGroupAndDates(@Path("person") long person, @Path("group") long group, @Path("from") LocalDate from, @Path("to") LocalDate to);

    @GET("/v2/persons/{person}/works/{work}/marks")
    Single<List<Mark>> getPersonMarksByWork(@Path("person") long person, @Path("work") long work);

    @GET("/v2/persons/{person}/lessons/{lesson}/marks")
    Single<List<Mark>> getPersonMarksByLesson(@Path("person") long person, @Path("lesson") long lesson);

    @GET("/v2/persons/{person}/subjects/{subject}/marks/{from}/{to}")
    Single<List<Mark>> getPersonMarksBySubjectAndDates(@Path("person") long person, @Path("subject") long subject, @Path("from") LocalDate from, @Path("to") LocalDate to);

    @GET("/v2/lessons/{date}/persons/{person}/marks")
    Single<List<Mark>> getPersonMarksByLessonDate(@Path("date") LocalDate date, @Path("person") long person);

    // по дате выставления оценки
    @GET("/v2/lessons/{date}/persons/{person}/marks")
    Single<List<Mark>> getPersonMarksByGradingDate(@Path("date") LocalDate date, @Path("person") long person);
    //endregion Person Marks

    //region Persons

    /**
     * {@link #getGroupPersons(long, Boolean)} is preferred
     */
    @GET("/v2/edu-groups/{eduGroup}/students")
    Single<List<Person>> getPersonsByGroup(@Path("eduGroup") long eduGroup);

    @GET("/v2/persons/{person}")
    Single<Person> getPersonById(@Path("person") long person);
    //endregion Persons

    //region Recent Marks
    @GET("/v2/persons/{person}/group/{group}/recentmarks")
    Single<RecentMarksResponse> getRecentMarks(@Path("person") long person, @Path("group") long group,
                                               @Query("fromDate") LocalDate fromDate, @Query("subject") Long subject, @Query("limit") Integer limit);
    //endregion Recent Marks

    //region Reporting Periods
    @GET("/v2/edu-groups/{eduGroup}/reporting-periods")
    Single<List<ReportingPeriod>> getReportingPeriods(@Path("eduGroup") long eduGroup);
    //endregion Reporting Periods

    //region Schedules
    @GET("/v2/persons/{person}/groups/{group}/schedules")
    Single<List<DaySchedule>> getSchedules(@Path("person") long person, @Path("group") long group, @Query("startDate") LocalDate startDate, @Query("endDate") LocalDate endDate);
    //endregion

    //region School
    @GET("/v2/schools/{school}")
    Single<School> getSchool(@Path("school") long school);

    @GET("/v2/schools")
    Single<List<School>> getSchools(@Query("schools") List<Integer> schools);

    @GET("/v2/schools/{school}/membership")
    Single<List<Person>> getSchoolMembership(@Path("school") long school, @Query("schoolMembershipType") SchoolMembershipType type);
    //endregion School

    //region Subjects
    @GET("/v2/edu-groups/{eduGroup}/subjects")
    Single<List<Subject>> getSubjectsByGroup(@Path("eduGroup") long eduGroup);

    @GET("/v2/schools/{school}/subjects")
    Single<List<Subject>> getSubjectsBySchool(@Path("school") long school);
    //endregion Subjects

    //region Tasks
    @GET("/v2/tasks/{task}")
    Single<Task> getTaskById(@Path("task") long task);

    @GET("/v2/lessons/{lesson}/tasks")
    Single<List<Task>> getTasksByLesson(@Path("lesson") long lesson);

    @GET("/v2/works/{work}/tasks")
    Single<List<Task>> getTasksByWork(@Path("work") long work);
    //endregion Tasks

    //region Person Tasks
    @GET("/v2/persons/{person}/tasks")
    Single<List<Task>> getPersonTasks(@Path("person") long person, @Query("subject") long subject, @Query("from") LocalDate from, @Query("to") LocalDate to,
                                      @Query("pageNumber") int pageNumber, @Query("pageSize") int pageSize);

    @GET("/v2/tasks/{personId}/undone")
    Single<List<Task>> getPersonUndoneTasks(@Path("personId") long personId);
    //endregion Person Tasks

    //region Teachers
    @GET("/v2/teacher/{teacher}/students")
    Single<List<PersonsWrapper>> getStudentsByTeacher(@Path("teacher") long teacher);

    @GET("/v2/schools/{school}/teachers")
    Single<List<Teacher>> getTeachersBySchool(@Path("school") long school);

    @GET("/v2/edu-groups/{group}/teachers")
    Single<List<Person>> getTeachersByGroup(@Path("group") long group);

    @GET("/v2/edu-groups/{group}/classteacher")
    Single<Person> getClassTeacher(@Path("group") long group);
    //endregion Teachers

    //region Timetables
    @GET("/v2/schools/{school}/timetables")
    Single<List<Timetable>> getTimetablesBySchool(@Path("school") long school);

    @GET("/v2/edu-groups/{eduGroup}/timetables")
    Single<List<Timetable>> getTimetablesByGroup(@Path("eduGroup") long eduGroup);
    //endregion Timetables

    //region User Feed
    @GET("/v2/users/me/feed")
    Single<UserFeedResponse> getUserFeed(@Query("date") LocalDate fromDate, @Query("childPersonId") long person, @Query("limit") int daysLimit);
    //endregion User Feed

    //region User Relatives
    @GET("/v2/users/{user}/relatives")
    Single<List<UserRelative>> getUserRelativesById(@Path("user") long user);

    @GET("/v2/users/me/relatives")
    Single<List<UserRelative>> getUserRelatives();
    //endregion User Relatives

    //region User
    @GET("/v2/users/{user}")
    Single<User> getUserById(@Path("user") long user);

    @GET("/v2/users/me")
    Single<User> getUser();

    @GET("/v2/users/{user}/roles")
    Single<List<String>> getUserRolesById(@Path("user") long user);

    @GET("/v2/users/me/roles")
    Single<List<String>> getUserRoles();
    //endregion User

    //region Weighted Average Marks
    @GET("/v2/edu-groups/{group}/wa-marks/{from}/{to}")
    Single<WeightedMarksResponse> getWeightedMarks(@Path("group") long group, @Path("from") LocalDate from, @Path("to") LocalDate to);
    //endregion Weighted Average Marks

    //region Works
    @GET("/v2/works")
    Single<List<Work>> getWorksByLesson(@Query("lesson") long lesson);

    @GET("/v2/works/{work}")
    Single<Work> getWorkById(@Path("work") long work);
    //endregion Works

    //region Work Types
    @GET("/v2/work-types/{school}")
    Single<List<WorkType>> getWorkTypesBySchool(@Path("school") long school);

    //endregion Work Types
}
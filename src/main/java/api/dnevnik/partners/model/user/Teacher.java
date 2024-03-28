package api.dnevnik.partners.model.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Teacher {

    private long Id;

    private String IdStr;

    private long UserId;

    private String UserIdStr;

    private String FirstName;

    private String LastName;

    private String MiddleName;

    private String ShortName;

    private String Sex;

    private LocalDateTime DateBirth;

    private String Email;

    private String Subjects;

    private boolean HouseMaster;

    private String Education;

    private String scientificDegree;

    private LocalDateTime StartDate;

    private LocalDateTime PedagogicalActivityDate;

    private boolean ManagingEmployee;

    private String NameManagingPosition;

    private boolean TeachingStaff;

    private String NameTeacherPosition;

    private boolean TrainingAndSupportStaff;

    private boolean ServicePersonnel;

    private boolean MedicalWorker;

    private String NameMedicalPosition;

    private boolean ExternalPartTime;
}

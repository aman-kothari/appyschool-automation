package com.appyschool.common;

public interface GenericConstants {

	String CONTENT_TYPE_JSON = "application/json";
	
	
	// Config Protperties
	String BASE_URL = "base.url";
	String COOKIE = "cookie";
	
	//URL - Configuration Module
	String CONFIGURATION_BRANCH = "configuration.branch";
	String CONFIGURATION_SUBJECTS = "configuration.subjects";
	String CONFIGURATION_STANDARDS = "configuration.standards";
	String CONFIGURATION_STANDARDS_LEVELS = "configuration.standards.levels";
	String CONFIGURATION_SECTIONS = "configuration.sections";
	String CONFIGURATION_STUDENTFILTER = "configuration.studentFilter";
	String CONFIGURATION_BRANCH_STANDARD_SECTION = "configuration.branchStandardSection";
	String CONFIGURATION_EXAMS = "configuration.exams";
	String CONFIGURATION_EXAMS_SUBJECTS = "configuration.examsSubjects";
	String CONFIGURATION_GRADES = "configuration.grades";
	String CONFIGURATION_WEEKLY_TRACKER_SKILLS= "configuration.weeklytrackerskills";
	String CONFIGURATION_ACADEMICYEAR = "configuration.academicYear";
	String CONFIGURATION_CO_SCHOLASTICAREAS = "configuration.coscholasticareas";
	String CONFIGURATION_CO_CURRICULARAREAS = "configuration.cocurricularactivities";
	String BANNER_IMAGER_URL="bannerImage.url";
	
	// URL - Students
	String STUDENT_URL = "Student.url";
	
	
	//Students
	String STUDENTS_URI_PATH = "";
	String STAFF_URI_PATH = "";

	
	//Payloads - Configuration Module
	String BRANCH_CREATE_PAYLOAD = "Branch.Create";
	String SUBJECT_CREATE_PAYLOAD = "Subject.Create";
	String STANDARDS_CREATE_PAYLOAD = "Standards.Create";
	String SECTION_CREATE_PAYLOAD = "Sections.Create";
	String EXAMS_CREATE_PAYLOAD = "Exams.Create";
	String GRADES_CREATE_PAYLOAD = "Grades.Create";
	String WEEKLY_TRACKER_PAYLOAD = "WeeklyTracker.Create";
	String ACADEMIC_YEAR_PAYLOAD = "AcademicYear.Create";
	String CO_SCHOLASTICAREAS_PAYLOAD = "Co.ScholasticAreas.Create";
	String CO_CURRICULARAREAS_PAYLOAD = "Co.CurricularAreas.Create";
	
	//Payloads - Students
	String STUDENT_CREATE_PAYLOAD = "Student.Create";
}
-- 1) Base lookups
-- Country -> Place(country_id) -> Address(place_id)
INSERT INTO country (id, name) VALUES (1, 'Serbia');
INSERT INTO country (id, name) VALUES (2, 'Norway');
INSERT INTO country (id, name) VALUES (3, 'Germany');

INSERT INTO place (id, name, country_id) VALUES (1, 'Novi Sad', 1);
INSERT INTO place (id, name, country_id) VALUES (2, 'Belgrade', 1);
INSERT INTO place (id, name, country_id) VALUES (3, 'Oslo', 2);
INSERT INTO place (id, name, country_id) VALUES (4, 'Berlin', 3);

INSERT INTO address (id, street, number, place_id) VALUES (1, 'Main Street', 10, 1);
INSERT INTO address (id, street, number, place_id) VALUES (2, 'Knez Mihailova', 5, 2);
INSERT INTO address (id, street, number, place_id) VALUES (3, 'Karl Johans gate', 15, 3);
INSERT INTO address (id, street, number, place_id) VALUES (4, 'Unter den Linden', 100, 4);

-- 2) Users (referenced by University, Faculty, Student*, ProfessorCourse, ExamApplication)
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (1, 'student1', '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'student1@example.com', '0101996712345', 'Ana',   'Jovanović', 'Undergraduate student.', 'STUDENT');

INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (2, 'prof1',    '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'prof1@example.com',    '0202998812345', 'Marko', 'Marković',  'Professor of Computer Science.', 'PROFESSOR');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (5, 'prof123',    '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'prof2@example.com',    '0202998812345', 'Marko', 'Marković',  'Professor of Computer Science.', 'PROFESSOR');

INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (3, 'rector',   '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'rector@example.com',   '0303997712345', 'Ivana', 'Petrović',  'University rector.', 'PROFESSOR');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (4, 'rector1',   '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'rector1@example.com',   '0303997712345', 'Iva', 'Petrić',  'University rector.', 'PROFESSOR');


-- 3) University (needs address_id + rector_id)
INSERT INTO university (id, name, address_id, rector_id, contact, description) VALUES (1, 'University of Novi Sad', 1, 3, '+381 21 123 456', 'Public university in Novi Sad.');

INSERT INTO university (id, name, address_id, rector_id, contact, description) VALUES (2, 'University of Belgrade', 2, 4, '+381 11 987 654', 'Public university in Belgrade.');

-- 4) Faculty (needs university_id + address_id + dean_id)
INSERT INTO faculty (id, name, university_id, address_id, dean_id, contact, description) VALUES (1, 'Faculty of Science',     1, 1, 2, '+381 21 123 456', 'Science faculty.');

INSERT INTO faculty (id, name, university_id, address_id, dean_id, contact, description) VALUES (2, 'Faculty of Engineering', 1, 2, 3, '+381 11 987 654', 'Engineering faculty.');

-- 5) StudyProgram (needs faculty_id + manager_id)
INSERT INTO study_program (id, name, faculty_id, description, manager_id) VALUES (1, 'Computer Science',    1, 'Study program focused on CS fundamentals.', 2);

INSERT INTO study_program (id, name, faculty_id, description, manager_id) VALUES (2, 'Software Engineering', 1, 'Program focused on software development.',  5);


-- 6) Course (no FK out to others)
INSERT INTO course (id, name, espb_points, mandatory, number_of_lectures, number_of_exercises, other_forms_of_teaching, research_work, other_classes, teaching_materials) VALUES (1, 'Mathematics 1', 8, 1, 30, 30, 0, 0, 0, 'Lecture notes, problem sets');
INSERT INTO course (id, name, espb_points, mandatory, number_of_lectures, number_of_exercises, other_forms_of_teaching, research_work, other_classes, teaching_materials) VALUES (2, 'Programming 1', 7, 1, 30, 45, 5, 0, 0, 'Java book, online resources');
INSERT INTO course (id, name, espb_points, mandatory, number_of_lectures, number_of_exercises, other_forms_of_teaching, research_work, other_classes, teaching_materials) VALUES (3, 'Databases', 6, 0, 30, 30, 0, 5, 0, 'SQL scripts, slides');

-- 7) Syllabus (needs course_id)
INSERT INTO syllabus (id, description, course_id) VALUES (1, 'Syllabus for Mathematics 1', 1);
INSERT INTO syllabus (id, description, course_id) VALUES (2, 'Syllabus for Programming 1', 2);
INSERT INTO syllabus (id, description, course_id) VALUES (3, 'Syllabus for Databases', 3);

-- 8) EvaluationInstrument (needs course_id) – names are strings
INSERT INTO evaluation_instrument (id, points, name, course_id) VALUES (1, 50, 'Midterm', 1);
INSERT INTO evaluation_instrument (id, points, name, course_id) VALUES (2, 50, 'Final', 1);
INSERT INTO evaluation_instrument (id, points, name, course_id) VALUES (3, 40, 'Midterm', 2);
INSERT INTO evaluation_instrument (id, points, name, course_id) VALUES (4, 60, 'Final', 2);
INSERT INTO evaluation_instrument (id, points, name, course_id) VALUES (5, 30, 'Project', 3);
INSERT INTO evaluation_instrument (id, points, name, course_id) VALUES (6, 70, 'Exam', 3);

-- 9) CourseNotification (needs course_id)
INSERT INTO course_notification (id, title, content, course_id, posted_at) VALUES (1, 'Welcome', 'Course starts next week.', 1, '2025-02-02 10:00:00');
INSERT INTO course_notification (id, title, content, course_id, posted_at) VALUES (2, 'Lab schedule', 'Labs are on Wednesdays.', 2, '2025-02-02 10:00:00');
INSERT INTO course_notification (id, title, content, course_id, posted_at) VALUES (3, 'Exam info', 'Final exam on 20-Dec.', 3, '2025-02-02 10:00:00');

-- 10) CourseOnProgram (needs study_program_id + course_id)
INSERT INTO course_on_program (id, study_program_id, course_id, year) VALUES (1, 1, 1, 1);
INSERT INTO course_on_program (id, study_program_id, course_id, year) VALUES (2, 1, 2, 1);
INSERT INTO course_on_program (id, study_program_id, course_id, year) VALUES (3, 1, 3, 2);

-- 11) ProfessorCourse (needs course_id + professor_id)
INSERT INTO professor_course (id, course_id, professor_id) VALUES (1, 1, 2);
INSERT INTO professor_course (id, course_id, professor_id) VALUES (2, 2, 2);
INSERT INTO professor_course (id, course_id, professor_id) VALUES (3, 3, 3);

-- 12) StudentOnYear (needs student_id + study_program_id)
INSERT INTO student_on_year (id, student_id, date_of_enrollment, index_number, year, study_program_id) VALUES (1, 1, 2023, 1234, 1, 1);

-- 13) StudentCourse (needs student_id + course_id)
INSERT INTO student_course (id, student_id, course_id, status, grade, points, numer_of_exam_applications) VALUES (1, 1, 1, 'ENROLLED', NULL, 0, 0);
INSERT INTO student_course (id, student_id, course_id, status, grade, points, numer_of_exam_applications) VALUES (2, 1, 2, 'PASSED', 10, 95, 2);
INSERT INTO student_course (id, student_id, course_id, status, grade, points, numer_of_exam_applications) VALUES (3, 1, 3, 'ENROLLED', NULL, 0, 0);

-- 14) ExamApplication (needs student_id + course_id; enum must match your values)
INSERT INTO exam_application (id, student_id, course_id, status, points) VALUES (1, 1, 1, 'APPLIED', 0);
INSERT INTO exam_application (id, student_id, course_id, status, points) VALUES (2, 1, 2, 'PASSED', 95);

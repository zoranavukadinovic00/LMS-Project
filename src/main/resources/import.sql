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
INSERT INTO address (id, street, number, place_id) VALUES (5, 'Centar ', 110, 4);

-- 2) Users (referenced by University, Faculty, Student*, ProfessorCourse, ExamApplication)
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (1, 'student1', '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'student1@example.com', '0101996712345', 'Ana',   'Jovanović', 'Undergraduate student.', 'STUDENT');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (6,  'student6', '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'student6@example.com',  '0606996712350', 'Stefan',   'Kovačević',  'Student informatičkih sistema; interesovanja: Java, Spring i baze podataka.', 'STUDENT');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (7,  'student7', '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'student7@example.com',  '0707996712351', 'Ivana',    'Nikolić',    'Studentkinja sestrinstva; voli rad sa pacijentima i volontira u udruženjima.', 'STUDENT');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (8,  'student8', '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'student8@example.com',  '0808996712352', 'Luka',     'Savić',      'Student ekonomije; fokus na finansijsku analitiku i Excel modelovanje.', 'STUDENT');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (9,  'student9', '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'student9@example.com',  '0909996712353', 'Teodora',  'Đorđević',   'Studentkinja menadžmenta; član marketing tima studentskog udruženja.', 'STUDENT');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (10, 'student10', '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'student10@example.com', '1010996712354', 'Petar',    'Pavlović',   'Student softverskog inženjerstva; radi na open-source projektima.', 'STUDENT');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (11, 'student11', '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'student11@example.com', '1111996712355', 'Marija',   'Janković',   'Studentkinja psihologije; interesovanja: razvojna psihologija i istraživanja.', 'STUDENT');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (12, 'student12', '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'student12@example.com', '1212996712356', 'Nemanja',  'Vuković',    'Student elektrotehnike; hobi: IoT projekti i Arduino prototipovi.', 'STUDENT');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (13, 'student13', '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'student13@example.com', '1301996712357', 'Katarina', 'Arsić',      'Studentkinja dizajna; bavi se UX/UI i ilustracijom u slobodno vreme.', 'STUDENT');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (14, 'student14', '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'student14@example.com', '1402996712358', 'Vladimir', 'Radovanović','Student mašinstva; učestvuje u formula student timu kao konstruktor.', 'STUDENT');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (15, 'student15', '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'student15@example.com', '1503996712359', 'Sara',     'Maksimović', 'Studentkinja biologije; interesuje je mikrobiologija i laboratorijski rad.', 'STUDENT');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (16, 'student16', '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'student16@example.com', '1604996712360', 'Uroš',     'Blagojević', 'Student matematike; takmičar u statistici i primenjenoj analizi podataka.', 'STUDENT');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (17, 'student17', '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'student17@example.com', '1705996712361', 'Mina',     'Todorović',  'Studentkinja prava; aktivna u debatnom klubu i studentskom parlamentu.', 'STUDENT');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (2, 'prof1',    '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'prof1@example.com',    '0202998812345', 'Marko', 'Marković',  'Professor of Computer Science.', 'PROFESSOR');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (5, 'prof123',    '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'prof2@example.com',    '0202998812345', 'Marko', 'Marković',  'Professor of Computer Science.', 'PROFESSOR');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (3, 'rector',   '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'rector@example.com',   '0303997712345', 'Ivana', 'Petrović',  'University rector.', 'PROFESSOR');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (4, 'rector1',   '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'rector1@example.com',   '0303997712345', 'Iva', 'Petrić',  'University rector.', 'PROFESSOR');
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (18, 'rector12',   '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'rector1@example.com',   '0303997712345', 'Ivan', 'Petrić',  'University rector.', 'PROFESSOR');
-- Administrator
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (19, 'admin1', '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'admin@example.com', '0101990123456', 'Petar', 'Petrovic', 'Administrator za upravljanje korisnicima.', 'ADMIN');
-- ✨ Dodato: Novi korisnik sa ulogom STAFF
INSERT INTO USERS (id, username, password, email, jmbg, name, surname, biography, type) VALUES (20, 'staff1', '$2a$10$Uy4ar5wdEOIA7QTWYvYoE.8sbKaNAGETFX/Tcz8NEuZn9nTNDIvRy', 'staff1@example.com', '2005995712370', 'Nikola', 'Janković', 'Osoblje studentske službe.', 'STAFF');


-- 3) University (needs address_id + rector_id)
INSERT INTO university (id, name, address_id, rector_id, contact, description, date_of_establishment) VALUES (1, 'University of Novi Sad', 1, 3, '+381 21 123 456', 'Public university in Novi Sad.', '2025-02-02');
INSERT INTO university (id, name, address_id, rector_id, contact, description, date_of_establishment) VALUES (2, 'University of Belgrade', 2, 4, '+381 11 987 654', 'Public university in Belgrade.', '2025-02-02');

-- 4) Faculty (needs university_id + address_id + dean_id)
INSERT INTO faculty (id, name, university_id, address_id, dean_id, contact, description) VALUES (1, 'Faculty of Science', 1, 1, 2, '+381 21 123 456', 'Science faculty.');
INSERT INTO faculty (id, name, university_id, address_id, dean_id, contact, description) VALUES (2, 'Faculty of Engineering', 1, 2, 3, '+381 11 987 654', 'Engineering faculty.');
INSERT INTO faculty (id, name, university_id, address_id, dean_id, contact, description) VALUES (3, 'Faculty of Psychology', 1, 5, 18, '+381 11 987 654', 'Engineering faculty.');

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

-- 12) StudentOnYear (needs student_id + study_program_id)
INSERT INTO student_on_year (id, student_id, date_of_enrollment, index_number, year, study_program_id, stud_index, average_grade) VALUES (1, 1, 2023, 1234, 1, 1, '2023/1234', 7.00);
-- studenti 6–11: upis 2023, godina studija 2
INSERT INTO student_on_year (id, student_id, date_of_enrollment, index_number, year, study_program_id, stud_index, average_grade) VALUES (2,  6,  2023, 1235, 2, 1, '2023/1235', 8.20);
INSERT INTO student_on_year (id, student_id, date_of_enrollment, index_number, year, study_program_id, stud_index, average_grade) VALUES (3,  7,  2023, 1236, 2, 1, '2023/1236', 7.75);
INSERT INTO student_on_year (id, student_id, date_of_enrollment, index_number, year, study_program_id, stud_index, average_grade) VALUES (4,  8,  2023, 1237, 2, 1, '2023/1237', 9.10);
INSERT INTO student_on_year (id, student_id, date_of_enrollment, index_number, year, study_program_id, stud_index, average_grade) VALUES (5,  9,  2023, 1238, 2, 1, '2023/1238', 6.50);
INSERT INTO student_on_year (id, student_id, date_of_enrollment, index_number, year, study_program_id, stud_index, average_grade) VALUES (6,  10, 2023, 1239, 2, 1, '2023/1239', 8.90);
INSERT INTO student_on_year (id, student_id, date_of_enrollment, index_number, year, study_program_id, stud_index, average_grade) VALUES (7,  11, 2023, 1240, 2, 1, '2023/1240', 7.10);

-- studenti 12–17: upis 2024, godina studija 1
INSERT INTO student_on_year (id, student_id, date_of_enrollment, index_number, year, study_program_id, stud_index, average_grade) VALUES (8,  12, 2024, 1241, 1, 1, '2024/1241', 9.50);
INSERT INTO student_on_year (id, student_id, date_of_enrollment, index_number, year, study_program_id, stud_index, average_grade) VALUES (9,  13, 2024, 1242, 1, 1, '2024/1242', 8.00);
INSERT INTO student_on_year (id, student_id, date_of_enrollment, index_number, year, study_program_id, stud_index, average_grade) VALUES (10, 14, 2024, 1243, 1, 1, '2024/1243', 7.40);
INSERT INTO student_on_year (id, student_id, date_of_enrollment, index_number, year, study_program_id, stud_index, average_grade) VALUES (11, 15, 2024, 1244, 1, 1, '2024/1244', 8.60);
INSERT INTO student_on_year (id, student_id, date_of_enrollment, index_number, year, study_program_id, stud_index, average_grade) VALUES (12, 16, 2024, 1245, 1, 1, '2024/1245', 9.00);
INSERT INTO student_on_year (id, student_id, date_of_enrollment, index_number, year, study_program_id, stud_index, average_grade) VALUES (13, 17, 2024, 1246, 1, 1, '2024/1246', 7.85);

-- 11) ProfessorCourse (needs course_id + professor_id)
INSERT INTO professor_course (id, course_id, professor_id) VALUES (1, 1, 2);
INSERT INTO professor_course (id, course_id, professor_id) VALUES (2, 2, 2);
INSERT INTO professor_course (id, course_id, professor_id) VALUES (3, 3, 3);


-- 13) StudentCourse (needs student_id + course_id)
INSERT INTO student_course (id, student_id, course_id, status, grade, points, numer_of_exam_applications) VALUES (1, 1, 1, 'ENROLLED', NULL, 0, 0);
INSERT INTO student_course (id, student_id, course_id, status, grade, points, numer_of_exam_applications) VALUES (2, 1, 2, 'PASSED', 10, 95, 2);
INSERT INTO student_course (id, student_id, course_id, status, grade, points, numer_of_exam_applications) VALUES (3, 1, 3, 'ENROLLED', NULL, 0, 0);

-- 14) ExamApplication (needs student_id + course_id; enum must match your values)
INSERT INTO exam_application (id, student_id, course_id, status, points) VALUES (1, 1, 1, 'APPLIED', 0);
INSERT INTO exam_application (id, student_id, course_id, status, points) VALUES (2, 1, 2, 'PASSED', 95);

-- 15) TermTopic (needs course_id)

-- Mathematics 1 (course_id = 1)
INSERT INTO term_topic (id, description, term_number, course_id) VALUES (1,  'Limits and continuity',                      1, 1);
INSERT INTO term_topic (id, description, term_number, course_id) VALUES (2,  'Derivatives: rules and applications',        2, 1);
INSERT INTO term_topic (id, description, term_number, course_id) VALUES (3,  'Integrals: techniques and applications',     3, 1);
INSERT INTO term_topic (id, description, term_number, course_id) VALUES (4,  'Sequences and series (intro)',               4, 1);

-- Programming 1 (course_id = 2)
INSERT INTO term_topic (id, description, term_number, course_id) VALUES (5,  'Java basics: syntax, types, I/O',            1, 2);
INSERT INTO term_topic (id, description, term_number, course_id) VALUES (6,  'Control flow: if/switch, loops',             2, 2);
INSERT INTO term_topic (id, description, term_number, course_id) VALUES (7,  'Methods and parameters; debugging',          3, 2);
INSERT INTO term_topic (id, description, term_number, course_id) VALUES (8,  'Arrays and basic collections',               4, 2);

-- Databases (course_id = 3)
INSERT INTO term_topic (id, description, term_number, course_id) VALUES (9,  'Relational model, ER → relational',          1, 3);
INSERT INTO term_topic (id, description, term_number, course_id) VALUES (10, 'SQL DDL/DML: CREATE/INSERT/UPDATE/DELETE',   2, 3);
INSERT INTO term_topic (id, description, term_number, course_id) VALUES (11, 'JOINS & aggregation (GROUP BY/HAVING)',      3, 3);
INSERT INTO term_topic (id, description, term_number, course_id) VALUES (12, 'Normalization and keys; anomalies',          4, 3);

-- 16) DocumentRequest (needs student_id + staff_id)
INSERT INTO document_request (id, student_id, document_type, purpose, status, request_date) VALUES (1, 1, 'STUDENT_STATUS', 'Potvrda o statusu studenta za ambasadorsku vizu', 'PENDING', NOW());
INSERT INTO document_request (id, student_id, document_type, purpose, status, request_date) VALUES (2, 6, 'TRANSCRIPT', 'Uverenje o položenim ispitima za prebacivanje na drugi fakultet', 'APPROVED', '2025-09-10 10:00:00');
INSERT INTO document_request (id, student_id, document_type, purpose, status, request_date) VALUES (3, 7, 'VISA_CONFIRMATION', 'Potvrda za studentsku vizu', 'PENDING', NOW());
INSERT INTO document_request (id, student_id, document_type, purpose, status, request_date) VALUES (4, 8, 'OTHER', 'Uverenje o proseku ocena', 'REJECTED', NOW());


-- Povezivanje odobrenog i odbijenog zahteva sa članom osoblja koji ih je obradio
UPDATE document_request SET completion_date = '2025-09-12 12:00:00', staff_id = 20 WHERE id = 2;
UPDATE document_request SET completion_date = '2025-09-13 13:30:00', staff_id = 20 WHERE id = 4;


-- 17) ExamPeriod
-- Kreiramo aktivan ispitni rok, npr. Septembarski 2025, koji traje od 01.10.2025 do 31.10.2025
-- (Ovaj rok će biti vidljiv u aplikaciji)
INSERT INTO exam_period (id, name, start_date, end_date) VALUES 
(1, 'Septembarski 2025 - AKTIVAN', '2025-10-01 00:00:00', '2025-10-31 23:59:59');

-- Kreiramo neaktivan rok (neće biti vidljiv, za proveru filtriranja)
INSERT INTO exam_period (id, name, start_date, end_date) VALUES 
(2, 'Januarski 2025 - NEAKTIVAN', '2025-01-01 00:00:00', '2025-01-31 23:59:59');


-- 18) ExamTerm (Termini se vezuju za ispite koji su studentu ENROLLED, npr. Mathematics 1 i Databases)

-- Termini za Mathematics 1 (course name = 'Mathematics 1', course_id=1) u AKTIVNOM ROKU (id=1)
INSERT INTO exam_term (id, name, exam_date, period_id, course_name, professor_id, room_number) VALUES 
(1, 'Matematika 1 - Pismeni (15.10.)', '2025-10-15 10:00:00', 1, 'Mathematics 1', 2, 'A1'); 

-- Termini za Databases (course name = 'Databases', course_id=3) u AKTIVNOM ROKU (id=1)
INSERT INTO exam_term (id, name, exam_date, period_id, course_name, professor_id, room_number) VALUES 
(2, 'Baze podataka - Usmeni (20.10.)', '2025-10-20 14:00:00', 1, 'Databases', 3, 'B5'); 

-- Termin za Programming 1 (course name = 'Programming 1', course_id=2). Student1 je položio ovaj predmet (ocena 10), pa ga neće prijavljivati
INSERT INTO exam_term (id, name, exam_date, period_id, course_name, professor_id, room_number) VALUES 
(3, 'Programiranje 1 - Pismeni (25.10.)', '2025-10-25 12:00:00', 1, 'Programming 1', 2, 'C2');

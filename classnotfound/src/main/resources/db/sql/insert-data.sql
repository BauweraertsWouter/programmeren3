INSERT INTO user (use_name, use_email, use_password)
  VALUES ('lars', 'lars@somehost.com', 'lars');
INSERT INTO user (use_name, use_email, use_password)
  VALUES ('rudy', 'rudy@somehost.com', 'rudy');
INSERT INTO user (use_name, use_email, use_password)
  VALUES ('marcel', 'marcel@somehost.com', 'marcel');
INSERT INTO user (use_name, use_email, use_password)
  VALUES ('jos', 'jos@somehost.com', 'jos');
INSERT INTO user (use_name, use_email, use_password)
  VALUES ('pedro', 'pedro@somehost.com', 'pedro');

INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Hoe laat is het?', 'Graag zo snel mogelijk antwoord!', 20, '2016-08-30 14:47:00',
          SELECT use_id FROM user WHERE use_name = 'lars');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Hoe werkt Spring?', 'Graag zo snel mogelijk antwoord!', 16, '2016-08-30 11:34:00',
          SELECT use_id FROM user WHERE use_name = 'jos');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Wat is Gradle?', 'Graag zo snel mogelijk antwoord!', 45, '2016-08-30 10:29:00',
          SELECT use_id FROM user WHERE use_name = 'rudy');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Waarom gebruiken we geen Maven?', 'Graag zo snel mogelijk antwoord!', 10, '2016-08-30 18:18:00',
          SELECT use_id FROM user WHERE use_name = 'marcel');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Wat is een repository?', 'Graag zo snel mogelijk antwoord!', 9, '2016-08-30 05:41:00',
          SELECT use_id FROM user WHERE use_name = 'pedro');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Hoe werkt de @Component tag?', 'Graag zo snel mogelijk antwoord!', 78, '2016-08-30 14:22:00',
          SELECT use_id FROM user WHERE use_name = 'lars');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Hoe werkt de @Bean tag?', 'Graag zo snel mogelijk antwoord!', 34, '2016-08-30 16:00:00',
          SELECT use_id FROM user WHERE use_name = 'jos');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Wat is een controller?', 'Graag zo snel mogelijk antwoord!', 65, '2016-08-30 09:43:00',
          SELECT use_id FROM user WHERE use_name = 'rudy');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Hoe kan ik in Thymeleaf X Y Z doen?', 'Graag zo snel mogelijk antwoord!', 12, '2016-08-30 00:34:00',
          SELECT use_id FROM user WHERE use_name = 'marcel');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Wat is de standaard directory structuur van een Maven/Gradle project?', 'Graag zo snel mogelijk antwoord!', 4, '2016-08-30 21:15:00',
          SELECT use_id FROM user WHERE use_name = 'pedro');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Help, mijn SpEL expressie werkt niet...', 'Graag zo snel mogelijk antwoord!', 55, '2016-08-30 15:12:00',
          SELECT use_id FROM user WHERE use_name = 'lars');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Waar kan ik de Tomcat log files vinden?', 'Graag zo snel mogelijk antwoord!', 24, '2016-08-30 16:35:00',
          SELECT use_id FROM user WHERE use_name = 'jos');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Hoe configureer ik Spring MVC?', 'Graag zo snel mogelijk antwoord!', 14, '2016-08-30 13:45:00',
          SELECT use_id FROM user WHERE use_name = 'rudy');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Hoe zet ik mijn project om naar Spring Boot?', 'Graag zo snel mogelijk antwoord!', 62, '2016-08-30 17:08:00',
          SELECT use_id FROM user WHERE use_name = 'marcel');
INSERT INTO question_answer (qa_subject, qa_body, qa_score, qa_timestamp, qa_use_id)
  VALUES ('Mijn .war file werkt niet.... Help! :(', 'Graag zo snel mogelijk antwoord!', 30, '2016-08-30 10:45:00',
          SELECT use_id FROM user WHERE use_name = 'pedro');
